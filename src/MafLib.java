package src;

import java.util.Scanner;

public class MafLib {
    static Scanner Scan = new Scanner(System.in);
    
    public static String askString(String Prompt, Boolean EndOnNewline){
        if(EndOnNewline == true){
            System.out.println(Prompt);
        }
        if(EndOnNewline == false){
            System.out.print(Prompt);
        } 
        String response = Scan.nextLine();
        return response;
    }

    public static int askInt(String Prompt, Boolean EndOnNewline){
        String nl = "";
        if(EndOnNewline == true){
            nl = "\n";
        }
        System.out.print(Prompt + nl);
        String response = Scan.next();
        response = response.replaceAll("[^0-9.]", "");
        int dot = response.indexOf(".");
        if(dot == -1){
            response = response.replaceAll("[^0-9]", "");
        }
        else{
            response = response.substring(0, dot);
        }
        return Integer.valueOf(response);
        
    }

    public static double askDouble(String Prompt, Boolean EndOnNewline){
        String nl = "";
        if(EndOnNewline == true){
            nl = "\n";
        }
        System.out.print(Prompt + nl);
        String response = Scan.next();
        response = response.replaceAll("[^0-9]", "");
        if(response.contains(".") == false){
            return Double.valueOf(response + ".0");
        }
        else{
            return Integer.valueOf(response);
        }
        
    }

    public static boolean isAlpha(String s){
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            int j = i + 1;
            String t;
            if(i + 1 >= s.length()){
                t = s.substring(i);
            }
            else{
                t = s.substring(i, j);
            }
            if("abcdefghijklmnopqrstuvwxyz".contains(t) == false){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNumeric(String s){
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if("1234567890.".contains(asString(s.charAt(i))) == false){
                return false;
            }
        }
        return true;
    }
     
    public static String asString(char c){
        return String.valueOf(c);
    }

    // /**
    //  * 
    //  * @param number What number to round.
    //  * @param roundpoint How many decimal spaces to round it.
    //  * @return Returns a number rounded to the point specified.
    // **/
    // public static double roundDec(double number, int roundpoint){
    //     String s = String.valueOf(number);
    //     int point = s.indexOf(".");
    //     if(s.length() >= roundpoint){
    //         System.out.println("Error");
    //         return 0.0;
    //     }
        


    //     s = s.substring(0, point + roundpoint);
    //     return Double.valueOf(s);
    // }

}