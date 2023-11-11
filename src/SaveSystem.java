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
            e.printStackTrace();
        }
        return saveData;
    }
}