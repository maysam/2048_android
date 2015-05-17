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
        paint.setColor(Color.MAGENTA);
        float text_size_dip = side/2;
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int text_size = (int) (text_size_dip * scale + 0.5f);
        paint.setTextSize(text_size);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawRoundRect(new RectF(left-10,top-10,left+10+4*side, top+10+4*side), 10, 10, paint);
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (numbers[i][j]) {
                    case 0:
                        paint.setARGB(255, 255, 255, 255);
                        break;
                    case 1:
                        paint.setARGB(255, 255, 225, 225);
                        break;
                    case 2:
                        paint.setARGB(255, 255, 200, 200);
                        break;
                    case 4:
                        paint.setARGB(255, 255, 175, 175);
                        break;
                    case 8:
                        paint.setARGB(255, 255, 155, 155);
                        break;
                    case 16:
                        paint.setARGB(255, 255, 125, 125);
                        break;
                    case 32:
                        paint.setARGB(255, 255, 100, 100);
                        break;
                    case 64:
                        paint.setARGB(255, 255, 88, 88);
                        break;
                    case 128:
                        paint.setARGB(255, 255, 55, 55);
                        break;
                    case 256:
                        paint.setARGB(255, 255, 25, 25);
                        break;
                    case 512:
                        paint.setARGB(255, 255, 12, 12);
                        break;
                    case 1024:
                        paint.setARGB(255, 255, 5, 5);
                        break;
                    case 2048:
                        paint.setARGB(255, 255, 2, 2);
                        break;
                }
                canvas.drawRect(new RectF(left + side * i + 10, top + side * j + 10, left + side + side * i - 10, top + side + side * j - 10), paint);
                if (numbers[i][j] > 0 ) {
                    paint.setColor(Color.BLUE);
                    canvas.drawText(String.valueOf(numbers[i][j]), (int)(left+5 +side*0.45+ side*i), (int)(top+5 + 0.6*side+ side*j), paint);
                }
            }
        }
    }
}
