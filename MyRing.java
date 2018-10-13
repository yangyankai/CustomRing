package com.example.ykai.app_nul.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.ykai.app_nul.R;

/**
 * Created by ykai on 18/10/13.
 */
public class MyRing extends View {
    int progress = 0;
    private Paint titlePaint;
    private Paint cyclePaint;
    private int mCycleColor;
    private String mCycleTitle;

//    public MyRing(Context context) {
//        super(context);
//        initView();
//    }

    public MyRing(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCycle);
        mCycleColor = typedArray.getColor(R.styleable.MyCycle_CycleColor,Color.BLACK);
        mCycleTitle = typedArray.getString(R.styleable.MyCycle_CycleTitle);
        initView();
    }

    private void initView() {
        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setColor(mCycleColor);
        titlePaint.setTextSize(40);

        cyclePaint = new Paint();
        cyclePaint.setAntiAlias(true);
        cyclePaint.setColor(mCycleColor);
        cyclePaint.setStyle(Paint.Style.STROKE);
        cyclePaint.setStrokeWidth(20);

    }

//    public MyRing(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context,attrs,defStyleAttr);
//        initView();
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF o =new  RectF(20,20,400,400);
        float sweep = progress * 3.6f;
        canvas.drawArc(o,0,sweep,false,cyclePaint);
        canvas.drawText( mCycleTitle+" :" + progress+ " %",400-50,400,titlePaint);
        if(progress < 100){
            invalidate();
            progress+=1;
        }
    }
}
