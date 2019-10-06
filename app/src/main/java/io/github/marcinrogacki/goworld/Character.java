package io.github.marcinrogacki.goworld;

import java.util.Random;

public class Character {
    private int life = 100;
    private int damage = 10;

    public void attack(Character subject)
    {
        subject.takeDamage(getDamage());
    }

    public void takeDamage(int amount)
    {
        life = life - amount;
        if (life < 0) {
            life = 0;
        }
    }

    public void heal()
    {
        life = life + getDamage() * 2;
        if (life > 100) {
            life = 100;
        }
    }

    public int getLife()
    {
        return life;
    }

    public int getDamage()
    {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public String getLifeText()
    {
        if (life > 80) {
            return "Healthy";
        } else if (life > 60) {
            return "Injured";
        } else if (life > 40) {
            return "Wounded";
        } else if (life > 20) {
            return "Damaged";
        } else if (life > 0) {
            return "Close to dead";
        } else {
            return "You are dead";
        }
    }
}
