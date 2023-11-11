package src.Entities;

import java.io.Serializable;

import src.MafLib;

public class Player extends Entity implements Serializable{
    int StatPoints = 3;
    public String Subject = "they";
    public String Object = "them";

    public Player(){
        Name = "Dummy";
        Subject = "they";
        Object = "them";
        Strength = Intelligence = Charisma = StatPoints = 0;
    }
    public Player(String Name, String Subject, String Object){
        super.Name = Name;
        this.Subject = Subject;
        this.Object = Object;
        Strength = 1;
        Intelligence = 1;
        Charisma = 1;
        System.out.println("Name: " + super.Name);
        System.out.println("Strength: " + Strength);
        System.out.println("Intelligence: " + Intelligence);
        System.out.println("Charisma: " + Charisma);
        int add = 0;
        add = MafLib.askInt("Remaining Points: " + StatPoints + "\nHow many of your stat points would you like to spend on Strength?", true);
        if(add > StatPoints){
            add = StatPoints;
        }
        Strength += add;
        StatPoints -= add;
        
        if(StatPoints > 0){
            add = MafLib.askInt("Remaining Points: " + StatPoints + "\nHow many of your stat points would you like to spend on Intelligence?", true);
            if(add > StatPoints){
                add = StatPoints;
            }
            Intelligence += add;
            StatPoints -= add;
        
            if(StatPoints > 0){
                add = MafLib.askInt("Remaining Points: " + StatPoints + "\nHow many of your stat points would you like to spend on Charisma?", true);
                if(add > StatPoints){
                    add = StatPoints;
                }
                Charisma += add;
                StatPoints -= add;
            }
        }
    }

    public String Name(){
        return Name;
    }

    public int Strength(){
        return Strength;
    }

    public int Intelligence(){
        return Intelligence;
    }

    public int Charisma(){
        return Charisma;
    }

    public String Subject(){
        return Subject;
    }

    public String Object(){
        return Object;
    }
    @Override
    public String toString(){
        String s = ("Name:" + Name + "\nStrength: " + Strength + " | Intelligence: " + Intelligence + " | Charisma: " + Charisma + "\n");
        return s;
    }
}
