package com.atalay.circleloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by baris on 14.07.2017.
 */

public class Circle extends View {
    private RectF rect = null;

    private Paint paint;
    /**
     * Çember kalınlığı
     * */
    private int strokeWidth = 5;

    /**
     * Çember rengi
     * */
    private @ColorInt int strokeColor = Color.RED;

    /**
     * Çember çizim geçikmesi
     * */

//    private long duration = 3000;


    private float ANGLE_POINT_END = 0;
    private float ANGLE_POINT_BEGIN = 0;

    public Circle(Context context) {
        super(context);

        init();
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    /**
     * Çizilecek nesne oluşturuluyor
     * */
    private void init() {
        paint = new Paint();
//        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(strokeWidth);

        paint.setColor(strokeColor);
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        paint.setStrokeWidth(strokeWidth);
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        paint.setColor(strokeColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new RectF(strokeWidth, strokeWidth, this.getWidth() - strokeWidth, this.getHeight() - strokeWidth);

        canvas.drawArc(rect, ANGLE_POINT_BEGIN, ANGLE_POINT_END, false, paint);
    }

    public float getAngleEnd() {
        return ANGLE_POINT_END;
    }

    public void setAngleEnd(float AngleEnd) {
        this.ANGLE_POINT_END = AngleEnd;
//        invalidate();
    }

    public float getAngleBegin() {
        return ANGLE_POINT_BEGIN;
    }

    public void setAngleBegin(float AngleBegin) {
        this.ANGLE_POINT_BEGIN = AngleBegin;

//        invalidate();
    }

}
