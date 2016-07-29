package com.example.yuting.myviewdemo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuting.myviewdemo.R;

/**
 * 测试
 * Created by yuting on 2016/7/29.
 */
public class LeaveCarView extends View {

    private Context mContext;
    private int mWidth, mHeight;//view的宽高

    private Paint tunnelPaint;//隧道画笔
    private Paint finishPaint;//完成画笔
    private Paint textPaint;//文字画笔

    private int num = 25;
    private int color = Color.parseColor("#ffEC407A");

    public LeaveCarView(Context context) {
        super(context);
        this.mContext = context;
    }

    public LeaveCarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        tunnelPaint = new Paint();
        tunnelPaint.setColor(color);//
        tunnelPaint.setStyle(Paint.Style.STROKE);//线
        tunnelPaint.setStrokeWidth(8f);//线的宽度

        finishPaint = new Paint();
        finishPaint.setColor(color);//
        finishPaint.setStyle(Paint.Style.STROKE);//线
        finishPaint.setStrokeWidth(8f);//线的宽度

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);//
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);//居中对齐
        textPaint.setTextSize(50);//线的宽度
    }

    /**
     * 获取View的宽高
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 在画布画出隧道
     *
     * @param canvas
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float r = (float) (0.9 * Math.min(mWidth / 2, mHeight / 2));//边长
        canvas.translate(mWidth / 2, mHeight / 2); //画布移到View的中心位置
        //清空画布
        if (num <= 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.leave_car);
            Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());//指定绘制整张图
            int radius = Math.min(mWidth / 4, mHeight / 4);//指定显示区域大小
            Rect dst = new Rect(-radius, -radius, radius, radius);//指定显示区域
            // 绘制图片
            canvas.drawBitmap(bitmap, src, dst, null);
            return;
        }

        textPaint.setTextSize(250 / num);//线的宽度
        canvas.drawText("车站", 0, 0, textPaint);


        canvas.drawLines(new float[]{
                -r, r, -r, -r,
                -r, -r, r, -r,
                r, -r, r, r
        }, tunnelPaint);//画出外层
        //循环画出圆并缩放其0.9
        for (int i = 0; i < num; i++) {
            canvas.scale(0.9f, 0.9f);
            canvas.drawLines(new float[]{
                    -r, r, -r, -r,
                    -r, -r, r, -r,
                    r, -r, r, r

            }, tunnelPaint);//循环画出外层的0.9
        }
    }

    public void start() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                num = num - 1;
                invalidate();
                if (num > 0)
                    start();
            }
        }, 200);
    }

    public void setColor(int color) {
        this.color = color;
        initPaint();
    }
}
