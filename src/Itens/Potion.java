package Itens;

import java.util.ArrayList;

public class Potion extends HeroItems {

    private int heal = 0;

    public  Potion(String name, int heal, ArrayList heroTypes, int price){
        super(name, price, heroTypes);
        this.heal = heal;
    }


    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

}
