package com.example.unit01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends Activity{

    private ImageButton Exit;
    private ImageButton Piano;
    private ImageButton Guitar;
    private ImageButton Maracas;
    private ImageButton Playlist;

    private static final int Dial_Exit = 1;

    private Intent intent1;
    private Intent intent2;
    private Intent intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //여기 XML파일(activity_main)에 설정된대로 화면이 구성됨

        Exit = (ImageButton) findViewById(R.id.exit);
        Piano = (ImageButton) findViewById(R.id.piano);
        Guitar = (ImageButton) findViewById(R.id.guitar);
        Maracas = (ImageButton) findViewById(R.id.maracas);
        Playlist = (ImageButton) findViewById(R.id.playlist);

        Exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Exit");
                showDialog(Dial_Exit);
            }
        });
        Piano.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Piano");
                intent1 = new Intent(MainActivity.this, Piano_class.class);
                startActivity(intent1);
            }
        });
        Guitar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Guitar");
                intent2 = new Intent(MainActivity.this, Guitar_class.class);
                startActivity(intent2);
            }
        });
        Maracas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Maracas");
                intent3 = new Intent(MainActivity.this, Maracas_class.class);
                startActivity(intent3);
            }
        });
        Playlist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Touch", "onClick: Playlist");
            }
        });


    }


        @Override
        public  void onBackPressed(){
            showDialog(Dial_Exit);
        }


    @Override
    protected Dialog onCreateDialog(int id, Bundle args)
    {
        switch(id)
        {
            case Dial_Exit:
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.title)
                        .setMessage(R.string.message)
                        .setIcon(R.drawable.boy)
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, null)
                        .show();
            }
        }
        return super.onCreateDialog(id, args);
    }

}

