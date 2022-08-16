package ponti.edu.myapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText campo;
    Button boton;
    TextView mensaje;
    private Integer ale;
    private int contador=0;
    public static final String APP_NAME="NUEVA_SUPER_APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=findViewById(R.id.button);
        mensaje=findViewById(R.id.mensaje);
        campo=findViewById(R.id.guess);
        ale= (int)(Math.random()*5+1);
        System.out.println(ale);
        Log.i(APP_NAME,"EL ALEATORIO ES "+ ale);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(Integer.parseInt(campo.getText().toString())==ale){
                        mensaje.setText("Bien hecho!");
                    }else{
                        contador++;
                        mensaje.setText("Mal hecho:(");
                        mensaje.setText("");
                    }

                }catch (Exception e){}
            }
        });
    }
}