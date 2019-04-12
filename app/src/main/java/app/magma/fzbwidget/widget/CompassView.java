package app.magma.fzbwidget.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CompassView extends View  {
    private int widthSize;
    private int heightSize;
    private Paint paint = new Paint();
    private float angle;
    private long last;//上次时间
    private float anglex;
    private float angley;

    public CompassView(Context context) {
        super(context,null);
    }

    public CompassView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CompassView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (widthMode){
            case MeasureSpec.AT_MOST:
                widthSize = 500;
                break;
            case MeasureSpec.EXACTLY:
                break;
        }
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                heightSize = 500;
                break;
            case MeasureSpec.EXACTLY:
                break;
        }

        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (anglex>=90||angley>=90) return;
        canvas.scale((float) Math.cos(Math.toRadians(anglex)),(float) Math.cos(Math.toRadians(angley)),widthSize/2,heightSize/2);

        if (paint==null) paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(widthSize/2,heightSize/2,Math.min(widthSize/2,heightSize/2),paint);
        canvas.save();

        paint.setColor(Color.BLACK);
        float l,t,r,b;
        l = widthSize/2-1.5f;
        t=2;
        r=widthSize/2+1.5f;
        b=12;
        for (int i = 0; i < 180; i++) {
            canvas.drawRect(new RectF(l,t,r,b),paint);
            canvas.rotate(2,widthSize/2,heightSize/2);
        }
        canvas.restore();
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(30f);
        canvas.drawText(""+(int)angle+"°",widthSize/2,heightSize/2,paint);

        paint.setColor(Color.RED);
        canvas.rotate(-angle,widthSize/2,heightSize/2);
        Path path = new Path();
        path.moveTo(widthSize/2,10);
        path.lineTo(widthSize/2-10,30);
        path.lineTo(widthSize/2+10,30);
        canvas.drawPath(path,paint);
        canvas.drawText("N",widthSize/2,60,paint);
        canvas.rotate(90,widthSize/2,heightSize/2);

        paint.setColor(Color.BLACK);
        canvas.drawText("E",widthSize/2,60,paint);
        canvas.rotate(90,widthSize/2,heightSize/2);

        canvas.drawText("S",widthSize/2,60,paint);
        canvas.rotate(90,widthSize/2,heightSize/2);

        canvas.drawText("W",widthSize/2,60,paint);
        canvas.rotate(90,widthSize/2,heightSize/2);
//        canvas.drawRect(new RectF(widthSize/2-5,10,widthSize/2+5,heightSize/2),paint);

    }

    public void setAngle(float[] angles) {

        if (Math.abs(angles[0]-this.angle)>=1||Math.abs(angles[1]-this.angley)>=1||Math.abs(angles[2]-this.anglex)>=1){
            angle = angles[0];
            angley =angles[1];
            anglex = angles[2];
            invalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
