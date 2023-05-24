package Itens;

public class Weapon extends HeroItems{
    private int attack;

    public  Weapon(String name, int attack, int price){
        super(name, price);
        this.attack = attack;
    }


    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


}
