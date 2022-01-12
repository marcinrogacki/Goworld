package io.github.marcinrogacki.goworld

import java.util.*

class Character {
    var life = 100
        private set
    private val damage: Int
        get() {
            val rand = Random()
            return rand.nextInt(10)
        }

    fun attack(subject: Character) {
        subject.takeDamage(damage)
    }

    private fun takeDamage(amount: Int) {
        life -= amount
        if (life < 0) {
            life = 0
        }
    }

    fun heal() {
        life += damage * 2
        if (life > 100) {
            life = 100
        }
    }

    val lifeText: String
        get() = when {
            life > 80 -> {
                "Healthy"
            }
            life > 60 -> {
                "Injured"
            }
            life > 40 -> {
                "Wounded"
            }
            life > 20 -> {
                "Damaged"
            }
            life > 0 -> {
                "Fatal"
            }
            else -> {
                "Dead"
            }
        }
}