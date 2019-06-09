package com.example.unit01;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

public class Piano_class extends AppCompatActivity {

    SoundPool piano_pool;
    int d1;
    int re;
    int mi;
    int pa;
    int sol;
    int ra;
    int si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win=getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_piano);

        piano_pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        d1=piano_pool.load(this,R.raw.d1,1);
        re=piano_pool.load(this,R.raw.re,1);
        mi=piano_pool.load(this,R.raw.mi,1);
        pa=piano_pool.load(this,R.raw.pa,1);
        sol=piano_pool.load(this,R.raw.sol,1);
        ra=piano_pool.load(this,R.raw.ra,1);
        si=piano_pool.load(this,R.raw.si,1);
    }
    public void mOnClick(View v){

        switch(v.getId())
        {
            case R.id.button_do:
                piano_pool.play(d1,1,1,0,0,1);
                break;
            case R.id.button_si:
                piano_pool.play(si,1,1,0,0,1);
                break;
            case R.id.button_ra:
                piano_pool.play(ra,1,1,0,0,1);
                break;
            case R.id.button_sol:
                piano_pool.play(sol,1,1,0,0,1);
                break;
            case R.id.button_pa:
                piano_pool.play(pa,1,1,0,0,1);
                break;
            case R.id.button_mi:
                piano_pool.play(mi,1,1,0,0,1);
                break;
            case R.id.button_re:
                piano_pool.play(re,1,1,0,0,1);
                break;
            case R.id.button_b1:
                piano_pool.play(re,1,1,0,0,1);
                break;
            case R.id.button_b2:
                piano_pool.play(si,1,1,0,0,1);
                break;
            case R.id.button_b3:
                piano_pool.play(ra,1,1,0,0,1);
                break;
            case R.id.button_b4:
                piano_pool.play(pa,1,1,0,0,1);
                break;
            case R.id.button_b5:
                piano_pool.play(mi,1,1,0,0,1);
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 29) {                //키코드 A
            piano_pool.play(d1,1,1,0,0,1);
        }
        else if (keyCode == 32) {           //키코드 D
            piano_pool.play(si,1,1,0,0,1);
        }
        else if (keyCode == 34) {           //키코드 F
            piano_pool.play(ra,1,1,0,0,1);
        }
        else if (keyCode == 35) {           //키코드 G
            piano_pool.play(sol,1,1,0,0,1);
        }
        else if (keyCode == 36) {           //키코드 H
            piano_pool.play(pa,1,1,0,0,1);
        }
        else if (keyCode == 38) {           //키코드 J
            piano_pool.play(mi,1,1,0,0,1);
        }
        else if (keyCode == 51) {           //키코드 W
            piano_pool.play(re,1,1,0,0,1);
        }
        else if (keyCode == 33) {           //키코드 E
            piano_pool.play(re,1,1,0,0,1);
        }
        else if (keyCode == 48) {           //키코드 T
            piano_pool.play(si,1,1,0,0,1);
        }
        else if (keyCode == 53) {           //키코드 Y
            piano_pool.play(ra,1,1,0,0,1);
        }
        else if (keyCode == 49) {           //키코드 U
            piano_pool.play(pa,1,1,0,0,1);
        }
        else if (keyCode == 62 ) {          //키코드 SPACE BAR
            piano_pool.play(mi,1,1,0,0,1);
        }
        else if(keyCode == event.KEYCODE_BACK){
            Log.d("백키", "onKeyDown: 종료");
        }

        return true;
    }

}
