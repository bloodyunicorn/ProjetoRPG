package Entities;

import Itens.HeroItems;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;

import java.util.ArrayList;

public class Seller {
    private ArrayList<HeroItems> items = new ArrayList<HeroItems>();

    public Seller() {

    }

    public void addItems(HeroItems item){
        items.add(item);
    }
    public void sellItem(int op, Hero player){
        op -= 1;

        if (player.getGold() >= items.get(op).getPrice()) {

            if (items.get(op) instanceof Weapon) {
                player.setWeapon((Weapon) items.get(op));
                items.remove(op);
            } else {
                player.addToPotions((Potion) items.get(op));
            }

        } else {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "You don't have enough golden coins!\n" + ConsoleColors.RESET);
            System.out.println("Golden Coins: " + ConsoleColors.YELLOW_BRIGHT + player.getGold() + ConsoleColors.RESET);
        }

    }

    public ArrayList<HeroItems> getItems() {
        return items;
    }

    public void printItems(){

        int option = 0;
        for (HeroItems i: items){

            option++;
            System.out.print(option + " - ");
            System.out.print(i.getName() + "\nGives you ");
            if (i instanceof Weapon){
                System.out.print(((Weapon) i).getAttack() + " pts of Strength ");
            } else{
                System.out.print(((Potion)i).getHeal() + "HP ");
            }
            System.out.print("\n---> " + i.getPrice() + " golden coins\n\n");
        }



    }
}
