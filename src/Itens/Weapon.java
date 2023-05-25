package Itens;

import java.util.ArrayList;

public class Weapon extends HeroItems{
    private int attack;

    public static ArrayList<ItemHeroType> archerItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> knightItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> mageItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> allTypeItems = new ArrayList<>();
    public  Weapon(String name, int attack, ArrayList allTypeItems, int price){

        super(name, price, allTypeItems);
        this.attack = attack;
        archerItems.add(ItemHeroType.ARCHER);
        knightItems.add(ItemHeroType.KNIGHT);
        mageItems.add(ItemHeroType.MAGE);
        allTypeItems.add(ItemHeroType.MAGE);
        allTypeItems.add(ItemHeroType.KNIGHT);
        allTypeItems.add(ItemHeroType.ARCHER);
    }

    public int getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public static Weapon mjolnir = new Weapon("Mjölnir", 130, knightItems , 60);

    public static Weapon bladesOfChaos = new Weapon("Blades Of Chaos", 50, knightItems ,35);
    public static Weapon sword = new Weapon("Sword", 15, knightItems,20);
    public static Weapon scorpionCharm = new Weapon("The Magic Scorpion Charm", 130,mageItems , 60);
    public static Weapon echoes = new Weapon("Echoes of Helia", 50, mageItems,35);
    public static Weapon talisman = new Weapon("Talisman", 15, mageItems,20);
    public static Weapon talonBow = new Weapon("Talon Bow", 130, archerItems, 60);
    public static Weapon bow = new Weapon("Mechanic Bow", 50, archerItems, 35);
    public static Weapon arch = new Weapon("Arch", 15, archerItems, 20);


}
