package io.github.marcinrogacki.goworld

import java.util.*

class Character {
    var life = 100
        private set

    private val damage: Int
        get() {
            // Range: 0-9
            return Random().nextInt(10)
        }

    private val aid: Int
        get() {
            // Range: 2-6
            return Random().nextInt(4) + 2
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
        life += aid
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
