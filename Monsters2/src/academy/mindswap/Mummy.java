package academy.mindswap;

public class Mummy extends Monster{

    private int numberOfAttacks = 0;

    public Mummy() {
        super(30);
    }

    @Override
    public int attack() {
        if(numberOfAttacks == 2){
            decreaseHealth(10);
            numberOfAttacks = 0;
            System.out.println("Mummy unrolled, inflicted self-damage...");
            return 0;
        }
        numberOfAttacks++;
        return super.attack();
    }

    @Override
    public void defend(int damage) {
        numberOfAttacks = 0;
        super.defend(damage);
    }
}
