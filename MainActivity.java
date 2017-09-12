package ittepic.edu.mx.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String NAME="NAME";
    private EditText mEditTextName;
    private EditText edt_nom,edt_email,edt_ctrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_ctrl=(EditText) findViewById(R.id.edt_noCtrl);
        edt_nom=(EditText)findViewById(R.id.edt_nom);
        edt_email=(EditText) findViewById(R.id.edt_correo);
        final TextView textView = (TextView)findViewById(R.id.txt_datos);
        final SharedPreferences[] sharedPreferences = {getPreferences(MODE_PRIVATE)};
        final String[] texto = {sharedPreferences[0].getString(NAME, null)};
        if (texto[0] ==null) {textView.setText("Agregue Alumno");}
        else {textView.setText("--> " + texto[0]);}
        final Button btn_save =(Button)findViewById(R.id.btn_guardar);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText(btn_save);
            }
        });
        Button btn_rec=(Button) findViewById(R.id.btn_obt);
        btn_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences[0] = getPreferences(MODE_PRIVATE);
                texto[0] = sharedPreferences[0].getString(NAME,null);
                textView.setText("--> " + texto[0]);
            }
        });

    }
    public void saveText(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        String valor="Nombre: "+edt_nom.getText().toString()+"\nNo ctrl:"+
                edt_ctrl.getText().toString()+"\nCorreo: "+edt_email.getText().toString();
        editor.putString(NAME, valor);
        editor.commit();
    }
}
