package app.magma.fzbwidget.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class GyroscopeView extends View {
    private int widthSize;
    private int heightSize;
    float[] angleValue ={0,0,0};
    private Paint paint;
    private int haf_widthSize;
    private int haf_heightSize;
    private int minhalf;

    public GyroscopeView(Context context) {
        super(context, null);
    }

    public GyroscopeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public GyroscopeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                widthSize = 500;
                break;
            case MeasureSpec.EXACTLY:
                break;
        }
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                heightSize = 500;
                break;
            case MeasureSpec.EXACTLY:
                break;
        }
         haf_widthSize = widthSize/2;
         haf_heightSize = heightSize/2;
         if (haf_heightSize>haf_widthSize){
             minhalf = haf_heightSize-haf_widthSize;
         }
//         minhalf=Math.min(haf_heightSize,haf_widthSize);

        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (angleValue==null||angleValue.length<3) return;

        paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        canvas.drawRect(new RectF(0, 0, widthSize, heightSize), paint);

        canvas.save();
        Path path = new Path();
        path.moveTo(haf_widthSize,minhalf+10);
        path.lineTo(haf_widthSize,minhalf+30);
        if (angleValue[2] > 0.5f||angleValue[2] < -0.5f){
            path.lineTo(haf_widthSize+(angleValue[2]>0.5f?-10:10),minhalf+20);
            paint.setColor(angleValue[2]>0.5f?Color.GREEN:Color.RED);
        }else {
            path.lineTo(haf_widthSize+5,minhalf+30);
            path.lineTo(haf_widthSize+5,minhalf+10);
            paint.setColor(Color.YELLOW);
        }
        for (int i = 0; i < 90; i++) {
            canvas.drawPath(path,paint);
            canvas.rotate(4,widthSize/2,heightSize/2);
        }
        canvas.restore();
        canvas.save();



        canvas.scale(0.3f,1,haf_widthSize,haf_heightSize);
         path = new Path();
        path.moveTo(haf_widthSize,minhalf+10);
        path.lineTo(haf_widthSize,minhalf+30);
        if (angleValue[0] > 0.5f||angleValue[0] < -0.5f){
            path.lineTo(haf_widthSize+(angleValue[0]>0.5f?-10:10),minhalf+20);
            paint.setColor(angleValue[2]>0.5f?Color.GREEN:Color.RED);

        }else {
            path.lineTo(haf_widthSize+5,minhalf+30);
            path.lineTo(haf_widthSize+5,minhalf+10);
            paint.setColor(Color.YELLOW);


        }
        for (int i = 0; i < 90; i++) {
            if (i==45){canvas.scale(1.5f,1,haf_widthSize,haf_heightSize);}
            canvas.drawPath(path,paint);
            canvas.rotate(4,widthSize/2,heightSize/2);
        }
        canvas.restore();
        canvas.save();



        canvas.scale(1,0.3f,haf_widthSize,haf_heightSize);
        path = new Path();
        path.moveTo(haf_widthSize,minhalf+10);
        path.lineTo(haf_widthSize,minhalf+30);
        if (angleValue[1] > 0.5f||angleValue[1] < -0.5f){
            path.lineTo(haf_widthSize+(angleValue[1]>0.5f?-10:10),minhalf+20);
            paint.setColor(angleValue[2]>0.5f?Color.GREEN:Color.RED);
        }else {
            path.lineTo(haf_widthSize+5,minhalf+30);
            path.lineTo(haf_widthSize+5,minhalf+10);
            paint.setColor(Color.YELLOW);
        }
        canvas.rotate(90,haf_widthSize,haf_heightSize);
        for (int i = 0; i < 90; i++) {
            if (i==45){canvas.scale(1,1.5f,haf_widthSize,haf_heightSize);}
            canvas.drawPath(path,paint);
            canvas.rotate(4,widthSize/2,heightSize/2);
        }

    }

    public void setAngleValue(float[] angleValue) {
        this.angleValue = angleValue;
        invalidate();
    }
}
