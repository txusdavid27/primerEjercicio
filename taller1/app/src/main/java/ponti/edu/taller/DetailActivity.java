package ponti.edu.taller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    TextView capital;
    TextView pais;
    TextView nombreInt;
    TextView sigla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Pais info= (Pais) getIntent().getSerializableExtra("pais");
        capital= findViewById(R.id.textCapital);
        pais= findViewById(R.id.textPais);
        nombreInt= findViewById(R.id.textInternacional);
        sigla= findViewById(R.id.textSigla);

        capital.setText(info.getCapital());
        pais.setText(info.getNombre_pais());
        nombreInt.setText(info.getNombre_pais_int());
        sigla.setText(info.getSigla());

        String url=info.getBandera();
        new DownloadImageTask((ImageView) findViewById(R.id.imageBandera))
                .execute(url);


    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public  DownloadImageTask(ImageView bmImage){this.bmImage=bmImage;}

        protected Bitmap doInBackground(String... urls){
            String urldisplay = urls[0];
            Bitmap mIcon11=null;
            InputStream in = null;
            try {
                in = new java.net.URL(urldisplay).openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mIcon11= BitmapFactory.decodeStream(in);
            return mIcon11;
        }
        protected void onPostExecute(Bitmap result){ bmImage.setImageBitmap(result);}
    }
}