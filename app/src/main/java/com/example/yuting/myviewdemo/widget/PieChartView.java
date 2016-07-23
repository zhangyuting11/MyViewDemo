package com.example.yuting.myviewdemo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 饼状图
 * Created by yuting on 2016/7/23.
 */
public class PieChartView extends View {

    private Paint mPaint;//画笔

    private int mWidth, mHeight;//view 的宽高

    private float percent = 0.5f;//男占比

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);//饼状图圆心移到中间
        float r = (float) ((Math.min(mWidth, mHeight) / 2));
        RectF rectF = new RectF(-r, -r, r, r);

        //男士的扇形图
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.CYAN);
        canvas.drawArc(rectF, -90, percent * 360, true, mPaint);

        //女士的扇形图
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF, percent * 360 - 90, (1 - percent) * 360, true, mPaint);

    }

    public void setPercent(float percent) {
        Log.w("PieChartView", String.valueOf(percent));
        this.percent = percent;
        invalidate();
    }

}
