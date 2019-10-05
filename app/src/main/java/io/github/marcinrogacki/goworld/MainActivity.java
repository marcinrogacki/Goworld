package io.github.marcinrogacki.goworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewAnimator;
import android.view.MotionEvent;
import android.widget.TextView;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

import io.github.marcinrogacki.goworld.Player;

public class MainActivity extends AppCompatActivity {

    ViewAnimator viewAnimator;
    private Swipe swipe;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewanimator);

        swipe = new Swipe(70, 300);
        SwipeListener swipeListener = createSwipeListener();
        swipe.setListener(swipeListener);
        player = new Player();
        updateScreens();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    private SwipeListener createSwipeListener() {
        return new SwipeListener() {
            @Override public void onSwipingLeft(final MotionEvent event) {
            }

            @Override public void onSwipedLeft(final MotionEvent event) {
              viewAnimator.showPrevious();
              player.reduceLife();
              updateScreens();
            }

            @Override public void onSwipingRight(final MotionEvent event) {
            }

            @Override public void onSwipedRight(final MotionEvent event) {
              viewAnimator.showNext();
              player.reduceLife();
              updateScreens();
            }

            @Override public void onSwipingUp(final MotionEvent event) {
            }

            @Override public void onSwipedUp(final MotionEvent event) {
            }

            @Override public void onSwipingDown(final MotionEvent event) {
            }

            @Override public void onSwipedDown(final MotionEvent event) {
            }
        };
    }

    private void updateScreens() {
      TextView stats = (TextView)findViewById(R.id.stats);
      stats.setText(String.valueOf(player.getLife()));
      TextView view = (TextView)findViewById(R.id.view);
      view.setText(player.getLifeText());
    }
}
