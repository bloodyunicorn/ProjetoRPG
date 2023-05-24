package Game;
import Main.ConsoleColors;
import Entities.*;

import javax.swing.text.html.parser.Entity;

public class Game {

    public Game() {
    }
    NPC karen = new NPC("Wild Karen", 50, 5);
    NPC balrog = new NPC("Devious Balrog", 120, 50);
    NPC cereberus = new NPC("Cerberus", 100, 30);
    NPC bowser = new NPC("Bowser", 80, 20);
    NPC ogre = new NPC("Ogre", 60, 40);

    public boolean fight(Hero player, NPC enemy) {

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

    public void wonTheBattle(Hero player){
        player.increaseLevel();
        player.addToHp(10);
        player.addToStrength(1);
        player. addToGold(10);
    }


    public boolean maze(Hero player, int option) {

        boolean win;

        switch (option){
            case 1: break; //vendedor
            case 2:
                    player.showDetails();
                    System.out.println("A wild Karen appears! \nShe tries to nag you with a complaint about how blue the sky is. \nIt's hopeless to argue against her so you fight her.");

                    karen.showDetails();

                    win = fight(player, karen);

                    if (!win){
                        return false;
                    }
                        System.out.println("The Wild Karen ran away.\n");

                        wonTheBattle(player);

                        player.showDetails();

                        maze(player, 3);

                    break;

            case 3: win = fight(player, bowser);

                    if (!win){
                        return false;
                    }

                        System.out.println("Bowser was defeated.\n");

                        wonTheBattle(player);
                        player.showDetails();

                        maze(player, 1);

                    break;
            case 4: break;
            case 5: win = fight(player, cereberus);

                    if (!win){
                        return false;
                    }

                    System.out.println("Bowser was defeated.\n");

                    wonTheBattle(player);
                    player.showDetails();

                    maze(player, 1);
                    break;
            case 6: break;
            case 7: win = fight(player, ogre);

                    if (!win){
                        return false;
                    }

                    System.out.println("Bowser was defeated.\n");

                    wonTheBattle(player);
                    player.showDetails();

                    maze(player, 1);
                    break;
            case 8: break;
            case 9: win = fight(player, balrog);

                    if (!win){ return false; }

                    System.out.println("Bowser was defeated.\n");

                    wonTheBattle(player);
                    player.showDetails();

                    maze(player, 1);
                    break;
            case 10: break; //unicornio
            case 11: break;
            case 12: break;
        }

        return true;
    }
}

