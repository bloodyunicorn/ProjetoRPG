package Entities;

import Itens.HeroItems;
import Itens.ItemHeroType;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class Seller {
    private ArrayList<HeroItems> items = new ArrayList<HeroItems>();

    public Seller() {

    }

    public void addItems(HeroItems item){
        items.add(item);
    }
    public void sellItem(int op, Hero player){
        op -= 1;

        boolean verifyHeroType = false;
        for(ItemHeroType i : items.get(op).getHeroType())  {
            if(i.toString().equals(player.getClass().toString().toUpperCase())){
                  verifyHeroType = true;
            }
        }
        if(verifyHeroType==true){


            if (player.getGold() >= items.get(op).getPrice()) {

                player.takeFromGold(items.get(op).getPrice());
                if (items.get(op) instanceof Weapon) {
                    player.setWeapon((Weapon) items.get(op));
                    items.remove(op);
                } else {
                    player.addToPotions((Potion) items.get(op));
                }


            }else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "You don't have enough golden coins!\n" + ConsoleColors.RESET);
                System.out.println("Golden Coins: " + ConsoleColors.YELLOW_BRIGHT + player.getGold() + ConsoleColors.RESET);
            }
        }else {
            System.out.println("This Item can only be used by " + items.get(op).getHeroType());
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
            System.out.print(i.getName() + " ---> " + i.getPrice() + " golden coins\nGives you ");
            if (i instanceof Weapon){
                System.out.print(((Weapon) i).getAttack() + " pts of Strength \n\n");
            } else{
                System.out.print(((Potion)i).getHeal() + "HP \n\n");
            }

        }

    }
    public void selling(Hero player){
        Scanner in = new Scanner(System.in);
        this.printItems();

        System.out.println("Golden Coins: " + ConsoleColors.YELLOW_BRIGHT + player.getGold() + ConsoleColors.RESET);

        System.out.println("\nWould you like to buy any of this items? (Y/N)");
        String answer = in.nextLine();
        answer = answer.toUpperCase();
        boolean check = true;

        while (answer.equals("Y")){

            System.out.println("Which one?");
            int op = in.nextInt();
            this.sellItem(op, player);

            System.out.println("\nAnything else? (Y/N)");
            String tempAnswer = in.next();
            tempAnswer = tempAnswer.toUpperCase();

            answer = tempAnswer;

            System.out.println(answer);
            if (answer.equals("Y") || answer.equals("YES")){
                this.printItems();
            } else  {
                System.out.println("It was a pleasure to do business with you!");
                return;
            }

        }

        System.out.println("Maybe next time.");

    }
    public static Seller seller = new Seller();
}
