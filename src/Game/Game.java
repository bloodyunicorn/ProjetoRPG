package Game;
import Itens.HeroItems;
import Itens.Potion;
import Itens.Weapon;
import Main.ConsoleColors;
import Entities.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

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

    }

    Seller seller = new Seller();

    //items
    Weapon mjolnir = new Weapon("Mjölnir", 130, 60);
    Weapon bladesOfChaos = new Weapon("Blades Of Chaos", 50, 35);
    Weapon sword = new Weapon("Sword", 15, 20);
    Weapon scorpionCharm = new Weapon("The Magic Scorpion Charm", 130, 60);
    Weapon echoes = new Weapon("Echoes of Helia", 50, 35);
    Weapon talisman = new Weapon("Talisman", 15, 20);
    Weapon talonBow = new Weapon("Talon Bow", 130, 60);
    Weapon bow = new Weapon("Mechanic Bow", 50, 35);
    Weapon arch = new Weapon("Arch", 15, 20);
    Potion hp = new Potion("Hp potion", 25, 5);
    Potion superHp = new Potion("Super Hp potion", 45, 9);

    //NPCs
    NPC karen = new NPC("Wild Karen", 50, 5);
    NPC balrog = new NPC("Devious Balrog", 120, 50);
    NPC cereberus = new NPC("Cerberus", 100, 30);
    NPC bowser = new NPC("Bowser", 80, 20);
    NPC ogre = new NPC("Ogre", 60, 40);


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

    public void selling(){
        Scanner in = new Scanner(System.in);
        seller.printItems();

        System.out.println("Golden Coins: " + ConsoleColors.YELLOW_BRIGHT + player.getGold() + ConsoleColors.RESET);

        System.out.println("\nWould you like to buy any of this items? (Y/N)");
        String answer = in.nextLine();
        answer = answer.toUpperCase();
        boolean check = true;

        while (answer.equals("Y")){

            System.out.println("Which one?");
            int op = in.nextInt();
            seller.sellItem(op, player);

            System.out.println("\nAnything else? (Y/N)");
            String tempAnswer = in.next();
            tempAnswer = tempAnswer.toUpperCase();

            answer = tempAnswer;

            System.out.println(answer);
            if (answer.equals("Y") || answer.equals("YES")){
                seller.printItems();
            } else  {
                System.out.println("It was a pleasure to do business with you!");
                return;
            }

        }

        System.out.println("Maybe next time.");

    }


    public boolean maze(int room, int option) {

        Scanner in = new Scanner(System.in);
        String answer;
        int op = 0;
        boolean win, check;

        switch (option){
            case 1:
                    System.out.println("Hello good traveller, I'm just a humble seller walking by.\nLet me show you what I have here?\n");

                    selling();


                    break;
            case 2:
                    player.showDetails();
                    System.out.println("A wild Karen appears! \nShe tries to nag you with a complaint about how blue the sky is. \nIt's hopeless to argue against her so you fight her.");

                    karen.showDetails();

                    win = fight(karen);

                    if (!win){
                        return false;
                    }
                        System.out.println("The Wild Karen ran away.\n");

                        wonTheBattle();

                        player.showDetails();

                        maze(2, 3);

                    break;

            case 3: win = fight(bowser);

                    if (!win){
                        return false;
                    }

                        System.out.println("Bowser was defeated.\n");

                        wonTheBattle();
                        player.showDetails();

                        maze(3, 1);

                    break;
            case 4: break;
            case 5: win = fight(cereberus);

                    if (!win){
                        return false;
                    }

                    System.out.println("Cereberus was defeated.\n");

                    wonTheBattle();
                    player.showDetails();

                    maze(5, 1);
                    break;
            case 6: break;
            case 7: win = fight(ogre);

                    if (!win){
                        return false;
                    }

                    System.out.println("Ogre was defeated.\n");

                    wonTheBattle();
                    player.showDetails();

                    maze(7, 1);
                    break;
            case 8: break;
            case 9:
            case 10: break; //unicornio
            case 11: break;
            case 12: win = fight(balrog);

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
                selling();

                maze(0, room);
        }
            return true;

    }
}

