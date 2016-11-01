package miguelangel.ucam.edu.appcompleta;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpciones extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

        final Button botonLlamadaTlf = (Button)findViewById(R.id.btnLlamadaTlf);
        botonLlamadaTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamadaTelefono();
            }
        });

        final Button botonBuscarEnGoogle = (Button)findViewById(R.id.btnBuscarEnGoogle);
        botonBuscarEnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEnGoogle();
            }
        });

        final Button botonEnviarEmail = (Button)findViewById(R.id.btnEnviarEmail);
        botonEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarCorreo();
            }
        });

        final Button botonVerMapa = (Button)findViewById(R.id.btnVerMapa);
        botonVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verMapa();
            }
        });

        final Button botonSacarFoto = (Button)findViewById(R.id.btnSacarFoto);
        botonSacarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sacarFoto();
            }
        });

    }

    private void buscarEnGoogle() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        startActivity(intent);
    }

    private void llamadaTelefono() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void mandarCorreo() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"miguelm37@gmail.com"});
        startActivity(intent);
    }

    private void verMapa() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:37.992119,-1.186484"));
        startActivity(intent);
    }

    private void sacarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

}
