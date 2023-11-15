package src.Entities;

import java.io.Serializable;

import src.MafLib;
import src.Professions.Job;

public class Player extends Entity implements Serializable{
    int StatPoints = 3;
    public String Subject = "they";
    public String Object = "them";
    public double Cash = 0.0;
    public Job Profession;

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
    public String toString(){
        String s = ("Name: " + Name + "\nStrength: " + Strength + " | Intelligence: " + Intelligence + " | Charisma: " + Charisma);
        return s;
    }
    public String getName(){
        return Name;
    }
    public int getStrength(){
        return Strength;
    }
    public int getIntelligence(){
        return Intelligence;
    }
    public int getCharisma(){
        return Charisma;
    }
    public String getSubject(){
        return Subject;
    }
    public String getObject(){
        return Object;
    }

    public void apply(){
        int resp = MafLib.askInt("What job would you like to apply for?\n1. Bank Security Guard\n2. Librarian\n3. Tech Salesperon\n4. Unemployed", true);
        System.out.println(resp == 1);         
        if(resp == 1){
            Profession = Job.BankSecurity;
        }
        else if(resp == 2){
            Profession = Job.Librarian;
        }
        else if(resp == 3){
            Profession = Job.Salesman;
        }
        else if(resp == 4){
            Profession = Job.Cashier;
        }
        
    }
}
