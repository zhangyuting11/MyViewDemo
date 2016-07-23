package com.example.yuting.myviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * MyView
 * Created by yuting on 2016/7/23.
 */
public class MyView extends View {
    private Context mContext;//上下文

    private Paint mPaint;//画笔

    private int mWidth, mHeight;//view的宽高
    private int widthmode, heightmode;//view的宽高的测量模式

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    // 2.初始化画笔
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }

    /**
     * 测量View大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式
        mHeight = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式
    }

    /**
     * 确定View大小
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 确定子View布局位置(自定义View包含子View时有用)
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制内容(onDraw)
     *
     * @param canvas
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
