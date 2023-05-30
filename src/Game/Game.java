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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);
    Hero player;

    boolean win = true;
    /**
     * construtor que adiciona itens ao vendedor e aos arrays de tipo de heroi
     * @param player
     */
    public Game(Hero player) {

        this.player = player;
        if (!seller.getItems().isEmpty()) {

            seller.getItems().removeAll(seller.getItems());

        }
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

    NPC karen = new NPC("Wild Karen", 30, 5);
    NPC alghoul = new NPC("Alghoul",120 , 35);
    NPC balrog = new NPC("Devious Balrog", 200, 60);
    NPC bowser = new NPC("Bowser", 100, 30);
    NPC ogre = new NPC("Ogre", 60, 40);
    NPC witch = new NPC("Evil Witch", 50, 20);
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
    Potion miniHp = new Potion("Weak Hp Potion", 20, allTypeItems, 0);
    Weapon charm = new Weapon("Charm", 60, mageItems, 0);
    Weapon specialBow = new Weapon("Special Bow", 60, archerItems, 0);
    Weapon spear = new Weapon("Spear", 60, knightItems, 0);
    public static ArrayList<ItemHeroType> archerItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> knightItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> mageItems = new ArrayList<>();
    public static ArrayList<ItemHeroType> allTypeItems = new ArrayList<>();


    /**
     * Luta, chama fução atacar de cada um. Verifica o tipo de jogador e condiciona dependendo desse
     * @param enemy
     * @return
     */
    public boolean fight(NPC enemy) {

        enemy.reset();
        System.out.println();
        if (player instanceof Knight) {
            enemy.attack(player);
            if (player.getHp() <= 0) {
                System.out.println("You have died. The enemy was too strong for you.");
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
                System.out.println("You have died. The enemy was too strong for you.");
                return false;
            }
        }
            return true;
    }

    /**
     * verifica se tem poçoes e pergunta se quer utilizar
     */
    public void potion(){

        boolean valid = true;
        if (player.getPotion().isEmpty()){
            System.out.println(ConsoleColors.RED + "You dont have any potions.\n" + ConsoleColors.RESET);
        } else {

            player.printPotions();


            do {
                System.out.println("Would you like to use a potion? "+ConsoleColors.WHITE_BOLD_BRIGHT +"(Y/N)"+ConsoleColors.RESET);
                char answer = in.next().charAt(0);

                if (answer == ('Y') || answer == ('y')) {
                    do {

                        System.out.println("Which one?");
                        try {
                            int op = in.nextInt();
                            op--;
                            player.takePotion(op);
                            valid=true;
                        } catch (InputMismatchException exc) {

                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!\n" + ConsoleColors.RESET);
                            valid = false;
                        } catch (IndexOutOfBoundsException exc){
                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!\n" + ConsoleColors.RESET);
                            valid = false;
                        }
                    } while (!valid);
                } else if (answer == 'N' || answer == 'n') {

                } else {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nInvalid choice!\n" + ConsoleColors.RESET);
                    valid = false;
                }
            } while (!valid);

        }
    }
    /**
     * metodo chamado depois de cada vitoria. aumenta o nivel, o hp, a força e o ouro.
     */
    public void wonTheBattle(){
        player.levelUp();
        player.addToHp(10);
        player.addToStrength(1);
        player.addToGold(10);
        in.nextLine();
    }

    /**
     * Labirinto
     * tem a historia e o caminho. tem recursividade.
     * @param room
     * @param option
     * @return
     */
    public boolean maze(int room, int option) {

        String answer;
        int op = 0;

        switch (option) {
            case 1 -> {
                System.out.println("'Hello good traveller, I'm just a humble seller walking by.'\n\n'Let me show you what I have here!'");
                in.nextLine();
                seller.selling(player);
                maze(option, 2);
                break;
            }
            case 2 -> {
                System.out.println("And thus your journey begins!");
                in.nextLine();
                System.out.println("After a few minutes out, you cross the main bridge over the river, and look back at your hometown, hoping you see it soon.");
                in.nextLine();
                System.out.println("You should not have looked back, a fat ugly ogre rushes you from the bridge!");
                in.nextLine();
                System.out.println("You knew better... You knew the stories, of the ogre, raised by trolls, lurking just outside of town.");

                System.out.println("It doesn't give you a chance. Fight or die!");
                in.nextLine();
                ogre.showDetails();
                win = fight(ogre);
                if (!win) {
                    break;
                }
                System.out.println("\nOgre was defeated. It flees back into the shadows under the bridge.\n");
                wonTheBattle();
                player.showDetails();
                potion();
                System.out.println("This short victory gives you thirst.");
                in.nextLine();
                System.out.println("After a few steps away from the bridge, you sit by the river, take a moment to breath, and wet your face with the cold water running in front of you.");
                in.nextLine();
                System.out.println("Horse footsteps catch your ear. You look and see a beautiful, country woman in a carriage.");
                System.out.println("She seems friendly, smiles at you as both exchange pleasantries.");
                in.nextLine();
                System.out.println("'I'm going to Temeria, would you like a ride?' she asks you. "+ ConsoleColors.WHITE_BOLD_BRIGHT +"(Y/N)" + ConsoleColors.RESET);
                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("Y")) {
                    op = 3;
                } else if (answer.equals("N")) {
                    System.out.println("You thank her generosity, but decline. After all, you travel Han.\nShe smiles and winks at you, wishing you good fortune as she rides away.");
                    in.nextLine();
                    op = 4;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    in.nextLine();
                    System.out.println("You thank her generosity, but decline. After all, you travel Han.\nShe smiles and winks at you, wishing you good fortune as she rides away.");
                    in.nextLine();
                    op = 4;
                }
                maze(option, op);
            }
            case 3 -> {
                System.out.println("You accept and hop on the carriage as it takes off.");
                in.nextLine();
                System.out.println("A few moments into the trip, she asks why you are traveling to Temeria. \nThe look of surprise on her face is evident when you explain the quest for the Goblet of Fire.");
                in.nextLine();
                System.out.println("'Most people fear the mighty Balrog. Are you not afraid?'");
                if (player instanceof Knight) {
                    System.out.println("Of course not. I'm a member of the order of the Fearless Knights. I eat Balrogs for breakfast.");
                } else {
                    System.out.println("Of course I am, only a fool would embark on this journey recklessly. But I must, many are depending on it.");
                }
                in.nextLine();
                System.out.println("Thinking you don't notice, the woman begins waving her hand. Something sparkles out of it.");
                in.nextLine();
                System.out.println("Should you hop off and run away " + ConsoleColors.WHITE_BOLD_BRIGHT + "(R)" + ConsoleColors.RESET + " or will you stay and continue the journey " + ConsoleColors.WHITE_BOLD_BRIGHT + "(C)?" + ConsoleColors.RESET);
                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("C")) {
                    op = 6;
                } else {
                    if (!answer.equals("R")) {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    }
                    System.out.println("Something about her makes you feel very uneasy. You don't even think about it. You just jump and run.");
                    in.nextLine();
                    System.out.println("After a few minutes, you stop by a tree and look back.\nShe's nowhere in sight, you lost her. Thankfully, you think to yourself, not even sure of why.");
                    in.nextLine();
                    System.out.println("As you catch your breadth, you look up the tree. An apple catches your eye. Hungry as you are, you pick it up and eat it.");
                    in.nextLine();
                    player.addToHp(5);
                    op = 4;
                }
                maze(option, op);
            }
            case 4 -> {
                System.out.println("Feeling rejuvenated, you continue onwards, towards the Mirkwood Forest.");
                in.nextLine();
                System.out.println("It's a peaceful place, birds are chirping, the sun shines through the leaves.\nWhat could go wrong?");
                in.nextLine();
                System.out.println("What always goes wrong...");
                in.nextLine();
                System.out.println("\nA wild Karen appears! \nShe tries to nag you, complaining about how blue they made the sky.");
                in.nextLine();
                System.out.println("'Who?' You try to ask between her mad ramblings, but it's hopeless to argue against her.\nSo you take the most sensible action, fight her.");
                in.nextLine();
                karen.showDetails();

                win = fight(karen);
                if (!win) {
                    break;
                }
                System.out.println("\nYou throw a rock at her and the Wild Karen ran away.\n");
                in.nextLine();
                wonTheBattle();
                player.showDetails();
                potion();
                System.out.println("Now, you can continue your journey.\nAnd look who you run into, the salesman from earlier.");
                in.nextLine();
                maze(option, 20);
            }
            case 5 -> {
                System.out.println("You wave to the salesman and continue onwards.");
                in.nextLine();
                System.out.println("As you walk through the trees, you notice a patch of earth that seems to have been moved recently.");
                System.out.println("You settle your thing by a tree near it, and begin digging.");
                in.nextLine();
                System.out.println("After a few moments, you pull up a chest that had been buried there. It opens easily.");
                HeroItems x;
                if (player instanceof Knight) {
                    System.out.println("Inside is a Spear!\n");
                    x = spear;
                } else if (player instanceof Mage) {
                    System.out.println("Inside is a Charm!\n");
                    x = charm;
                } else {
                    System.out.println("Inside is a Special Bow!\n");
                    x = specialBow;
                }
                x.showDetails();

                in.nextLine();
                if (player.getWeapon()!=null) {
                    System.out.println("Your current weapon gives you " + player.getWeapon().getAttack() + " points of Strength");
                } else {
                    System.out.println("You don't have a weapon yet.");
                }
                System.out.println("Would you like to equip it?"+ ConsoleColors.WHITE_BOLD_BRIGHT + " (Y/N)" + ConsoleColors.RESET);
                answer = in.nextLine();
                answer = answer.toUpperCase();

                if (answer.equals("Y")) {
                    player.setWeapon((Weapon)x);
                } else{
                    System.out.println("You put it down, grab your things, and continue on your journey.");
                }
                in.nextLine();
                System.out.println("Along the way you start to feel a bit tired. You are an hour away from the next Village.\nWould you like to stop and rest " + ConsoleColors.WHITE_BOLD_BRIGHT + "(S)" +ConsoleColors.RESET+" or continue "+ ConsoleColors.WHITE_BOLD_BRIGHT +"(C)"+ConsoleColors.RESET + "?");
                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("C")) {
                    op = 7;
                } else if (answer.equals("S")) {
                    op = 10;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    in.nextLine();
                    op = 10;
                }
                potion();
                maze(option, op);
            }
            case 6 -> {
                if (player instanceof Knight) {
                    System.out.println("'Oh you are so brave! I admire you brave knight.'");
                } else {
                    System.out.println("'Oh you are very wise! I admire your wisdom.");
                }
                System.out.println("She says this as she smiles at you. Her eyes are fixed on yours. \nSuddenly, the world seems to fade away behind her eyes and her smile.");
                in.nextLine();
                if (player instanceof Mage) {
                    System.out.println("SHE'S TRYING TO BEWITCH YOU!");
                    in.nextLine();
                    System.out.println("Of course she can't. Her magic has no hold over you, as you already have control over magic yourself.");
                    in.nextLine();
                    System.out.println("With a few mumbled words, you counter her spell. The veil falls instantly, and you see her as the old, wrinkled witch that she really is.");
                } else {
                    System.out.println("You feel drawn to her. Almost falling into a black hole of bliss.");
                    in.nextLine();
                    System.out.println("Suddenly, the carriage rolls over a large rock, shaking you and making you bang your head against it.");
                    in.nextLine();
                    System.out.println("You wake up from the trance and see her as the old, wrinkled witch that she really is.");
                }
                System.out.println("'You're trying to bewitch me! How dare you?");
                in.nextLine();
                System.out.println("Startled, with a flick of her arm, she summons a gust of wind and pushes you off the carriage.");
                System.out.println("Ready? Fight!");
                witch.showDetails();
                win = fight(witch);
                in.nextLine();
                if (!win) {
                    break;
                }
                System.out.println("You defeat the Witch! Looking at her unmoving body on the ground, you're unsure if she's still alive. \nBut you don't risk checking, should you fall into her trance in your weakened state after the battle..");
                in.nextLine();
                wonTheBattle();
                System.out.println("As you step away, you notice something that has fallen from the carriage during the fight...");
                System.out.println("You pick it up, it's a Potion!\n");
                player.addToPotions(miniHp);
                in.nextLine();
                player.showDetails();

                potion();
                maze(option, 20);
            }
            case 7 -> {
                System.out.println("Welcome to Temeria.");
                System.out.println("\nAs you arrive, the townfolk start to notice you. They already know what you are looking for.");
                in.nextLine();
                System.out.println("You need to look around and find someone to point you to the right direction.\n\n.\n.\n.\n\n");
                in.nextLine();

                System.out.println("Looks like someone is following you.\nYou run towards him and find out it is a man with a big moustache.");
                in.nextLine();
                System.out.println("This man tries to run but with no chance and you ask him why he was following you.");
                in.nextLine();
                System.out.println("'I'm sorry, I don't mean to bother you. \nI've heard that you are looking for the Goblet of fire, and maybe i can help you. I just need a favour in exchange. \nCould you help me? " + ConsoleColors.WHITE_BOLD_BRIGHT + "(Y/N)" + ConsoleColors.RESET);
                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("Y")) {
                    op = 8;
                } else if (answer.equals("N")) {
                    System.out.println("You apologize explaining that you cannot afford to distract from your quest.");
                    System.out.println("The man is distraught, but seems to understand, he advises you to look for a waterfall in the woods. He believes it could be a shortcut to the Balrog.");
                    in.nextLine();
                    if (player.getGold() >= 5) {
                        System.out.println("At this sudden generosity, you feel bad for the man, and give it some gold, hoping it helps him in his quest.");
                        player.takeFromGold(5);
                    } else {
                        System.out.println("At this sudden generosity, you feel bad that you're unable to help him.");
                        in.nextLine();
                    }
                    System.out.println("You leave town and go through the forest looking for the waterfall.");
                    in.nextLine();
                    op = 9;
                } else {
                    System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    in.nextLine();
                    op = 8;
                    in.nextLine();
                }
                maze(option, op);
            }
            case 8 -> {
                System.out.println("'Thank you! Quickly, come, there's no time to lose.' he says as he grabs your arm, and pulls you down a pipe.");
                in.nextLine();
                System.out.println("You find yourself in an underground sewer system. \nThe man with the moustache guides you through the tunnels as he steps on mushrooms growing in the floor.");
                in.nextLine();
                System.out.println("He explains his fiancee, 'the Princess' he calls her (so formal for a fiancee...), has been kidnapped... by a turtle with teeth.");
                in.nextLine();
                System.out.println("In exchange for your help, he promises to guide you through a shortcut towards Balrog and your quest for the Goblet of Fire.");
                in.nextLine();
                System.out.println("You reach a large room, in the center is a Giant Turtle with Teeth, watching you approach. Behind it is a girl, the Princess, tied up. 'Oh save me!' she speaks.");
                in.nextLine();
                System.out.println("The man with the moustache leaps forward but is trapped in a cage. It's up to you now!");
                in.nextLine();
                bowser.showDetails();
                win = fight(bowser);
                if (!win) {
                    break;
                }
                System.out.println("The Giant Turtle with Teeth was defeated and the Princess is Saved.\nShe leaps and kisses the man with the moustache in his nose.");

                in.nextLine();
                wonTheBattle();
                in.nextLine();
                player.showDetails();
                potion();

                System.out.println("'Thank you for your help. As promised, I'll send you to the right way to find the Devious Balrog! \nGo to the woods, there's a short cut. You will find a waterfall where he passed by not long ago.\nTake these coins, I have a lot of these, I hope they help you in your journey!' \n");
                player.addToGold(10);
                in.nextLine();
                System.out.println("You all climb out of the sewers back into the city through a staircase that opened just after you defeated the giant turtle.");
                in.nextLine();
                System.out.println("The man with the moustache and the Princess hop onto a weird dragon-like creature with big eyes, and they run away towards the horizon.");
                in.nextLine();
                System.out.println("You resume your journey back towards the forest, thinking of ways to spend this newfound gold. And right on queue, there's the salesman, it's like he knows you have coins to spend.");
                in.nextLine();
                maze(option, 20);
            }
            case 9 -> {
                System.out.println("There's the waterfall.");
                in.nextLine();
                System.out.println("You admire it's beauty, the force of the water pouring down... And suddenly someone else is admiring its beauty as well.");
                System.out.println("A majestic unicorn stands next to you.");
                in.nextLine();
                System.out.println("'Hello.' it says. Why it speaks, you don't know, but it does.");
                System.out.println("'Hello.' you reply, unsure of yourself.");
                in.nextLine();
                System.out.println("The unicorn is please at your good manners. His eyes shine towards you as his horns shines brightly, nearly blinding you!");
                in.nextLine();
                player.addToStrength(10);
                in.nextLine();
                System.out.println("When you can finally see again you feel stronger, but exhausted, and the unicorn is gone.");
                in.nextLine();
                System.out.println("You're left wondering what happened. But that's all you can do, wonder.");
                in.nextLine();
                System.out.println("You notice the sun has nearly set. Will you rest through the night " +ConsoleColors.WHITE_BOLD_BRIGHT + "(R)" + ConsoleColors.RESET+" or will you push on at the Balrog feeling it's close "+ConsoleColors.WHITE_BOLD_BRIGHT +"(C)" + ConsoleColors.RESET+"?.");

                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("C")) {
                    System.out.println("You're nearly there. The Balrog's lair is near, you can feel its stench.");
                    in.nextLine();
                    System.out.println("As you turn around a large rock you see it.");
                    in.nextLine();
                    op = 12;
                } else {
                    if (!answer.equals("R")) {
                        System.out.println("Since you don't know how to press the right letter, we will choose for you.");
                    }

                    op = 10;
                    in.nextLine();
                }
                maze(option, op);
            }
            case 10 -> {
                System.out.println("You decide to rest and continue tomorrow.\nYou build a fire, set yourself up with some leaves under your head, and shut your eyes.");
                in.nextLine();
                System.out.println("zzz");
                in.nextLine();
                System.out.println("zzz");
                in.nextLine();
                System.out.println("more zzz");
                in.nextLine();
                System.out.println("A rustle in the leaves nearby startle you. A monstrous ghoul is upon you!");
                System.out.println("It's so quick, you barely have time to escape its jaws. Ready yourself, half-asleep or not, you must defeat it.");
                in.nextLine();
                alghoul.showDetails();
                win = fight(alghoul);
                if (!win) {
                    break;
                }
                System.out.println("You kill the ghoul.\n");
                in.nextLine();
                wonTheBattle();
                in.nextLine();
                player.showDetails();
                potion();

                System.out.println("As you gather your things after the whole ordeal, you are once again startled by a voice.");
                in.nextLine();
                maze(option, 20);
            }
            case 11 -> {
                System.out.println("Suspicious of the salesman always appearing at the most opportune times, you resume your journey, feeling Balrog closer and closer.");
                in.nextLine();
                System.out.println("Turning a corner in a rock, you could not be more right, there it is, it's lair.");
                System.out.println("But you realize, the entrance you're facing is not guarded. It seems forgotten.");
                in.nextLine();
                System.out.println("Fortune favors you! You notice a vial of a strange elixir just lying in your path.\nDo you drink it " +ConsoleColors.WHITE_BOLD_BRIGHT +"(D)" + ConsoleColors.RESET+" or leave it on the ground "+ConsoleColors.WHITE_BOLD_BRIGHT +"(L)"+ConsoleColors.RESET+"?");

                answer = in.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("L")) {
                    System.out.println("Wrong, you drink it, otherwise why even mention it?");
                } else {
                    if (!answer.equals("D")) {
                        System.out.println("Since you don't know how to press the right letter, unlucky for you we are unforgiving gods. You died.\nSo close to the end too...\n");
                        break;
                    }
                }

                System.out.println("A strange, pleasant feeling overcomes you. Suddenly you feel like you can survive anything.");
                player.addToHp(30);
                in.nextLine();
                maze(option, 12);
            }
            case 12 -> {
                System.out.println("There it is. The main obstacle to fulfilling your quest. The dreaded Balrog.");
                in.nextLine();
                System.out.println("'I know why you are here. Fool! It was all for nothing.' it says.");
                in.nextLine();
                System.out.println("You didn't know it could speak, such a foul creature. But after this whole adventure, you're surprised at nothing.\nThe focus in on the Goblet behind it. Keep that focus and you shall succeed.");
                in.nextLine();
                System.out.println("It growls heavily, it's ready. Are you?");
                in.nextLine();
                balrog.showDetails();
                win = fight(balrog);
                if (!win) {
                    break;
                }
                System.out.println("Balrog was defeated.\n");

                in.nextLine();
                wonTheBattle();

                in.nextLine();
                System.out.println("The Goblet of Fire is yours at last! You appreciate it, having fulfilled your quest (the thought of being 2000 gold coins richer also helps).");
                System.out.println("Happiness will come back to your hometown, thanks to you! Congratulations!");
                in.nextLine();

            }
            default -> {
                System.out.println("\nSalesman: 'Hello again!'\n");
                seller.selling(player);
                maze(0, room + 1);
            }
        }
        return win;

    }
}

