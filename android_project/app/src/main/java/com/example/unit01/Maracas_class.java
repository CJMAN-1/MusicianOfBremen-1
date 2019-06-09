package com.example.unit01;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Maracas_class extends android.support.v4.view.ViewPager implements SensorEventListener{

    SoundPool maracas_pool;

    private int chaka1;
    private int chaka2;

    private SensorManager sensorManager;
    private float[] accelerometer = new float[3];
    private float[] pre_sensor = new float[2];
    private float area1;
    private float area2;

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maracas);      //잘 바꾸자 제발

        maracas_pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        chaka1=maracas_pool.load(this,R.raw.chaka_1,1);
        chaka2=maracas_pool.load(this,R.raw.chaka_2,1);

        img = (ImageView)findViewById(R.id.mara);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType())
        {
            case Sensor.TYPE_ACCELEROMETER:
                accelerometer[0] = event.values[0];
                accelerometer[1] = event.values[1];
                accelerometer[2] = event.values[2];
                break;
        }

        area1 = accelerometer[0] - pre_sensor[0];
        area2 = accelerometer[1] - pre_sensor[1];
        if(Math.abs(area1)  > 10){
            Log.d("swing", "onSensorChanged: 1번");
            img.setImageResource(R.drawable.mara2);
            maracas_pool.play(chaka1,1,1,0,0,1);
            area1 = 0;
        }
        else if(Math.abs(area2)  > 10){
            Log.d("swing", "onSensorChanged: 2번");
            img.setImageResource(R.drawable.mara3);
            maracas_pool.play(chaka2,1,1,0,0,1);
            area2 = 0;
        }
        else {
            Log.d("swing", "onSensorChanged: 없음");
            img.setImageResource(R.drawable.mara1);
        }
        pre_sensor[0] = accelerometer[0];
        pre_sensor[1] = accelerometer[1];
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //super.onTouchEvent(event);
        Log.d("Touch", "onTouch: ACTION MOVE");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Touch", "onTouch: ACTION Down");

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Touch", "onTouch: ACTION MOVE");
        }
        return false;
    }
}
