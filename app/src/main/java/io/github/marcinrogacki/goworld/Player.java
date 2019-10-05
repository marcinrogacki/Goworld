package io.github.marcinrogacki.goworld;

public class Player {
    private int life = 100;

    public void reduceLife()
    {
        if (life > 0) {
            life--;
        }
    }

    public int getLife()
    {
        return life;
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
