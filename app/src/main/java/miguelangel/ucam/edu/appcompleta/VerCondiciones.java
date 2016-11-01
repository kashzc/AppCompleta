package miguelangel.ucam.edu.appcompleta;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerCondiciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_condiciones);

        final TextView labelCondiciones = (TextView)findViewById(R.id.labelCondiciones);


        final Button botonLeerCondiciones = (Button)findViewById(R.id.btnLeerCondiciones);
        botonLeerCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.ucam.edu";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        final Button botonAceptarCondiciones = (Button)findViewById(R.id.btnAceptarCondiciones);
        botonAceptarCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //labelCondiciones.setText("Condiciones aceptadas");
                aceptarCondiciones();
            }
        });

        final Button botonRechazarCondiciones = (Button)findViewById(R.id.btnRechazarCondiciones);
        botonRechazarCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //labelCondiciones.setText("Condiciones rechazadas");
                rechazarCondiciones();
            }
        });

    }

    private void aceptarCondiciones() {
        Intent intent =new Intent();
        intent.putExtra("condiciones", "OK");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void rechazarCondiciones() {
        Intent intent =new Intent();
        intent.putExtra("condiciones", "NO");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
