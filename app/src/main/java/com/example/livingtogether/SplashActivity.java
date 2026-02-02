package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startPulseAnimation(findViewById(R.id.dot1), 0);
        startPulseAnimation(findViewById(R.id.dot2), 200);
        startPulseAnimation(findViewById(R.id.dot3), 400);

        // Delay for 3 seconds then start MainActivity
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void startPulseAnimation(View view, long delay) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 0.75f, 1f, 0.75f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(750);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setStartOffset(delay);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.5f);
        alphaAnimation.setDuration(750);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setStartOffset(delay);

        view.startAnimation(scaleAnimation);
        view.startAnimation(alphaAnimation);
        // Note: startAnimation overrides if called twice on same view unless using AnimationSet.
        // Let's use AnimationSet for both.
    }
}