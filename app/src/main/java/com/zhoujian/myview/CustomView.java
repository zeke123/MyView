package com.zhoujian.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zhoujian on 2017/1/19.
 */

public class CustomView extends View
{

    // 1.创建Picture
    private Picture mPicture = new Picture();


    //创建画笔
    private Paint mPaint = new Paint();

    private Bitmap bitmap;

    private int width;

    private Paint textPaint;

    private int height;

    public CustomView(Context context)
    {
        super(context);
    }

    /**
     * 初始化一些的内容，和获取自定义属性。
     * @param context
     * @param attrs
     */

    public CustomView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        //初始化画笔
        //initPaint();

        // 创建画笔
         textPaint = new Paint();
        // 设置颜色
        textPaint.setColor(Color.BLACK);
        // 设置样式
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(50);
        //获取屏幕宽和高
        //getScreenWH();

        // bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher);

        // 调用录制
        //recording();
    }

    private void recording()
    {
        // 开始录制
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        // 在Canvas中具体操作
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);
        //结束录制
        mPicture.endRecording();
    }

    private void getScreenWH()
    {

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }

    private void initPaint()
    {
        //设置画笔颜色
        mPaint.setColor(Color.WHITE);
        //设置画笔模式
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        mPaint.setStrokeWidth(10f);
        //设置抗锯齿
        mPaint.setAntiAlias(true);

    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 测量view大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式
        setMeasuredDimension(widthsize,heightsize);
    }

    /**
     * 确定view大小
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 确定子View布局位置
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制内容
     * @param canvas
     */

    @Override
    protected void onDraw(Canvas canvas)
    {


        canvas.drawColor(Color.RED); //绘制红色


        // 文本(要绘制的内容)
        String str = "TEXTTEXT";

        // 参数分别为 (文本 基线x 基线y 画笔)
        //canvas.drawText(str,230,600,textPaint);


        // 参数分别为 (字符串 开始截取位置 结束截取位置 基线x 基线y 画笔)
        //canvas.drawText(str,1,3,300,600,textPaint);





        canvas.drawPosText(str,new float[]{
                100,100,    // 第一个字符位置
                150,200,    // 第二个字符位置
                200,300,    // ...
                250,400,
                300,500,
                350,600,
                400,700,
                450,800
        },textPaint);


        //mPicture.draw(canvas);

        //canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));


        // 包装成为Drawable
        //PictureDrawable drawable = new PictureDrawable(mPicture);
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        //drawable.setBounds(0,0,250,mPicture.getHeight());
        // 绘制
        //drawable.draw(canvas);




        //canvas.drawBitmap(bitmap,new Matrix(),new Paint());



       // canvas.drawBitmap(bitmap,300,300,new Paint());



        // 将画布坐标系移动到画布中央
        //canvas.translate(width/2,height/2);
        // 指定图片绘制区域(左上角的四分之一)
        // Rect src = new Rect(0,0,bitmap.getWidth()/2,bitmap.getHeight()/2);
        // 指定图片在屏幕上显示的区域
        //Rect dst = new Rect(0,0,200,200);
        // 绘制图片
        //canvas.drawBitmap(bitmap,src,dst,null);


        //在坐标（350,400处画一个点
        //canvas.drawPoint(350,400,mPaint);
        //canvas.drawPoint(300,400,mPaint);
        //画多个点
        //canvas.drawPoints(new float[]{400,400,400,500,400,600,400,700,400,800,400,900},mPaint);

        //在坐标（100,100）和（600,100）之间画一条线
        //canvas.drawLine(100,100,600,100,mPaint);
        //画多条线
        //canvas.drawLines(new float[]{100,150,600,150,100,200,600,200,100,250,600,250},mPaint);



        //第一种
        //canvas.drawRect(150,150,600,350,mPaint);
        //第二种
        //Rect rect = new Rect(150,500,600,700);
        //canvas.drawRect(rect,mPaint);
        //第三种
        //RectF rectF = new RectF(150,800,600,1000);
        //canvas.drawRect(rectF,mPaint);


        //绘制圆角矩形
        //RectF rectF = new RectF(100,100,600,300);
        //canvas.drawRoundRect(rectF,20,20,mPaint);


        //绘制椭圆
        //RectF rectF = new RectF(100,100,600,400);
        //canvas.drawOval(rectF,mPaint);


        // 绘制一个圆心坐标在(360,400)，半径为300 的圆。
        //canvas.drawCircle(360,400,300,mPaint);


        //绘制圆弧
       /* RectF rectF = new RectF(100,100,600,600);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF,mPaint);
        // 绘制圆弧(不使用中心点)
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF,0,90,false,mPaint);


        RectF rectF1 = new RectF(100,700,600,1200);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF1,mPaint);
        // 绘制圆弧(使用中心点)
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF1,0,90,true,mPaint);*/


        //位移操作
        /*// 在坐标原点绘制一个白色圆形
        mPaint.setColor(Color.WHITE);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,mPaint);

        // 在坐标原点绘制一个蓝色圆形
        mPaint.setColor(Color.BLUE);
        canvas.translate(400,200);
        canvas.drawCircle(0,0,100,mPaint);*/


        //缩放操作
        // 将坐标系原点移动到屏幕正中心
       /* canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-300,300,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
        // 画布缩放（缩放中心是屏幕正中心）
        canvas.scale(0.5f,0.5f);
        // 绘制蓝色矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);*/




      /*  canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-300,300,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
        // 画布缩放（缩放中心向右移动150px）
        canvas.scale(0.5f,0.5f,150,0);
        // 绘制蓝色矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);*/


       /* canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-300,300,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
        // 画布缩放（缩放中心是屏幕正中心，缩放比例为负数）
        canvas.scale(-0.5f,-0.5f);
        // 绘制蓝色矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);*/


     /*   canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-300,300,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
        // 画布缩放（缩放中心向右移动150px，缩放比例为负数）
        canvas.scale(-0.5f,-0.5f,150,0);
        // 绘制蓝色矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);

*/
        // 将坐标系原点移动到画布正中心


    /*    canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(-380,-380,380,380);

        for (int i=0; i<=20; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rect,mPaint);
        }*/


/*
        // 将坐标系原点移动到画布正中心
        canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-300,300,0);
        // 绘制黑色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
        // 旋转180度 <-- 默认旋转中心为原点
        canvas.rotate(180);
        // 绘制蓝色矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);*/




     /*   // 将坐标系原点移动到画布正中心
        canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,-200,200,0);
        // 绘制黑色矩形
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect,mPaint);
        // 旋转180度 <-- 旋转中心向右偏移100个单位
        canvas.rotate(180,100,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);


*/
      /*  // 将坐标系原点移动到画布正中心
        canvas.translate(width / 2, height / 2);
        // 绘制两个圆形
        canvas.drawCircle(0,0,350,mPaint);
        canvas.drawCircle(0,0,330,mPaint);

        for (int i=0; i<=360; i+=10){
            // 绘制圆形之间的连接线
            canvas.drawLine(0,330,0,350,mPaint);
            canvas.rotate(10);
        }*/





      /*  // 将坐标系原点移动到画布正中心
        canvas.translate(width / 2, height / 2);
        // 矩形区域
        RectF rect = new RectF(0,0,150,150);
        // 绘制黑色矩形
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect,mPaint);
        // x轴方向歪斜 <- 45度
        canvas.skew(1,0);
        // 绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);
*/



    }
}
