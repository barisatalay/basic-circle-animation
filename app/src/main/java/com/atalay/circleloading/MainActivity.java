package com.atalay.circleloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private Circle circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {
        circle = (Circle) findViewById(R.id.circle);
        circle.setStrokeWidth(30);
        circle.setAngleEnd(250);

        CircleAngleAnimation animation = new CircleAngleAnimation(circle);
        animation.setDuration(2000);
        animation.setAnimationListener(this);

        circle.setAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Animation rotation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        rotation.setFillAfter(true);
        circle.startAnimation(rotation);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
