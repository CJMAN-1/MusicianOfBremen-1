package com.example.zebal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView image = (ImageView)findViewById(R.id.image);

        Intent intent = getIntent();
        int num = intent.getIntExtra("button", 1);
        switch (num){
            case 1 :
                image.setImageResource(R.drawable.left_on);
                break;
            case 2 :
                image.setImageResource(R.drawable.right_on);
                break;
            default :
                image.setImageResource(R.drawable.forward_on);
                break;
        }
    }
}
