package com.hisnElMuslem.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hisnElMuslem.myapplication.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
      /*  new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          startActivity(new Intent(SplashScreenActivity.this,OptionActivity.class));
                                      }
                                  }
                ,
                3000);*/
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.videoBTN:
                startActivity(new Intent(this, YoutubeActivity.class));
                break;
            case R.id.readBTN:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
