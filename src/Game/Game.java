package Game;
import Itens.HeroItems;
import Itens.ItemHeroType;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;
import Entities.*;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);
    Hero player;

    public Game(Hero player) {

        this.player = player;
        seller.addItems(mjolnir);
        seller.addItems(bladesOfChaos);
        seller.addItems(sword);
        seller.addItems(scorpionCharm);
        seller.addItems(echoes);
        seller.addItems(talisman);
        seller.addItems(talonBow);
        seller.addItems(bow);
        seller.addItems(arch);
        seller.addItems(hp);
        seller.addItems(superHp);
        archerItems.add(ItemHeroType.ARCHER);
        knightItems.add(ItemHeroType.KNIGHT);
        mageItems.add(ItemHeroType.MAGE);
        allTypeItems.add(ItemHeroType.MAGE);
        allTypeItems.add(ItemHeroType.KNIGHT);
        allTypeItems.add(ItemHeroType.ARCHER);

    }

    public static Seller seller = new Seller();

    Weapon mjolnir = new Weapon("Mjölnir", 130, knightItems , 60);
    Weapon bladesOfChaos = new Weapon("Blades Of Chaos", 50, knightItems ,35);
    Weapon sword = new Weapon("Sword", 15, knightItems,20);
    Weapon scorpionCharm = new Weapon("The Magic Scorpion Charm", 130,mageItems , 60);
    Weapon echoes = new Weapon("Echoes of Helia", 50, mageItems,35);
    Weapon talisman = new Weapon("Talisman", 15, mageItems,20);
    Weapon talonBow = new Weapon("Talon Bow", 130, archerItems, 60);
    Weapon bow = new Weapon("Mechanic Bow", 50, archerItems, 35);
    Weapon arch = new Weapon("Arch", 15, archerItems, 20);
    Potion hp = new Potion("Hp potion", 25, allTypeItems, 5);
    Potion superHp = new Potion("Super Hp potion", 45, allTypeItems,9);

    public static ArrayList<ItemHeroType> archerItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> knightItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> mageItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> allTypeItems = new ArrayList<>();


    public boolean fight(NPC enemy) {

        System.out.println();
        if (player instanceof Knight) {
            enemy.attack(player);
            if (player.getHp() <= 0) {
                return false;
            }
        }

        while (player.getHp() >= 0 && enemy.getHp() >= 0) {
            player.attack(enemy);
            if (enemy.getHp() <= 0) {
                return true;
            }
            enemy.attack(player);
            if (player.getHp() <= 0) {
                return false;
            }
        }
            return true;
    }

    public void wonTheBattle(){
        player.levelUp();
        player.addToHp(10);
        player.addToStrength(1);
        player.addToGold(10);
        in.nextLine();
    }

    public boolean maze(int room, int option) {


        String answer;
        int op = 0;
        boolean win, check;

        switch (option){
            case 1:
                    System.out.println("'Hello good traveller, I'm just a humble seller walking by.\n\nLet me show you what I have here!'");
                    in.nextLine();

                    seller.selling(player);

                    maze(option, 2);

                    break;
            case 2: System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** sala2 *****" + ConsoleColors.RESET);

                System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 3;
                } else if (answer.equals("S")){
                    op = 4;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    in.nextLine();
                    op = 4;
                }
                maze(option, op);
                break;
            case 3:
                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** 3 historia *****" + ConsoleColors.RESET);


                wonTheBattle();
                player.showDetails();




                maze(option, 6);
                break;

            case 4:
                    player.showDetails();

                    in.nextLine();
                System.out.println("4");
                    System.out.println("A wild Karen appears! \nShe tries to nag you with a complaint about how blue the sky is. \nIt's hopeless to argue against her so you fight her.");

                    in.nextLine();
                    NPC.karen.showDetails();

                    win = fight(NPC.karen);

                    if (!win){
                        return false;
                    }
                    System.out.println("The Wild Karen ran away.\n");

                    in.nextLine();
                    wonTheBattle();

                    player.showDetails();

                    System.out.println("Now, you can continue your journey.");
                    in.nextLine();

                    maze(option, 20);


                    break;
            case 5:

                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** sala 5tesouro *****" + ConsoleColors.RESET);


                System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                System.out.println("Along the way you start to feel a bit tired. You are an hour away from the next Village.\nWould you like to stop and rest or continue? (S/C)");
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 7;//village
                } else if (answer.equals("S")){
                    op = 10;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    in.nextLine();
                    op = 10;
                }
                maze(option, op);

                break;

            case 6:
                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** 6 ogre *****" + ConsoleColors.RESET);
                win = fight(NPC.ogre);

                if (!win){
                    return false;
                }

                System.out.println("Ogre was defeated.\n");

                wonTheBattle();
                player.showDetails();


                maze(option, 20);
                break;

            case 7:
                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** The Village *****" + ConsoleColors.RESET);


                System.out.println("\nAs you arrive, villagers start to notice you. They already know what you are looking for.");
                System.out.println("You need to look around and find someone to point you to the right direction.\n\n.\n.\n.\n\n");

                in.nextLine();
                System.out.println("'What's that???'");
                in.nextLine();
                System.out.println("Looks like someone is following you.\nYou run towards him and find out it is a man with a big mustache.");
                System.out.println("This man tries to run but with no chance and you ask him why he was following you.");
                in.nextLine();
                System.out.println("'I'm sorry, I didn't mean to bother you. I've heard that you are looking for the Goblet of fire, and maybe i can help you. I just need a favour in exchange. \nWould you like to help me? (Y/N)");

                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("Y")){
                    op=8;
                } else if (answer.equals("N")){
                    op = 9;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 10;
                }
                maze(option, op);
                break;
            case 8:

                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** The Man with the Mustache *****" + ConsoleColors.RESET);
                in.nextLine();
                win = fight(NPC.bowser);

                if (!win){
                    return false;
                }

                System.out.println("Bowser was defeated and the Princess is Saved.\n");
                in.nextLine();

                wonTheBattle();
                player.showDetails();


                maze(option, 20);

                break;



            case 9: System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** sala9arma *****" + ConsoleColors.RESET);
                    System.out.println();
                    answer = in.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("C")){
                        op = 10;
                    } else if (answer.equals("S")){
                        op = 12;
                    } else {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                        in.nextLine();
                        op = 10;
                    }
                    maze(option, op);
                    break;
            case 10: System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** sala10 inimigo*****" + ConsoleColors.RESET);



                maze(option, 20);
                break;

            case 11: System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** sala11 tesouro *****" + ConsoleColors.RESET);




                maze(option, 12);
                break;

            case 12:    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "***** Balrog *****" + ConsoleColors.RESET);
                        win = fight(NPC.balrog);

                        if (!win){
                            return false;
                        }

                        System.out.println("Balrog was defeated.\n");
                        in.nextLine();

                        wonTheBattle();
                        return true;



            default:
                System.out.println("Seller: 'Hello again!'");
                seller.selling(player);

                maze(0, room+1);
        }
            return true;

    }
}

