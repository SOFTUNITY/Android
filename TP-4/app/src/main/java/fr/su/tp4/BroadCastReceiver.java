package fr.su.tp4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Jean-Noel on 28/12/2015.
 */
public class BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        if (extra != null)
        {
            String val = extra.getString("extra");
            Toast.makeText(context, "Broadcast message received: " + val, Toast.LENGTH_SHORT).show();
        }
    }
}
