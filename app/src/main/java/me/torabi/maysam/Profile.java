package me.torabi.maysam;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Profile extends Activity {

    private CanvasView canvasView  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (canvasView == null) {
            canvasView = new CanvasView(this);
            canvasView.setOnTouchListener(new OnSwipeTouchListener(this) {
                public void onSwipeTop() {
                    Toast.makeText(Profile.this, "top", Toast.LENGTH_SHORT).show();
                }
                public void onSwipeRight() {
                    Toast.makeText(Profile.this, "right", Toast.LENGTH_SHORT).show();
                }
                public void onSwipeLeft() {
                    Toast.makeText(Profile.this, "left", Toast.LENGTH_SHORT).show();
                }
                public void onSwipeBottom() {
                    Toast.makeText(Profile.this, "bottom", Toast.LENGTH_SHORT).show();
                }

                public boolean onTouch(View v, MotionEvent event) {
                    return gestureDetector.onTouchEvent(event);
                }
            });

        }
        setContentView(canvasView);
        Log.e("Prof", "onCreate");
    }

}
