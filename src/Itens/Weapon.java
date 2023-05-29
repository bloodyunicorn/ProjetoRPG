package Itens;

import java.util.ArrayList;

public class Weapon extends HeroItems{
    private int attack;

    private ArrayList<ItemHeroType> heroTypes;


    /**
     * construtor
     * @param name
     * @param attack
     * @param allTypeItems
     * @param price
     */
    public  Weapon(String name, int attack, ArrayList allTypeItems, int price){

        super(name, price, allTypeItems);
        this.attack = attack;
        heroTypes = allTypeItems;

    }

    /**
     * mostra detalhes
     */
    @Override
    public void showDetails() {
        System.out.println("Name: " + this.getName());
        System.out.println("Damage: " + this.getAttack());
        System.out.println("Hero types: ");
        for (ItemHeroType i : this.heroTypes){
            System.out.print(i);
        }
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
