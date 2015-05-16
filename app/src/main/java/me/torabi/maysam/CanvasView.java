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
    private int counter = 0;
    private int width = 0;
    private int viewWidth;
    private int viewHeight;
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
        counter++;
        canvas.drawColor(Color.WHITE);
        int side = (int)((parentHeight>parentWidth? parentWidth: parentHeight)/6);
        int left = (parentWidth - side*4)/2;
        int top = (parentHeight- side*4)/2;
        paint.setColor(Color.RED);
        canvas.drawRoundRect(new RectF(left,top,left+4*side, top+4*side), 10, 10, paint);
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                paint.setColor(Color.WHITE);
                canvas.drawRoundRect(new RectF(left + side* i + 10, top+ side* j+10, left+ side+ side* i-10, top+ side+ side* j-10), 20, 20, paint);
                if (numbers[i][j] > 0 ) {
                    paint.setTextSize(40);
                    paint.setTextAlign(Paint.Align.CENTER);
                    paint.setColor(Color.BLUE);
                    canvas.drawText(String.valueOf(numbers[i][j]), (int)(left+5 +side*0.5+ side*i), (int)(top+5 + 0.5*side+ side*j), paint);
                }
            }
        }
    }

}
