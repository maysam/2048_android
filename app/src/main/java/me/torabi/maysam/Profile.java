package me.torabi.maysam;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class Profile extends Activity {

    private CanvasView canvasView  = null;

    private int[][] numbers = new int[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (canvasView == null) {
            Random rand = new Random(System.currentTimeMillis());
            for(int i=0; i<5; i++)
                numbers[rand.nextInt(4)][rand.nextInt(4)] = 1;
            for(int i=0; i<10; i++)
                numbers[rand.nextInt(4)][rand.nextInt(4)] *= 2;
            canvasView = new CanvasView(this, numbers);
            canvasView.setOnTouchListener(new OnSwipeTouchListener(this) {
                public void onSwipeTop() {
                    numbers = MatrixOperations.process(numbers);
                    canvasView.update_numbers(numbers);
                }
                public void onSwipeRight() {
                    numbers = MatrixOperations.rotateRight(numbers);
                    numbers = MatrixOperations.process(numbers);
                    numbers = MatrixOperations.rotateLeft(numbers);
                    canvasView.update_numbers(numbers);
                }
                public void onSwipeLeft() {
                    numbers = MatrixOperations.rotateLeft(numbers);
                    numbers = MatrixOperations.process(numbers);
                    numbers = MatrixOperations.rotateRight(numbers);
                    canvasView.update_numbers(numbers);
                }
                public void onSwipeBottom() {
                    numbers = MatrixOperations.rotateLeft(numbers);
                    numbers = MatrixOperations.rotateLeft(numbers);
                    numbers = MatrixOperations.process(numbers);
                    numbers = MatrixOperations.rotateRight(numbers);
                    numbers = MatrixOperations.rotateRight(numbers);
                    canvasView.update_numbers(numbers);
                }

                public boolean onTouch(View v, MotionEvent event) {
                    return gestureDetector.onTouchEvent(event);
                }
            });

        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(canvasView);
    }

}
