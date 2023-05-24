package Entities;

import Main.ConsoleColors;

public class NPC extends Entity{

    public NPC(String name, int hp, int strength){
        super(name,hp,strength);
    }

    @Override
    public void showDetails() {
        System.out.println(ConsoleColors.PURPLE_UNDERLINED + "\nDetails about "+ super.getName() +"\n" + ConsoleColors.RESET);

        System.out.println("HP: " + super.getHp());
        System.out.println("Strength: " + super.getStrength());
    }
    public void attack(Hero player){

        double damage = 0;

        if (player instanceof Archer){
            damage = this.getStrength() + (this.getStrength()*((Archer) player).getNerf());
        } else if (player instanceof Knight){
            damage = this.getStrength() - (this.getStrength()*((Knight) player).getBoost());
        } else {
            damage = this.getStrength();
        }

        double playerHp = player.getHp();
        playerHp -= damage;

        System.out.println("Your HP: " + player.getHp());
        player.setHp(playerHp);

    }
}
