package Entities;

import Main.ConsoleColors;

public class NPC extends Entity{

    public NPC(String name, int hp, int strength){
        super(name,hp,strength);
    }

    /**
     * mostra detalhes NPC
     */

    @Override
    public void showDetails() {
        System.out.println(ConsoleColors.PURPLE_UNDERLINED + "\nDetails about "+ super.getName() +"\n" + ConsoleColors.RESET);

        System.out.println("HP: " + super.getHp());
        System.out.println("Strength: " + super.getStrength());
    }

    /**
     * ataca o heroi
     * @param player
     */
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

        System.out.println(ConsoleColors.RED + "POW" + ConsoleColors.RESET);
        player.setHp(playerHp);

    }


}
