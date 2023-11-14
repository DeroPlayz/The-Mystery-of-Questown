package src.Professions;

public class Job {
    public String Name;
    public int StrengthReq;
    public int IntelligenceReq;
    public int CharismaReq;
    public double Salary;

    public Job(String Name, int StrengthReq, int IntelligenceReq, int CharismaReq){
        this.Name = Name;
        this.StrengthReq = StrengthReq;
        this.IntelligenceReq = IntelligenceReq;
        this.CharismaReq = CharismaReq;
    }

    public String Name(){
        return Name;
    }
    public int StrengthReq(){
        return StrengthReq;
    }
    public int IntelligenceReq(){
        return IntelligenceReq;
    }
    public int CharismaReq(){
        return CharismaReq;
    }

    public static Job Unemployed = new Job("Unemployed", 0, 0, 0);
    public static Job BankSecurity = new Job("Bank Security Guard", 3, 0, 0);
    public static Job Librarian = new Job("Unemployed", 0, 3, 0);
    public static Job Salesman = new Job("Tech Salesperson", 0, 2, 2);
}