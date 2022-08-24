package ponti.edu.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FactorialActivity extends AppCompatActivity {

    Integer factor;
    TextView texto;
    @Override
    public void onBackPressed(){
        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("c",MainActivity.c);
        intent.putExtra("f",MainActivity.f);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        factor = getIntent().getIntExtra("fac",1);
        String operacion = generarCadenaOperacion(factor);
        Long resultado = generarCadenaResultado(factor);
        texto = findViewById(R.id.frameText);
        texto.setText("Operacion: "+operacion+"\n"+"Resultado: "+resultado);
    }
    private Long generarCadenaResultado(Integer factor) {
        Long factorial = 1l;
        for (int i=factor;i>0;i--)
        {
            factorial=factorial*i;
        }
        return factorial;
    }
    private String generarCadenaOperacion(Integer factor) {
        String cadena="1";
        for(int i=1; i<factor;i++){
            cadena=cadena+"*"+(i+1);
        }
        return cadena;
    }
}