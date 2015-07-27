package br.com.brunobaiano.exemploalarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MeuReceiver extends BroadcastReceiver {
    public MeuReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"UHUU",Toast.LENGTH_SHORT).show();
    }
}
