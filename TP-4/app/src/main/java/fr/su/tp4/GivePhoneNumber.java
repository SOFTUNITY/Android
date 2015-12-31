package fr.su.tp4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jean-Noel on 28/12/2015.
 */
public class GivePhoneNumber extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.givephonenumber);

        // Bouton ok
        Button b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText number = (EditText) findViewById(R.id.number);
                Uri telnumber = Uri.parse("tel:" + number.getText().toString());
                Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
                startActivity(call);
            }
        });
        // Bouton finish
        Button finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(50);
                finish();
            }
        });

        // Bouton appel direct
        Button direct = (Button) findViewById(R.id.direct);
        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText number = (EditText) findViewById(R.id.number);
                Uri telnumber = Uri.parse("tel:" + number.getText().toString());
                Intent call = new Intent(Intent.ACTION_CALL, telnumber);
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(call);
                }
            }
        });

        // Bouton broadcast
        Button broad = (Button) findViewById(R.id.broadcast);
        broad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent broadcast = new Intent("su.fr.broadcast");
                broadcast.putExtra("extra", "test");
                sendBroadcast(broadcast);
            }
        });

        // Bouton pour s'auto appeler
        Button autoinvoc = (Button) findViewById(R.id.autoinvoc);
        autoinvoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent("su.fr.nom_du_message");
                call.putExtra("extra", "test");
                startActivity(call);
            }
        });
    }
}
