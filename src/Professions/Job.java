package src.Professions;

public class Job {
    public String Name;
s
    public Job(String Name){
        this.Name = Name;
    }

    public String getName(){
        return Name;
    }
    
    public String toString(){
        return Name;
    }

    public static Job BankSecurity = new Job("Bank Security Guard");
    public static Job Librarian = new Job("Librarian");
    public static Job Salesman = new Job("Tech Salesperson");
    public static Job Cashier = new Job("Fast Food Clerk");
}