package Entities;

import Itens.HeroItems;
import Itens.ItemHeroType;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Seller {
    private ArrayList<HeroItems> items = new ArrayList<HeroItems>();

    public Seller() {

    }

    /**
     * adiciona item
     * @param item
     */
    public void addItems(HeroItems item){
        items.add(item);
    }

    /**
     * vende item - verifica tipo de heroi e ouro do jogador. se for arma remove do inventario. add itens ao heroi
     * @param op
     * @param player
     */
    public void sellItem(int op, Hero player){
        op -= 1;

        boolean verifyHeroType = false;


        for( ItemHeroType i : (items.get(op)).getHeroType())  {

            if(i.toString().equals(player.getClass().getSimpleName().toUpperCase())){
                verifyHeroType = true;
                break;
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
            System.out.println("This Item can only be used by " + (items.get(op)).getHeroType());
        }

    }

    public ArrayList<HeroItems> getItems() {
        return items;
    }

    /**
     * imprime itens
     */
    public void printItems(){

        int option = 0;
        for (HeroItems i: items){

            option++;
            System.out.print(option + " - " + ConsoleColors.PURPLE_UNDERLINED + i.getName() + ConsoleColors.RESET + " - Increases ");
            if (i instanceof Weapon){
                System.out.print(((Weapon)i).getAttack() + " pts of "+ConsoleColors.RED_BOLD_BRIGHT + "Strength" + ConsoleColors.RESET);
            } else{
                System.out.print(((Potion)i).getHeal() + ConsoleColors.GREEN_BOLD_BRIGHT + " HP" + ConsoleColors.RESET);
            }
            System.out.print(" ---> " + ConsoleColors.YELLOW_BOLD_BRIGHT + i.getPrice() + " golden coins \n" + ConsoleColors.RESET);


        }

    }

    /**
     * pergunta se quer comprar, chama funcoes sellItem e printItems
     * @param player
     */
    public void selling(Hero player) {
        Scanner in = new Scanner(System.in);
        this.printItems();

        System.out.println("\nYou have " + ConsoleColors.YELLOW_BOLD_BRIGHT + player.getGold() + "golden coins" + ConsoleColors.RESET);

        boolean check;

        do {

            check = true;

            System.out.println("\nWould you like to buy any of this items? (Y/N)");
            String answer = in.nextLine();
            answer = answer.toUpperCase();

            if (answer.equals("Y")) {

                do {

                    System.out.println("Which one?");

                    try {
                        int op = in.nextInt();
                        this.sellItem(op, player);

                        System.out.println("\nAnything else? (Y/N)");

                        String tempAnswer = in.next();
                        tempAnswer = tempAnswer.toUpperCase();
                        answer = tempAnswer;

                        if (answer.equals("Y")) {
                            this.printItems();

                        } else if (answer.equals("N")) {
                            System.out.println("It was a pleasure to do business with you!\n");
                            return;
                        } else {
                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                        }

                    }catch (InputMismatchException exc){
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                        in.next();
                    }catch (IndexOutOfBoundsException exception){
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                        in.nextLine();
                    }

                } while (answer.equals("Y"));

            } else if (answer.equals("N")) {

                System.out.println("Maybe next time.\n");

            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                check = false;
            }
        } while (!check);
    }

}
