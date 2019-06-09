package com.example.unit01;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class Guitar_class extends Activity {

    SoundPool guitar_pool;

    private float y;
    private float pre_y;
    private int code = 0;
    private int area = 100;
    private ImageButton C;
    private ImageButton F;
    private ImageButton G;
    private ImageButton Am;

    private int C1,C2,C3,C4,C5,C6,Am1,Am2,Am3,Am4,Am5,Am6,F1,F2,F3,F4,F5,F6,G1,G2,G3,G4,G5,G6;

    /////
    private Context mContext;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private ImageButton buttonCloseDrawer;
    private LinearLayout instrumentView;
    private PopupWindow mPopupWindow;
    private LinearLayout mLinearlayout;
    ///


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar); //여기 XML파일(activity_main)에 설정된대로 화면이 구성됨


        ///////////////
//        mContext = getApplicationContext();
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerView = (View) findViewById(R.id.drawer);
//        instrumentView = (LinearLayout) findViewById(R.id.instrument_layout);
//        mLinearlayout = (LinearLayout)findViewById(R.id.instrument_layout) ;
//
//        buttonCloseDrawer = (ImageButton) findViewById(R.id.play);
//        buttonCloseDrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
//                View customView = inflater.inflate(R.layout.custom_layout,null);
//                mPopupWindow = new PopupWindow(
//                        customView,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT
//                );
//                if(Build.VERSION.SDK_INT>=22){
//                    mPopupWindow.setElevation(5.0f);
//                }
//
//                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
//
//                // Set a click listener for the popup window close button
//                closeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Dismiss the popup window
//                        mPopupWindow.dismiss();
//                    }
//                });
//
//                mPopupWindow.showAtLocation(mLinearlayout, Gravity.CENTER,0,0);
//
//            }
//        });


        ///////////////

        C = (ImageButton)findViewById(R.id.code_c);
        F = (ImageButton)findViewById(R.id.code_f);
        G = (ImageButton)findViewById(R.id.code_g);
        Am = (ImageButton)findViewById(R.id.code_am);


        C.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: C");
                code = 0;
            }
        });
        F.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: F");
                code = 1;
            }
        });
        G.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: G");
                code = 2;
            }
        });
        Am.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Am");
                code = 3;
            }
        });


        guitar_pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);

        C1 = guitar_pool.load(this,R.raw.guitar_c1,1);
        C2 = guitar_pool.load(this,R.raw.guitar_c2,1);
        C3 = guitar_pool.load(this,R.raw.guitar_c3,1);
        C4 = guitar_pool.load(this,R.raw.guitar_c4,1);
        C5 = guitar_pool.load(this,R.raw.guitar_c5,1);
        C6 = guitar_pool.load(this,R.raw.guitar_c6,1);

        F1 = guitar_pool.load(this,R.raw.guitar_f1,1);
        F2 = guitar_pool.load(this,R.raw.guitar_f2,1);
        F3 = guitar_pool.load(this,R.raw.guitar_f3,1);
        F4 = guitar_pool.load(this,R.raw.guitar_f4,1);
        F5 = guitar_pool.load(this,R.raw.guitar_f5,1);
        F6 = guitar_pool.load(this,R.raw.guitar_f6,1);

        G1 = guitar_pool.load(this,R.raw.guitar_g1,1);
        G2 = guitar_pool.load(this,R.raw.guitar_g2,1);
        G3 = guitar_pool.load(this,R.raw.guitar_g3,1);
        G4 = guitar_pool.load(this,R.raw.guitar_g4,1);
        G5 = guitar_pool.load(this,R.raw.guitar_g5,1);
        G6 = guitar_pool.load(this,R.raw.guitar_g6,1);

        Am1 = guitar_pool.load(this,R.raw.guitar_a1,1);
        Am2 = guitar_pool.load(this,R.raw.guitar_a2,1);
        Am3 = guitar_pool.load(this,R.raw.guitar_a3,1);
        Am4 = guitar_pool.load(this,R.raw.guitar_a4,1);
        Am5 = guitar_pool.load(this,R.raw.guitar_a5,1);
        Am6 = guitar_pool.load(this,R.raw.guitar_a6,1);

    }

    ////////////////////////
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == 1) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    /////////////////////////
    @Override
            public boolean onTouchEvent(MotionEvent event) {
                y = event.getRawY();
                switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                Log.d("Touch", "onTouch: ACTION Down");

            break;
            case MotionEvent.ACTION_MOVE :
                Log.d("Touch", "onTouch: ACTION MOVE");
                Log.d("Touch","onTouch: y"+ y);
                if(Math.abs(y-pre_y)>150) {
                    if (Math.abs(y - 280) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C1, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F1, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G1, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am1, 1, 1, 0, 0, 1);
                                break;
                        }
                    } else if (Math.abs(y - 450) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C2, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F2, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G2, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am2, 1, 1, 0, 0, 1);
                                break;
                        }
                    } else if (Math.abs(y - 650) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C3, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F3, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G3, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am3, 1, 1, 0, 0, 1);
                                break;
                        }
                    } else if (Math.abs(y - 800) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C4, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F4, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G4, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am4, 1, 1, 0, 0, 1);
                                break;
                        }
                    } else if (Math.abs(y - 960) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C5, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F5, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G5, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am5, 1, 1, 0, 0, 1);
                                break;
                        }
                    } else if (Math.abs(y - 1130) < area) {
                        switch (code) {
                            case 0:
                                guitar_pool.play(C6, 1, 1, 0, 0, 1);
                                break;
                            case 1:
                                guitar_pool.play(F6, 1, 1, 0, 0, 1);
                                break;
                            case 2:
                                guitar_pool.play(G6, 1, 1, 0, 0, 1);
                                break;
                            case 3:
                                guitar_pool.play(Am6, 1, 1, 0, 0, 1);
                                break;
                        }
                    }
                    pre_y = y;
                }
                break;
            case MotionEvent.ACTION_UP :
                Log.d("Touch", "onTouch: ACTION UP");
                pre_y = 0;
                break;
        }
        return true;
    }
}
