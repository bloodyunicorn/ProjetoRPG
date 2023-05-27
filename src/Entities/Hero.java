package Entities;

import java.util.ArrayList;
import Itens.*;
import Main.ConsoleColors;

public abstract class Hero extends Entity{

    private int level;
    private int gold;
    private Weapon weapon;
    private ArrayList<Potion> potion = new ArrayList<Potion>();

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

    public void addToGold(int gold){
        this.setGold(this.gold + gold);
    }
    public void takeFromGold(int gold){
        this.setGold(this.gold - gold);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weaponToReplace) {

        if (this.weapon==null){
            this.weapon = weaponToReplace;
            this.addToStrength(weapon.getAttack());
        } else {
            takeFromStrength(this.weapon.getAttack());
            this.weapon = weaponToReplace;
            this.addToStrength(weapon.getAttack());
        }

    }

    public ArrayList<Potion> getPotion() {
        return potion;
    }

    public void setPotions(ArrayList<Potion> potion) {
        this.potion = potion;
    }

    public void printPotions(){
        int option = 0;
        for (Potion i: potion){

            option++;
            System.out.print(option + " - ");
            System.out.print(i.getName() + " ---> "+i.getHeal() + "HP\n");

        }
    }
    public void takePotion(int op){
        addToHp(this.potion.get(op).getHeal());
        this.potion.remove(op);

    }
    public void addToPotions(Potion potionToAdd){
        potion.add(potionToAdd);
    }
    public void printItems(){
        System.out.println("\nPotions available: \n");

        for (Potion i: potion){
            System.out.println(i.getName());
        }
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void levelUp(){
        this.level++;
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Level up" + ConsoleColors.RESET);
    }

    public void attack(NPC npc){

        double enemyHp = npc.getHp();
        enemyHp -= this.getStrength();

        System.out.println("PUM");
        npc.setHp(enemyHp);

    }

}
