package Itens;

public class Potion extends HeroItems {

    private int heal;

    public  Potion(String name, int heal, int price){
        super(name, price);
        this.heal = heal;
    }


    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
}
