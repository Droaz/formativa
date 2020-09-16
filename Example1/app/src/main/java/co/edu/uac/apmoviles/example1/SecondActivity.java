package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud, inhabilitar;
    CheckBox Mayus_min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        Mayus_min = (CheckBox) findViewById(R.id.chk_Mayus_min);
        Mayus_min.setOnClickListener(this);
        inhabilitar=findViewById(R.id.btn_inhabilitar);



        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }

    public String invertir(String x){
        String _x = "";
        for (int y=x.length()-1; y>=0;y--){
            _x += x.charAt(y);
        }
        return _x;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
            int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                 break;

            case R.id.btninvertir:
                p1.setText(invertir(p1.getText().toString()));
                p2.setText(invertir(p2.getText().toString()));
                 break;

            case R.id.btnvocales:
                String palabra_pr= p1.getText().toString();
                String palabra_seg= p2.getText().toString();

                p1.setText(palabra_pr.replaceAll("(?iu)[aeiouáéíóúü]", " "));
                p2.setText(palabra_seg.replaceAll("(?iu)[aeiouáéíóúü]", " "));

                break;

            case R.id.chk_Mayus_min:

                String Palabra_1=p1.getText().toString();
                String Palabra_2=p2.getText().toString();

                if(Mayus_min.isChecked()){
                    p1.setText(Palabra_1.toUpperCase());
                    p2.setText(Palabra_2.toUpperCase());
                }else{
                    p1.setText(Palabra_1.toLowerCase());
                    p2.setText(Palabra_2.toLowerCase());
                }
                    break;

            case R.id.btn_inhabilitar:
                if (vocal.getVisibility() == View.GONE){
                    vocal.setVisibility(View.VISIBLE);
                    longitud.setVisibility(View.VISIBLE);
                    invertir.setVisibility(View.VISIBLE);
                    mayor.setVisibility(View.VISIBLE);
                    Mayus_min.setVisibility(View.VISIBLE);
                }else{
                    vocal.setVisibility(View.GONE);
                    longitud.setVisibility(View.GONE);
                    invertir.setVisibility(View.GONE);
                    mayor.setVisibility(View.GONE);
                    Mayus_min.setVisibility(View.GONE);
                }
                break;

        }
    }


}
