package academy.mindswap;

public interface Defendable {

    public boolean isALive();

    public void defend(int damage);

    public int getHealth();

    public void decreaseHealth(int damage);

    public void setHealth(int health);

}
