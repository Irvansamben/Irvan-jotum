package com.ichmal.jokiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_screen extends AppCompatActivity {

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTIme = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstTIme){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoardingScreen.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(Splash_screen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                //startActivity(new Intent(getApplicationContext(), OnBoardingScreen.class));
                //finish();
            }
        }, 2000L); //3000l = 3 detik

    }
}



