package miguelangel.ucam.edu.appcompleta;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonVerCondiciones = (Button)findViewById(R.id.btnVerCondiciones);
        botonVerCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verCondiciones();
            }
        });

        final Button botonEntrar = (Button) findViewById(R.id.btnEntrar);
        final EditText txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        final EditText txtPass = (EditText)findViewById(R.id.txtpassword);
        final TextView lblErrorLogin = (TextView)findViewById(R.id.lblErrorLogin);

        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUsuario.getText().toString();
                String pass = txtPass.getText().toString();

                if(user.equals("aa")&&pass.equals("aaaa")){
                    entrarMenu();
                }
                else {
                    lblErrorLogin.setText("Usuario o contraseña incorrecta");

                }
            }
        });

        final Button botonFragments = (Button)findViewById(R.id.btnFragments);
        botonFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragments();
            }
        });


    }

    private void abrirFragments() {
        Intent intent = new Intent(this, Fragments.class);
        startActivity(intent);
    }

    private void entrarMenu() {
        Intent loguear = new Intent(this, MenuOpciones.class);
        startActivity(loguear);
    }


    private void verCondiciones() {
        Intent intent_verCondiciones = new Intent(this, VerCondiciones.class);
        startActivityForResult(intent_verCondiciones, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final TextView labelAceptaCondiciones = (TextView)findViewById
                (R.id.lblAceptaCondiciones);

        if(requestCode==200 && resultCode==RESULT_OK){
            String condiciones = data.getExtras().getString("condiciones");
            if(condiciones.equals("OK")){
                labelAceptaCondiciones.setText("Condiciones aceptadas");
            }
            if(condiciones.equals("NO")){
                labelAceptaCondiciones.setText("Condiciones rechazadas");

            }
        }
    }
}
