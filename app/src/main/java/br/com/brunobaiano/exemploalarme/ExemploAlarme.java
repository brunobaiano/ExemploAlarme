package br.com.brunobaiano.exemploalarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class ExemploAlarme extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_alarme);

        agendarPara10Segundos();
    }

    private void agendarPara10Segundos() {
        Intent intencao = new Intent("ALARME_TESTE");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intencao,0);

        long agendamentoEmMilis = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime()) + 10;
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,TimeUnit.SECONDS.toMillis(agendamentoEmMilis),pendingIntent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent it = new Intent("ALARME_TESTE");
        PendingIntent pi = PendingIntent.getBroadcast(this,0,it,0);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        manager.cancel(pi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exemplo_alarme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
