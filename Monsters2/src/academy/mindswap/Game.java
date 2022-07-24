package academy.mindswap;

import academy.mindswap.Supernatural.Defendable.Defendable;
import academy.mindswap.Supernatural.Defendable.Witch;
import academy.mindswap.Supernatural.Fairies.Fairy;
import academy.mindswap.Supernatural.Supernatural;

public class Game {

    private Player player1;
    private Player opponent;

    private int numberOfMonsters;

    public Game(int numberOfMonsters, String player1, String opponent){
        this.numberOfMonsters = numberOfMonsters;
        this.player1 = new Player(player1, numberOfMonsters);
        this.opponent = new Player(opponent, numberOfMonsters);
    }

    public void playGame(){
        player1.generateMonsters();
        opponent.generateMonsters();
        game();
    }

    private void game(){

        while(true){
            if(gameEndedWithPrint()){
              return;
            }

            player1.playerDefend(opponent.playerAttack());

            if(gameEndedWithPrint()){
                return;
            }
            obstacles();

            if(gameEndedWithPrint()){
                return;
            }

            opponent.playerDefend(player1.playerAttack());

            if(gameEndedWithPrint()){
                return;
            }

            obstacles();
        }
    }

    private boolean gameEndedWithPrint(){

        if(player1.getDeadMonsters() == numberOfMonsters){
            System.out.printf("%s wins!%n", opponent.getName());
            return true;
        }

        if(opponent.getDeadMonsters() == numberOfMonsters){
            System.out.printf("%s wins!%n", player1.getName());
            return true;
        }

        return false;
    }

    private void obstacles(){

        int random = (int) (Math.random() * 4);
        Supernatural obstacle = random % 2 == 0 ? new Witch() : new Fairy();
        String superNatural = obstacle.getClass().getSimpleName();

        if(random < 2){
            return;
        }

        System.out.printf("%s interrupted the game!%n", superNatural);
        player1.playerDefend(obstacle.attack());

        if(gameEnded()){
            return;
        }

        System.out.printf("%s interrupted the game!%n", superNatural);
        opponent.playerDefend(obstacle.attack());

        if(gameEnded()){
            return;
        }

        if(obstacle instanceof Defendable){
            ((Defendable) obstacle).defend(player1.playerAttack());
            ((Defendable) obstacle).defend(opponent.playerAttack());
        }

    }

    private boolean gameEnded(){

        if(player1.getDeadMonsters() == numberOfMonsters){
            return true;
        }

        if(opponent.getDeadMonsters() == numberOfMonsters){
            return true;
        }

        return false;
    }

}
