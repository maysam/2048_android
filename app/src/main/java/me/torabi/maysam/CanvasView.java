package me.torabi.maysam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.Date;
import java.util.Random;

/**
 * Created by maysam on 5/14/15.
 */
public class CanvasView  extends View {

    private Paint paint;
    private int parentWidth;
    private int parentHeight;

    protected int[][] numbers = null;

    public CanvasView(Context context, int[][] _numbers) {
        super(context);
        paint = new Paint();
        numbers = _numbers;
    }

    public void update_numbers(int[][] _numbers){
        numbers = _numbers;
        invalidate();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        int side = (int)((parentHeight>parentWidth? parentWidth: parentHeight)/6);
        int left = (parentWidth - side*4)/2;
        int top = (parentHeight- side*4)/2;
        paint.setColor(Color.RED);
        float text_size_dip = side/2;
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int text_size = (int) (text_size_dip * scale + 0.5f);
        paint.setTextSize(text_size);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawRoundRect(new RectF(left-10,top-10,left+10+4*side, top+10+4*side), 10, 10, paint);
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                paint.setColor(Color.WHITE);
                canvas.drawRect(new RectF(left + side* i + 10, top+ side* j+10, left+ side+ side* i-10, top+ side+ side* j-10), paint);
                if (numbers[i][j] > 0 ) {
                    paint.setColor(Color.BLUE);
                    canvas.drawText(String.valueOf(numbers[i][j]), (int)(left+5 +side*0.45+ side*i), (int)(top+5 + 0.6*side+ side*j), paint);
                }
            }
        }
    }
}
