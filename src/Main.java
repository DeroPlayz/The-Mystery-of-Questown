package src;

import static src.SaveSystem.loadGame;
import static src.SaveSystem.saveGame;

import java.nio.file.Files;
import java.nio.file.Paths;

import src.Entities.Player;

public class Main {
    public static Player player;
    public static void main(String[] args) {
        if(Files.exists(Paths.get(SaveSystem.save))){
                player = loadGame();
            }
        else{
            player = new Player(MafLib.askString("What is this young adventurer's name? ", false), MafLib.askString("What is this young adventurer's subjective pronoun? (The \"he\" in he/him) ", false), MafLib.askString("What is this young adventurer's objective pronoun? (The \"him\" in he/him) ", false));
        }
        System.out.println(player);
        saveGame();
    }
}