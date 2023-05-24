package Entities;

import java.util.ArrayList;
import Itens.*;
import Main.ConsoleColors;

public abstract class Hero extends Entity{

    private int level;
    private int gold;
    private Weapon weapon;
    private ArrayList<Potion> potion;

    public Hero(String name, int gold){
        super(name);
        this.gold =gold;

    }
    public Hero(String name, double hp, double strength, int gold){
        super(name, hp, strength);
        this.gold =gold;

    }
    @Override
    public void showDetails() {
        System.out.println(ConsoleColors.PURPLE_UNDERLINED + "\nHero Details" + ConsoleColors.RESET);
        System.out.println("Name: " + super.getName());
        System.out.println("HP: " + super.getHp());
        System.out.println("Strength: " + super.getStrength());
        System.out.println("Level: " + this.level);
        System.out.println("Gold: " + this.gold);
        System.out.println();
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addToGold(int gold ){ this.setGold(this.gold + gold);}

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Potion> getPotion() {
        return potion;
    }

    public void setPotions(ArrayList<Potion> potion) {
        this.potion = potion;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void increaseLevel(){ this.level++;
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Level up" + ConsoleColors.RESET);
    }

    public void attack(NPC npc){

        double enemyHp = npc.getHp();
        enemyHp -= this.getStrength();

        System.out.println(npc.getName() + " HP: " + npc.getHp());
        npc.setHp(enemyHp);

    }

}
