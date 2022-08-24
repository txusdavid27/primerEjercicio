package ponti.edu.taller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    Button fibonacci;
    Button factorial;
    Button paises;
    EditText posicion;
    Spinner valores;
    TextView conteo;
    public static Integer c=0;
    public static String f="";
    public static final String EXTRA_MESSAGE = "APP_MESSAGE";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String obtenerFechaConFormato() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    @Override
    public void onResume() {
        c=getIntent().getIntExtra("c",0);
        f=getIntent().getStringExtra("f");
        if(f==null){
            f="";
        }else{
            f="-> "+f;
        }
        conteo.setText("Usos: "+c.toString()+f);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conteo= findViewById(R.id.conteo);
        fibonacci= findViewById(R.id.fibonacci);
        factorial=findViewById(R.id.factorial);
        paises=findViewById(R.id.paises);
        posicion=findViewById(R.id.posiciones);
        valores=findViewById(R.id.valores);

        fibonacci.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,FibonacciActivity.class);
                try{
                    Integer cantidad= Integer.parseInt(posicion.getText().toString());
                    intent.putExtra("cant",cantidad);
                }catch (Exception e){}
                intent.putExtra(EXTRA_MESSAGE,"null");
                Log.i(EXTRA_MESSAGE,c.toString());
                c++;
                f=obtenerFechaConFormato();
                startActivity(intent);
                conteo.setText(c.toString());
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,FactorialActivity.class);
                Integer fac= Integer.parseInt(valores.getSelectedItem().toString());
                Log.i(EXTRA_MESSAGE,fac.toString());
                intent.putExtra("fac",fac);
                c++;
                f=obtenerFechaConFormato();
                startActivity(intent);
                conteo.setText(c.toString());
            }
        });

        valores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)

            {
                Toast.makeText(getBaseContext(), "El item seleccionado es: "+
                                valores.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        paises.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,PaisesActivity.class);
                startActivity(intent);
            }
        });

    }
}