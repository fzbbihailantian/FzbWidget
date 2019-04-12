package app.magma.fzbwidget.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CanvasBitmapView extends View {
    private int widthSize;
    private int heightSize;

    public CanvasBitmapView(Context context) {
        super(context,null);
    }

    public CanvasBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CanvasBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                widthSize = Math.min(widthSize,500);
                break;
            case MeasureSpec.EXACTLY:
                break;
        }
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                heightSize = Math.min(heightSize,500);
                break;
            case MeasureSpec.EXACTLY:
                break;
        }

        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
