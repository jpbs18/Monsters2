package academy.mindswap;

public class Witch extends Supernatural implements Defendable{

    private int health = 100;

    public Witch() {
        super(20);
    }

    @Override
    public boolean isALive() {
        return getHealth() > 0;
    }

    @Override
    public void defend(int damage) {
        decreaseHealth(damage / 2);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    @Override
    public void setHealth(int health) {

    }

}
