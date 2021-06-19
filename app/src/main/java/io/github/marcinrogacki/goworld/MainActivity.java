package io.github.marcinrogacki.goworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewAnimator;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.ProgressBar;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

import io.github.marcinrogacki.goworld.Character;
import io.github.marcinrogacki.goworld.Item;

public class MainActivity extends AppCompatActivity {

    ViewAnimator viewAnimator;
    private Swipe swipe;
    private Character player;
    private Character monster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewanimator);

        swipe = new Swipe(70, 300);
        SwipeListener swipeListener = createSwipeListener();
        swipe.setListener(swipeListener);
        player = new Character();
        monster = new Character();
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
              player.heal();
              monster.heal();
              updateScreens();
            }

            @Override public void onSwipingRight(final MotionEvent event) {
            }

            @Override public void onSwipedRight(final MotionEvent event) {
              player.attack(monster);
              monster.attack(player);
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
        TextView playerView = (TextView)findViewById(R.id.player);
        playerView.setText(String.valueOf("Player: " + player.getLife()));
        ProgressBar playerBar = (ProgressBar)findViewById(R.id.playerBar);
        playerBar.setProgress(player.getLife());

        TextView monsterView = (TextView)findViewById(R.id.monster);
        monsterView.setText(String.valueOf("Monster lvl1: " + monster.getLife()));
        ProgressBar monsterBar = (ProgressBar)findViewById(R.id.monsterBar);
        monsterBar.setProgress(monster.getLife());

    }
}
