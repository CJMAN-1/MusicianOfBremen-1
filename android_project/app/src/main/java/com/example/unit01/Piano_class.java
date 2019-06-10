package com.example.unit01;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Piano_class extends AppCompatActivity {

    SoundPool piano_pool;
    int d1;
    int re;
    int mi;
    int pa;
    int sol;
    int ra;
    int si;
    int dosharp;
    int resharp;
    int pasharp;
    int solsharp;
    int rasharp;
    private ImageButton PianoChange;
    private ImageButton GuitarChange;
    private ImageButton MaracasChange;
    private Intent intent1;
    private Intent intent2;
    private Intent intent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win=getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_piano);

        piano_pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        d1 = piano_pool.load(this,R.raw.white2,1);
        re = piano_pool.load(this,R.raw.white3,1);
        mi = piano_pool.load(this,R.raw.white1,1);
        pa = piano_pool.load(this,R.raw.white4,1);
        sol = piano_pool.load(this,R.raw.white5,1);
        ra = piano_pool.load(this,R.raw.white6,1);
        si = piano_pool.load(this,R.raw.white7,1);
        dosharp = piano_pool.load(this,R.raw.black1,1);
        resharp = piano_pool.load(this,R.raw.black2,1);
        pasharp = piano_pool.load(this,R.raw.black3,1);
        solsharp = piano_pool.load(this,R.raw.black4,1);
        rasharp = piano_pool.load(this,R.raw.black5,1);

        PianoChange = (ImageButton)findViewById(R.id.piano_change2);
        GuitarChange = (ImageButton)findViewById(R.id.guitar_change2);
        MaracasChange = (ImageButton)findViewById(R.id.maracas_change2);

        PianoChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Piano Changed");
                intent1 = new Intent(Piano_class.this, Piano_class.class);
                startActivity(intent1);
                finish();
            }
        });
        GuitarChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Guitar Changed");
                intent2 = new Intent(Piano_class.this, Guitar_class.class);
                startActivity(intent2);
                finish();
            }
        });
        MaracasChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Maracas Changed");
                intent3 = new Intent(Piano_class.this, Maracas_class.class);
                startActivity(intent3);
                finish();
            }
        });
        //backflag =1;
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
                piano_pool.play(dosharp,1,1,0,0,1);
                break;
            case R.id.button_b2:
                piano_pool.play(resharp,1,1,0,0,1);
                break;
            case R.id.button_b3:
                piano_pool.play(pasharp,1,1,0,0,1);
                break;
            case R.id.button_b4:
                piano_pool.play(solsharp,1,1,0,0,1);
                break;
            case R.id.button_b5:
                piano_pool.play(rasharp,1,1,0,0,1);
                break;
            case R.id.piano_change2:

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
            super.onBackPressed();
        }

        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
