package com.atalay.circleloading;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by baris on 14.07.2017.
 */

public class CircleAngleAnimation extends Animation {
    private Circle circle;

    private float oldAngle;
    private float newAngle;

    public CircleAngleAnimation(Circle circle) {
        this.oldAngle = circle.getAngleBegin();
        this.newAngle = circle.getAngleEnd();
        this.circle = circle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        circle.setAngleEnd(angle);

        circle.requestLayout();
    }
}
