package Itens;

import Entities.Hero;

import java.util.ArrayList;

public abstract class HeroItems {

    private String name;
    private int price;
    private ArrayList<ItemHeroType> heroType;

    public HeroItems(String name, int price, ArrayList heroType){
        this.name = name;
        this.price = price;
        this.heroType = heroType;
    }

    public abstract void showDetails();
    public ArrayList<ItemHeroType> getHeroType() {
        return heroType;
    }

    public void setHeroType(ArrayList<ItemHeroType> heroType) {
        this.heroType = heroType;
    }
    public void addToHeroType(ItemHeroType hero){

        heroType.add(hero);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
