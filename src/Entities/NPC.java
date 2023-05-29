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

        System.out.println("POW");
        player.setHp(playerHp);

    }
    public static NPC karen = new NPC("Wild Karen", 30, 5);
    public static NPC alghoul = new NPC("Alghoul", 110, 50);
    public static NPC balrog = new NPC("Devious Balrog", 160, 80);
    public static NPC bowser = new NPC("Bowser", 80, 30);
    public static NPC ogre = new NPC("Ogre", 60, 40);
    public static NPC witch = new NPC("Evil Witch", 50, 30);

}
