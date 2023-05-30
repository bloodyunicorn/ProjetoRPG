package Entities;

import java.util.ArrayList;
import Itens.*;
import Main.ConsoleColors;

public abstract class Hero extends Entity{

    private int level=1;
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

    /**
     * mostra nome, hp, força , nivel e ouro
     */
    @Override
    public void showDetails() {
        System.out.println(ConsoleColors.PURPLE_UNDERLINED + "\nHero Details" + ConsoleColors.RESET);
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
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "+ " + gold + " golden coins" + ConsoleColors.RESET);
    }
    public void takeFromGold(int gold){

        this.setGold(this.gold - gold);
        System.out.println(ConsoleColors.RED + "- " + gold + " golden coins" + ConsoleColors.RESET );
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * substitui a arma, aumenta a força do heroi e retira a força da arma anterior
     * @param weaponToReplace
     */
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

    /**
     * Imprime poções
     */
    public void printPotions(){
        int option = 0;
        System.out.println("Your potions:");
        for (Potion i: potion){

            option++;
            System.out.print(option + " - ");
            System.out.print(i.getName() + " ---> "+ConsoleColors.GREEN_BOLD_BRIGHT +i.getHeal() + "HP\n\n"+ ConsoleColors.RESET);

        }
    }

    /**
     * toma poção
     * @param op
     */
    public void takePotion(int op) {

        addToHp(this.potion.get(op).getHeal());
        this.potion.remove(op);

    }

    /**
     * adiciona poção
     * @param potionToAdd
     */
    public void addToPotions(Potion potionToAdd){
        potion.add(potionToAdd);
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + potionToAdd.getName() + " added to your inventory." + ConsoleColors.RESET);
    }

    /**
     *         mostra poçoes disponiveis
     */
    public void printItems(){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\nPotions available: \n" + ConsoleColors.RESET);

        for (Potion i: potion){
            System.out.println(i.getName());
        }
    }
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * aumenta de nivel
     */
    public void levelUp(){
        this.level++;
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Level up" + ConsoleColors.RESET);
    }

    /**
     * ataca o NPC
     * @param npc
     */
    public void attack(NPC npc){

        double enemyHp = npc.getHp();
        enemyHp -= this.getStrength();

        System.out.println(ConsoleColors.GREEN + "PUM" + ConsoleColors.RESET);
        npc.setHp(enemyHp);

    }

}
