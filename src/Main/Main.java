package Main;

import Entities.*;
import Game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        Game game = new Game();

        Knight test = new Knight("xxx", 20);
        test.setStrength(40);
        test.setHp(80);

        game.maze(test, 2);


        System.out.println(ConsoleColors.YELLOW_UNDERLINED + "\n\n***** Really Epic and Confusing Game *****\n\n" + ConsoleColors.RESET);


        System.out.print("Please, enter your name: ");
        String name = in.nextLine();

        boolean valid = true, tryAgain = true;
        int gold = 0, points = 0;
        double strength = 0, hp = 0;

        Hero player = null;

        do {
            do {
                valid = true;
                System.out.print("\nWhat kind of Hero are you?\n");
                System.out.println("1 - Fearless Knight\n2 - Wise Mage\n3 - Agile Archer ");
                System.out.print("\n-> ");
                int hero = in.nextInt();

                switch (hero) {
                    case 1:
                        player = new Knight(name, gold);
                        break;
                    case 2:
                        player = new Mage(name, gold);
                        break;
                    case 3:
                        player = new Archer(name, gold);
                        break;
                    default:
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                        valid = false;
                        break;

                }
            } while (!valid);

            do {

                valid = true;

                System.out.println("\nChoose the adventure difficulty (E - easy | H - hard)");
                String mode = in.next();
                mode = mode.toUpperCase();

                switch (mode) {
                    case "E":
                        gold = 20;
                        points = 300;
                        break;
                    case "H":
                        gold = 15;
                        points = 220;
                        break;
                    default:

                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!" + ConsoleColors.RESET);
                        valid = false;
                        break;
                }
            } while (!valid);

            System.out.println("\nPlease distribute " + ConsoleColors.YELLOW_UNDERLINED + points + "points" + ConsoleColors.RESET + " between HP and Strength. \nEach 5 points can increase Strength by or HP by 5.");

            String confirm;

            do {
                int tempPoints = points;

                do {

                    System.out.print("Points to HP: ");
                    hp = in.nextDouble();
                    if (hp >= points) {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nThere's only " + points + "points to use, please try again!" + ConsoleColors.RESET);
                    }
                } while (hp > points);

                tempPoints -= hp;
                strength = tempPoints / 5;
                System.out.println("Points to Strenght: " + strength);


                System.out.println("Is this right? (Y/N)");
                confirm = in.next();
                confirm = confirm.toUpperCase();

            } while (confirm.equals("N"));

            player.setHp(hp);
            player.setStrength(strength);
            player.setGold(gold);

            System.out.println("\nHello " + name + ", welcome to RECG!");
            System.out.println("\nWe need your help to recover the stolen " + ConsoleColors.YELLOW + "Goblet of Fire." + ConsoleColors.RESET);
            System.out.println("It is very valuable to our community and we will pay you the amount of " + ConsoleColors.YELLOW_UNDERLINED + "*2000 golden coins*" + ConsoleColors.RESET + " if you bring it back from the hands of the Devious Balrog.");
            System.out.println("But watch out! There will be dangers in your path, enemies to defeat and other perils to overcome.");
            System.out.println("We will give you " + gold + " golden coins to begin your journey.\n\nThe Lord of Light wishes you the best fortune in your adventure!");



            int option = 0;

            boolean win = game.maze(player, option);

            if (!win) {
                System.out.println("GAME OVER");

                System.out.println("Would you like to try again? (Y/N)");
                String ans = in.next();
                ans = ans.toUpperCase();

                if( ans.equals("N")){
                    tryAgain = false;
                } else {
                    tryAgain = true;
                }

            }

        }while(tryAgain == true);
    }
}