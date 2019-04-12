package app.magma.fzbwidget;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import app.magma.fzbwidget.widget.CompassView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private CompassView compassView;
    private SensorManager manager;
    private Sensor sensor;
    private float l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassView = findViewById(R.id.compass);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
         manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onDestroy() {
        manager.unregisterListener(this,sensor);
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        compassView.setAngle(event.values);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"AAA");
        menu.add(0,1,1,GyroscopeSensorActivity.class.getSimpleName());
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Toast.makeText(this,"dddddd",Toast.LENGTH_SHORT).show();
                break;
                case 1:
                    startActivity(new Intent(this,GyroscopeSensorActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
