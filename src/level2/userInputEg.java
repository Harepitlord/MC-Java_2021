// A program to take input from the user and pass it to the class members through the object

package level2;

import java.util.Scanner;

public class userInputEg {
    private String name;
    private String RegNo;

    public userInputEg(String name, String RegNo) {
        this.name = name;
        this.RegNo = RegNo;
    }

    public String toString() {
        String str = "Name: " + this.name + " \n RegNo: " + this.RegNo;
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Enter Name and RegNo : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String Reg = sc.nextLine();
        userInputEg uie = new userInputEg(name, Reg);
        System.out.println(uie.toString());
    }
}
