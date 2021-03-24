package level3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class lvl3_1 {

    private final Pattern p = Pattern.compile("^[a-zA-Z]*$");

    public void splitString(String s,String delimit) {
        System.out.println(Arrays.toString(s.split(delimit)));
    }

    public void checkDigits(String s) {
        boolean onlyDigits = !(s != null && p.matcher(s).find());
        System.out.println("Digits presence only : "+ onlyDigits);
    }

    public void swapString(String s,String b) {
        System.out.println("String 1: "+s+"\tString 2: "+b);
        s = s + b;
        b = s.substring(0,s.length()-b.length());
        s = s.substring(b.length());
        System.out.println("String 1: "+s+"\tString 2: "+b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lvl3_1 l = new lvl3_1();
        String a,b;
        int choice;
        while(true) {
            System.out.println("""
                    Enter Choice:
                     1.Split String\s
                     2.Check whether given string has only digits\s
                     3.Swap two Strings\s
                     4.Exit""");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the string and delimiter: ");

                    a = sc.nextLine();
                    b = sc.nextLine();
                    l.splitString(a,b);
                }
                case 2 -> {
                    System.out.println("Enter the String: ");
                    a = sc.nextLine();
                    l.checkDigits(a);
                }
                case 3 -> {
                    System.out.println("Enter two Strings: ");
                    a = sc.nextLine();
                    b = sc.nextLine();
                    l.swapString(a,b);
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid Choice: ");
            }
        }
    }
}
