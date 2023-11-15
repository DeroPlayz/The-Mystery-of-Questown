package src;

import static src.SaveSystem.loadGame;
import static src.SaveSystem.saveGame;
import java.nio.file.Files;
import java.nio.file.Paths;

import src.Entities.Player;

public class Main {
    public static int Day = 0;
    public static Player player;
    static String answer;
    private static void selectSave(){
        if(Files.exists(Paths.get(SaveSystem.save))){
            answer = MafLib.askString("Would you like to load your save (l), or start a new one (n)?", true).toLowerCase();
            if(!answer.equals("l") == !answer.equals("n")){
                selectSave();    
            }
            else if(answer.equals("l")){
                player = loadGame();
            }
            else if(answer.equals("n")){
                player = new Player(MafLib.askString("What is this young adventurer's name? ", false), MafLib.askString("What is this young adventurer's subjective pronoun? (The \"he\" in he/him) ", false), MafLib.askString("What is this young adventurer's objective pronoun? (The \"him\" in he/him) ", false));
            }
        }
        else{
            player = new Player(MafLib.askString("What is this young adventurer's name? ", false), MafLib.askString("What is this young adventurer's subjective pronoun? (The \"he\" in he/him) ", false), MafLib.askString("What is this young adventurer's objective pronoun? (The \"him\" in he/him) ", false));
        }
    }
    public static void main(String[] args) {
        selectSave();
        System.out.println(player);
        saveGame();
        player.apply();
        Day += 1;
        saveGame();
    }
}