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
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.support.v4.widget.DrawerLayout;
import android.view.*;
import android.widget.TextView;

import java.util.ArrayList;

public class Maracas_class extends Activity implements SensorEventListener, View.OnClickListener{

    SoundPool maracas_pool;
    int chaka1;
    int chaka2;

    private SensorManager sensorManager;
    private float[] accelerometer = new float[3];
    private float[] pre_sensor = new float[2];
    private float area1;
    private float area2;

    private ImageView img;
    int val=0;
    /////////////////////////////////////
    int recordFlag;
    Button assembleButton;
    Button beatButton;
    ImageButton playButton;
    ImageButton recordButton;
    long tStart=0;
    long tEnd =0;
    long temp1 =0;
    long temp2 =0;
    ArrayList timeArray = new ArrayList();
    ExampleThread playThread = new ExampleThread();

    public class tick{
        int id;
        long time;
        tick(int i, long t){
            id = i;
            time = t;
        }
    }
//////////////////////////////////////////
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

        /////////////
        recordButton = (ImageButton)findViewById(R.id.record);
        playButton = (ImageButton)findViewById(R.id.play);

        recordButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        ////////////////////


    }

    ///////////////////////////
    private class ExampleThread extends Thread {
        private static final String TAG = "ExampleThread";
        public ExampleThread() {
        // 초기화 작업
        }
        public void run() {
            // 스레드에게 수행시킬 동작들 구현
            int num = timeArray.size();
            Log.d ("1record","재생:"+timeArray.size());
            int i=0;
            temp1 = System.currentTimeMillis();
            tick temp3;
            while(true){
                Log.d ("1record","재생:"+i);
                if(i==num) {
                    Log.d ("1record","break:"+i);
                    break;
                }
                temp2 = System.currentTimeMillis() - temp1;
                temp3 = (tick)timeArray.get(i);
                if(temp2 >= temp3.time){
                    maracas_pool.play(chaka1,1,1,0,0,1);
                    i++;
                    Log.d ("1record","i++:"+i);
                }
            }
            timeArray.clear();
        }
    }


    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.record:
                if(recordFlag ==0){
                    tStart= System.currentTimeMillis();
                    recordFlag = 1;
                    recordButton.setImageResource(R.drawable.boy);
                    break;
                }
                else {
                    tEnd= System.currentTimeMillis();
                    recordFlag = 0;
                    recordButton.setImageResource(R.drawable.button_record);
                    break;
                }

            case R.id.play:
                playThread.run();
                break;
        }
    }
////////////////////////////////




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
        if(area1  > 10){
            Log.d("swing", "onSensorChanged: 1번");
            img.setImageResource(R.drawable.mara2);
            maracas_pool.play(chaka1,1,1,0,0,1);
            area1 = 0;
            /////////////////////////////////
            if(recordFlag ==1){
                tEnd= System.currentTimeMillis();
                timeArray.add(new tick(1,(tEnd-tStart)));

                Log.d ("1record",""+timeArray.size());
            }
        }
        /*
        else if(Math.abs(area2)  > 10){
            Log.d("swing", "onSensorChanged: 2번");
            img.setImageResource(R.drawable.mara3);
            maracas_pool.play(chaka2,1,1,0,0,1);
            area2 = 0;
            /////////////////////////////////
            if(recordFlag ==1){
                tEnd= System.currentTimeMillis();
                timeArray.add(new tick(1,(tEnd-tStart)));
                Log.d ("1record",""+timeArray.size()) ;
            }
        }*/
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


}
