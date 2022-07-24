package academy.mindswap;

import academy.mindswap.Supernatural.Defendable.Monsters.*;

public class Player {

    private Monster[] monsters;
    private int deadMonsters;
    private String name;

    public Player(String name, int numberOfMonsters){
        this.name = name;
        this.monsters = new Monster[numberOfMonsters];
    }

    public void generateMonsters(){

        for(int i = 0; i < monsters.length; i++){
             MonsterType monster = MonsterType.values()[(int) (Math.random() * 3)];

             switch(monster){
                 case WEREWOLF -> monsters[i] = new Werewolf();
                 case VAMPIRE -> monsters[i] = new Vampire();
                 case MUMMY -> monsters[i] = new Mummy();
             }
        }
    }

    public Monster pickMonster(){
         Monster monster = monsters[(int) (Math.random() * monsters.length)];

         if(monster.isALive()){
             return monster;
         }

         return pickMonster();
    }

    public int playerAttack(){
        Monster monster = pickMonster();
        String monsterType = monster.getClass().getSimpleName();
        int damage = monster.getDamage();
        String player = this.getName();

        System.out.printf("%s : %s attacked %d of damage%n",player, monsterType, damage);
        return monster.attack();
    }

    public void playerDefend(int damage){
        Monster monster = pickMonster();
        monster.defend(damage);
        String monsterType = monster.getClass().getSimpleName();
        String player = this.getName();

        if(!monster.isALive()){
            deadMonsters++;
        }
        System.out.printf("%s: %s suffered %d of damage%n",player, monsterType, damage);
    }

    public int getDeadMonsters(){
        return this.deadMonsters;
    }

    public String getName(){
        return this.name;
    }
}
