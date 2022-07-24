package academy.mindswap;

public abstract class Supernatural {

    private int damage;

    public Supernatural(int damage){
        this.damage = damage;
    }

    public int attack(){
        return this.getDamage();
    }

    public int getDamage(){
        return this.damage;
    }
}
