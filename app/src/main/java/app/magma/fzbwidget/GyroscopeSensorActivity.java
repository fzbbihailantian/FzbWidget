package app.magma.fzbwidget;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.magma.fzbwidget.widget.GyroscopeView;

/**
 * 陀螺仪
 */
public class GyroscopeSensorActivity extends AppCompatActivity implements SensorEventListener {
GyroscopeView gyroscopeView;
    private SensorManager manager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_sensor);
        gyroscopeView = findViewById(R.id.gyroscope);
        init();
    }

    private void init() {
        manager=(SensorManager)getSystemService(SENSOR_SERVICE);
         sensor = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        gyroscopeView.setAngleValue(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        manager.unregisterListener(this,sensor);
        super.onDestroy();
    }
}
