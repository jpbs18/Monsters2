package academy.mindswap;

public class Vampire extends Monster{

    private final double CHANCE = 0.3;

    public Vampire() {
        super(15);
    }

    @Override
    public int attack() {
        bite();
        return super.attack();
    }

    private void bite(){
        if((Math.random()) < CHANCE){
           this.increaseHealth();
           if(getHealth() > 100){
               this.setHealth(100);
           }
            System.out.println("Sucking blood!");
        }
    }

}
