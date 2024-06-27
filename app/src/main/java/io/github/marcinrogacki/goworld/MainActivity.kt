package io.github.marcinrogacki.goworld

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.github.pwittchen.swipe.library.rx2.Swipe
import com.github.pwittchen.swipe.library.rx2.SwipeListener
import kotlin.random.Random

class MainActivity : ComponentActivity() {
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
            override fun onSwipedLeft(event: MotionEvent): Boolean {
                player.heal()
                if(Random.nextBoolean()) monster.heal() else monster.attack(player)
                updateScreens()
                return true
            }

            override fun onSwipingRight(event: MotionEvent) {}
            override fun onSwipedRight(event: MotionEvent): Boolean {
                player.attack(monster)
                if(Random.nextBoolean()) monster.heal() else monster.attack(player)
                updateScreens()
                return true
            }

            override fun onSwipingUp(event: MotionEvent) {}
            override fun onSwipedUp(event: MotionEvent): Boolean { return true }
            override fun onSwipingDown(event: MotionEvent) {}
            override fun onSwipedDown(event: MotionEvent): Boolean { return true }
        }
    }

    private fun updateScreens() {
        val playerView: TextView = findViewById<View>(R.id.player) as TextView
        val playerTxt = "Marcin: " + player.lifeText
        playerView.text = playerTxt
        val playerBar: ProgressBar = findViewById<View>(R.id.playerBar) as ProgressBar
        playerBar.progress = player.life
        val monsterView: TextView = findViewById<View>(R.id.monster) as TextView
        val monsterTxt = "Rat: " + monster.lifeText
        monsterView.text = monsterTxt
        val monsterBar: ProgressBar = findViewById<View>(R.id.monsterBar) as ProgressBar
        monsterBar.progress = monster.life
    }
}
