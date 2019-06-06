package com.example.zebal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.roboid.robot.Device;
import org.roboid.robot.Robot;
import org.smartrobot.android.RobotActivity;

import java.util.ArrayList;

import kr.robomation.physical.Albert;

public class MainActivity extends AppCompatActivity {

    SoundPool pool;
    int d1;
    int d2;
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

        setContentView(R.layout.activity_main);

        pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        d1=pool.load(this,R.raw.d1,1);
        d2=pool.load(this,R.raw.d2,1);
        re=pool.load(this,R.raw.re,1);
        mi=pool.load(this,R.raw.mi,1);
        pa=pool.load(this,R.raw.pa,1);
        sol=pool.load(this,R.raw.sol,1);
        ra=pool.load(this,R.raw.ra,1);
        si=pool.load(this,R.raw.si,1);
    }
    public void mOnClick(View v){

        switch(v.getId())
        {
            case R.id.button_d1:
                pool.play(d1,1,1,0,0,1);
                break;
            case R.id.button_d2:
                pool.play(d2,1,1,0,0,1);
                break;
            case R.id.button_si:
                pool.play(si,1,1,0,0,1);
                break;
            case R.id.button_ra:
                pool.play(ra,1,1,0,0,1);
                break;
            case R.id.button_sol:
                pool.play(sol,1,1,0,0,1);
                break;
            case R.id.button_pa:
                pool.play(pa,1,1,0,0,1);
                break;
            case R.id.button_mi:
                pool.play(mi,1,1,0,0,1);
                break;
            case R.id.button_re:
                pool.play(re,1,1,0,0,1);
                break;
            case R.id.button_b1:
                pool.play(re,1,1,0,0,1);
                break;
            case R.id.button_b2:
                pool.play(si,1,1,0,0,1);
                break;
            case R.id.button_b3:
                pool.play(ra,1,1,0,0,1);
                break;
            case R.id.button_b4:
                pool.play(pa,1,1,0,0,1);
                break;
            case R.id.button_b5:
                pool.play(mi,1,1,0,0,1);
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 29) {                //키코드 A
            pool.play(d1,1,1,0,0,1);
        }
        else if (keyCode == 47) {           //키코드 S
            pool.play(d2,1,1,0,0,1);
        }
        else if (keyCode == 32) {           //키코드 D
            pool.play(si,1,1,0,0,1);
        }
        else if (keyCode == 34) {           //키코드 F
            pool.play(ra,1,1,0,0,1);
        }
        else if (keyCode == 35) {           //키코드 G
            pool.play(sol,1,1,0,0,1);
        }
        else if (keyCode == 36) {           //키코드 H
            pool.play(pa,1,1,0,0,1);
        }
        else if (keyCode == 38) {           //키코드 J
            pool.play(mi,1,1,0,0,1);
        }
        else if (keyCode == 51) {           //키코드 W
            pool.play(re,1,1,0,0,1);
        }
        else if (keyCode == 33) {           //키코드 E
            pool.play(re,1,1,0,0,1);
        }
        else if (keyCode == 48) {           //키코드 T
            pool.play(si,1,1,0,0,1);
        }
        else if (keyCode == 53) {           //키코드 Y
            pool.play(ra,1,1,0,0,1);
        }
        else if (keyCode == 49) {           //키코드 U
            pool.play(pa,1,1,0,0,1);
        }
        else if (keyCode == 62 ) {          //키코드 SPACE BAR
            pool.play(mi,1,1,0,0,1);
        }
        else {                              //나머지
            pool.play(mi,1,1,0,0,1);
        }
        return true;
    }
}




