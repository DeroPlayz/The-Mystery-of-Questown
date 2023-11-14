package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import src.Entities.Player;
//Yeah ChatGPT wrote this.

public class SaveSystem implements Serializable {
    static String save = "Save";

    public static void saveGame(){
        Player saveData = Main.player;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(save))) {
            //out.writeObject(saveData);
            out.writeObject(saveData.Name());
            out.writeObject(saveData.Subject());
            out.writeObject(saveData.Object());
            out.writeObject(saveData.Strength());
            out.writeObject(saveData.Intelligence());
            out.writeObject(saveData.Charisma());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadGame() {
        Player saveData = new Player();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(save))) {
            saveData.Name = (String) in.readObject();
            saveData.Subject = (String) in.readObject();
            saveData.Object = (String) in.readObject();
            saveData.Strength = (int) in.readObject();
            saveData.Intelligence = (int) in.readObject();
            saveData.Charisma = (int) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            saveData = new Player(MafLib.askString("Error. Corrupted save. Initializing new save.\nWhat is this young adventurer's name? ", false), MafLib.askString("What is this young adventurer's subjective pronoun? (The \"he\" in he/him) ", false), MafLib.askString("What is this young adventurer's objective pronoun? (The \"him\" in he/him) ", false));
        }
        return saveData;
    }
}