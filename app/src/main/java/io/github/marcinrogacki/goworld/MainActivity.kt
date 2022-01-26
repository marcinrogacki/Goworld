package io.github.marcinrogacki.goworld

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.activity.ComponentActivity
import com.github.pwittchen.swipe.library.Swipe
import com.github.pwittchen.swipe.library.SwipeListener

class MainActivity : ComponentActivity() {
    private var viewAnimator: ViewAnimator? = findViewById<View>(R.id.viewanimator) as ViewAnimator
    private var swipe: Swipe = Swipe(70, 300)
    private var player: Character = Character()
    private var monster: Character = Character()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipe.setListener(createSwipeListener())
        updateScreens()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        swipe.dispatchTouchEvent(event)
        return super.dispatchTouchEvent(event)
    }

    private fun createSwipeListener(): SwipeListener {
        return object : SwipeListener {
            override fun onSwipingLeft(event: MotionEvent) {}
            override fun onSwipedLeft(event: MotionEvent) {
                player.heal()
                monster.heal()
                updateScreens()
            }

            override fun onSwipingRight(event: MotionEvent) {}
            override fun onSwipedRight(event: MotionEvent) {
                player.attack(monster)
                monster.attack(player)
                updateScreens()
            }

            override fun onSwipingUp(event: MotionEvent) {}
            override fun onSwipedUp(event: MotionEvent) {}
            override fun onSwipingDown(event: MotionEvent) {}
        override fun onSwipedDown(event: MotionEvent) {}
        }
    }

    private fun updateScreens() {
        val playerView: TextView = findViewById<View>(R.id.player) as TextView
        val playerTxt = "Player lvl1: " + player.lifeText
        playerView.text = playerTxt
        val playerBar: ProgressBar = findViewById<View>(R.id.playerBar) as ProgressBar
        playerBar.progress = player.life
        val monsterView: TextView = findViewById<View>(R.id.monster) as TextView
        val monsterTxt = "Monster lvl1: " + monster.lifeText
        monsterView.text = monsterTxt
        val monsterBar: ProgressBar = findViewById<View>(R.id.monsterBar) as ProgressBar
        monsterBar.progress = monster.life
    }
}
