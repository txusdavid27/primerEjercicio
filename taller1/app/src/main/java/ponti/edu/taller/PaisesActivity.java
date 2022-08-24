package ponti.edu.taller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PaisesActivity extends AppCompatActivity {

    ListView listView;

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        listView= findViewById(R.id.listaPaises);
        ArrayList<Pais> paises= new ArrayList<>();
        try {
            JSONObject json = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJsonArray = json.getJSONArray("paises");
            for (int i = 0; i < paisesJsonArray.length(); i++) {
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String capital = jsonObject.getString("capital");
                String n = jsonObject.getString("nombre_pais");
                String ni = jsonObject.getString("nombre_pais_int");
                String sig = jsonObject.getString("sigla");
                String url = jsonObject.getString("bandera");
                Pais nuevo= new Pais(capital,n,ni,sig);
                nuevo.setBandera(url);
                paises.add(nuevo);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<Pais> adapter = new ArrayAdapter<Pais>(this,
                android.R.layout.simple_list_item_1, paises);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(PaisesActivity.this, DetailActivity.class);
                Pais pass= paises.get(position);
                intent.putExtra("pais", pass);
                startActivity(intent);
            }
        });

    }
}