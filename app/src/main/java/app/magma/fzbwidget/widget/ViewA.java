package app.magma.fzbwidget.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ViewA extends View {
    Calendar calendar = Calendar.getInstance();
    Timer timer = new Timer();
    public ViewA(Context context) {
        super(context,null);

    }

    public ViewA(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public ViewA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE
        );
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawCircle(widthSize/2,heightSize/2,Math.min(widthSize,heightSize)/2,paint);
        paint.setColor(Color.BLUE);
        for (int i = 0; i < 60; i++) {
            if (i%5==0){
                paint.setColor(Color.RED);
                canvas.drawRect(new RectF(widthSize/2-2,20,widthSize/2+2,60),paint);
            }else {
                paint.setColor(Color.BLUE);
                canvas.drawRect(new RectF(widthSize/2-1,20,widthSize/2+1,40),paint);
            }
            canvas.rotate(6,widthSize/2,heightSize/2);
        }
        canvas.restore();
        canvas.save();
        calendar = Calendar.getInstance();
        int HH = calendar.get(Calendar.HOUR);
        canvas.rotate(6*HH,widthSize/2,heightSize/2);
        paint.setColor(Color.BLACK);
        canvas.drawRect(new RectF(widthSize/2-3,80,widthSize/2+3,heightSize/2+5),paint);

        canvas.restore();
        canvas.save();
        int MM = calendar.get(Calendar.MINUTE);
        canvas.rotate(6*MM,widthSize/2,heightSize/2);
        paint.setColor(Color.BLACK);
        canvas.drawRect(new RectF(widthSize/2-2,75,widthSize/2+2,heightSize/2+5),paint);

        canvas.restore();
        canvas.save();
        int SS = calendar.get(Calendar.SECOND);
        canvas.rotate(6*SS,widthSize/2,heightSize/2);
        paint.setColor(Color.RED);
        canvas.drawRect(new RectF(widthSize/2-1,70,widthSize/2+1,heightSize/2+10),paint);
        canvas.restore();
        postInvalidateDelayed(1000);
    }
    int widthSize,heightSize;
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
}
