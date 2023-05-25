package Game;
import Itens.HeroItems;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;
import Entities.*;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Hero player;

    public Game(Hero player) {

        this.player = player;
        Seller.seller.addItems(Weapon.mjolnir);
        Seller.seller.addItems(Weapon.bladesOfChaos);
        Seller.seller.addItems(Weapon.sword);
        Seller.seller.addItems(Weapon.scorpionCharm);
        Seller.seller.addItems(Weapon.echoes);
        Seller.seller.addItems(Weapon.talisman);
        Seller.seller.addItems(Weapon.talonBow);
        Seller.seller.addItems(Weapon.bow);
        Seller.seller.addItems(Weapon.arch);
        Seller.seller.addItems(Potion.hp);
        Seller.seller.addItems(Potion.superHp);

    }

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
            if (player.getHp() <= 0) {
                return false;
            }
            enemy.attack(player);
        }
            return true;
    }

    public void wonTheBattle(){
        player.increaseLevel();
        player.addToHp(10);
        player.addToStrength(1);
        player.addToGold(10);
    }




    public boolean maze(int room, int option) {

        Scanner in = new Scanner(System.in);
        String answer;
        int op = 0;
        boolean win, check;

        switch (option){
            case 1:
                    System.out.println("'Hello good traveller, I'm just a humble seller walking by.\nLet me show you what I have here?'\n");

                    Seller.seller.selling(player);

                    maze(option, 2);

                    break;
            case 2:
                    player.showDetails();
                    System.out.println("A wild Karen appears! \nShe tries to nag you with a complaint about how blue the sky is. \nIt's hopeless to argue against her so you fight her.");

                    NPC.karen.showDetails();

                    win = fight(NPC.karen);

                    if (!win){
                        return false;
                    }
                        System.out.println("The Wild Karen ran away.\n");

                        wonTheBattle();

                        player.showDetails();

                    System.out.println("Now, you can continue your journey.");
                    System.out.println("Along the way you start to feel a bit tired. You are an hour away from the next Village.\nWould you like to stop and rest or continue? (S/C)");
                    answer = in.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("C")){
                        op = 4;//village
                    } else if (answer.equals("S")){
                        op = 7;//ogre
                    } else {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                        op = 7;//ogre
                    }
                        maze(option, op);

                    break;

            case 3:

                    System.out.println("***** The Man with the Mustache *****");



                    win = fight(NPC.bowser);

                    if (!win){
                        return false;
                    }

                    System.out.println("Bowser was defeated and the Princess is Saved.\n");

                    wonTheBattle();
                    player.showDetails();


                    maze(option, 20);

                    break;
            case 4:
                System.out.println("***** The Village *****");

                System.out.println("\nAs you arrive, villagers start to notice you. They already know what you are looking for.");
                System.out.println("You need to look around and find someone to point you to the right direction.\n\n.\n.\n.\n\n");

                System.out.println("'What's that???'");
                System.out.println("Looks like someone is following you.\nYou run towards him and find out it is a man with a big mustache.");
                System.out.println("This man tries to run but with no chance and you ask him why he was following you.");
                System.out.println("'I'm sorry, I didn't mean to bother you. I've heard that you are looking for the Goblet of fire, and maybe i can help you. I just need a favour in exchange. \nWould you like to hear it? (Y/N)");

                System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("Y")){
                    maze(option, 3);
                } else if (answer.equals("N")){
                    op = 6;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 3;
                }

                break;
            case 5: win = fight(NPC.cereberus);

                    if (!win){
                        return false;
                    }

                    System.out.println("Cereberus was defeated.\n");

                    wonTheBattle();
                    player.showDetails();

                    System.out.println();
                    answer = in.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("C")){
                        op = 4;
                    } else if (answer.equals("S")){
                        op = 7;
                    } else {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                        op = 7;
                    }
                    maze(option, op);
                    break;
            case 6:


                    System.out.println();
                    answer = in.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("C")){
                        op = 4;
                    } else if (answer.equals("S")){
                        op = 7;
                    } else {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                        op = 7;
                    }
                    maze(option, op);
                    break;
            case 7: win = fight(NPC.ogre);

                    if (!win){
                        return false;
                    }

                    System.out.println("Ogre was defeated.\n");

                    wonTheBattle();
                    player.showDetails();

                System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 4;
                } else if (answer.equals("S")){
                    op = 7;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 7;
                }
                maze(option, op);
                    break;
            case 8: System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 4;
                } else if (answer.equals("S")){
                    op = 7;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 9;
                }
                maze(option, op);
                break;
            case 9:
                    System.out.println();
                    answer = in.nextLine();
                    answer = answer.toUpperCase();

                    if (answer.equals("C")){
                        op = 8;
                    } else if (answer.equals("S")){
                        op = 7;
                    } else {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                        op = 7;
                    }
                    maze(option, op);
                    break;
            case 10: System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 9;
                } else if (answer.equals("S")){
                    op = 7;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 6;
                }
                maze(option, op);
                break; //unicornio
            case 11: System.out.println();
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("C")){
                    op = 4;
                } else if (answer.equals("S")){
                    op = 7;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    op = 12;
                }
                maze(option, op);
                break;
            case 12: win = fight(NPC.balrog);

                    if (!win){
                        return false;
                    }

                        System.out.println("Balrog was defeated.\n");

                        wonTheBattle();
                        player.showDetails();

                        maze(12, 1);
                        break;
            default:
                System.out.println("Seller: 'Hello again!'");
                Seller.seller.selling(player);

                maze(option, 9);
        }
            return true;

    }
}

