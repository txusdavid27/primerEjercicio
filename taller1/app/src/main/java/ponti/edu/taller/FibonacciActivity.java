package ponti.edu.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FibonacciActivity extends AppCompatActivity {

    private LinearLayout linear;
    ImageButton image;
    private ArrayList<Integer> numerosfib= new ArrayList<>();
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
        setContentView(R.layout.activity_fibonacci);
        Integer pos= getIntent().getIntExtra ("cant",0);//le paso la info.
        linear= findViewById(R.id.lista);
        image=findViewById(R.id.image);
        initFibo(pos);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(FibonacciActivity.this,WebActivity.class);
                    startActivity(intent);
                }catch (Exception e){}
            }
        });
    }
    //llenar de fibonacci.
    private void initFibo(Integer pos) {
        Integer num1 = 0, num2 = 1,num3;
        for(int c=0;c<pos+1;c++){
            numerosfib.add(num1);
            num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        for (Integer i: numerosfib){
            TextView txtView= new TextView(this);
            txtView.setText("" + i);
            txtView.setId(i);
            txtView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) linear).addView(txtView);
        }
    }

}