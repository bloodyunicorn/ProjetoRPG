package Itens;

import java.util.ArrayList;

public class Weapon extends HeroItems{
    private int attack;

    private ArrayList<ItemHeroType> heroTypes;


    public  Weapon(String name, int attack, ArrayList allTypeItems, int price){

        super(name, price, allTypeItems);
        this.attack = attack;
        heroTypes = allTypeItems;

    }

    public int getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }


    public ArrayList<ItemHeroType> getHeroTypes() {
        return heroTypes;
    }


}
