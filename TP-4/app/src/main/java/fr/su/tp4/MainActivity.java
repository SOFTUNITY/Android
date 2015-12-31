package fr.su.tp4;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadCastReceiver myreceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button call = (Button)findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), GivePhoneNumber.class);
                startActivity(login);
            }});
        Button info = (Button)findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(),GivePhoneNumber.class);
                startActivityForResult(login,48);
            }});
        // Broadcast receiver dynamique
        myreceiver = new BroadCastReceiver();
        IntentFilter filtre = new IntentFilter("su.fr.broadcast");
        registerReceiver(myreceiver, filtre);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 48)
            Toast.makeText(this, "Code de requête récupéré (je sais d'ou je viens)", Toast.LENGTH_LONG).show();
        if (resultCode == 50)
            Toast.makeText(this, "Code de retour ok (on m'a renvoyé le bon code)", Toast.LENGTH_LONG).show();
    }

}
