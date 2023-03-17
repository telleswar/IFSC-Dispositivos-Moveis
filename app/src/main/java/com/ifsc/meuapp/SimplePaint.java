package com.ifsc.meuapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SimplePaint extends View {

    Paint mPaint;
    Path mPath;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();

    }

    private void setupPaint() {
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                mPath.moveTo(x,y);
                break;
            case (MotionEvent.ACTION_MOVE):
                mPath.lineTo(x,y);
                break;
            case (MotionEvent.ACTION_UP):
                mPath.lineTo(x,y);
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
}
