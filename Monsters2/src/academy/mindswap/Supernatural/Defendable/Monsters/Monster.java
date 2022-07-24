package academy.mindswap.Supernatural.Defendable.Monsters;

import academy.mindswap.Supernatural.Defendable.Defendable;
import academy.mindswap.Supernatural.Supernatural;

public abstract class Monster extends Supernatural implements Defendable {

    private int health = 100;

    public Monster(int damage) {
        super(damage);
    }

    @Override
    public boolean isALive() {
        return getHealth() > 0;
    }

    @Override
    public void defend(int damage) {
        decreaseHealth(damage);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    public void increaseHealth(){
        this.health += 10;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
