package com.alimotie.gentein;

import android.content.Intent;
import android.media.Image;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {

    LinearLayout linearLayout;
    ImageView image;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        linearLayout=(LinearLayout)findViewById(R.id.liner);
        image=(ImageView)findViewById(R.id.image);
        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup=AnimationUtils.loadAnimation(this,R.anim.downtoup);
        linearLayout.setAnimation(downtoup);
        image.setAnimation(uptodown);


        Thread thread =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


    }
}
