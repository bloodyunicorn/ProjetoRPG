package Itens;

import java.util.ArrayList;

public class Potion extends HeroItems {

    private int heal = 0;


    /**
     * costrutor
     * @param name
     * @param heal
     * @param heroTypes
     * @param price
     */

    public  Potion(String name, int heal, ArrayList heroTypes, int price){
        super(name, price, heroTypes);
        this.heal = heal;
    }

    /**
     * mostra detalhes da poção
     */
    @Override
    public void showDetails() {
        System.out.println("Name: " + this.getName());
        System.out.println("Heal: " + this.heal);
        System.out.println("Hero types: ");
        for (ItemHeroType i : this.getHeroType()){
            System.out.print(i);
        }
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

}
