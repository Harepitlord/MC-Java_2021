// A basic program that takes student details as input and prints in formatted output


package level1;
// Imports

import java.util.Scanner;

public class Ex1 {

    // Variable declaration

    private String Name;
    private String RegNo;
    private String Dept;
    private Integer YrOfStudy;

    // Constructors

    public Ex1(String Name, String RegNo, String Dept, Integer YrOfStudy) {
        this.Name = Name;
        this.RegNo = RegNo;
        this.Dept = Dept;
        this.YrOfStudy = YrOfStudy;
    }

    public Ex1() {
        this.getData();
    }

    // Methods

    private void getData() {

        // Read data from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.Name = sc.nextLine();
        System.out.println("Enter your Roll no. : ");
        this.RegNo = sc.nextLine();
        System.out.println("Enter your Department: ");
        this.Dept = sc.nextLine();
        System.out.println("Enter Your Year of Study: ");
        this.YrOfStudy = sc.nextInt();

    }

    public void printData() {

        // Print data to user
        System.out.println("Name: " + this.Name);
        System.out.println("Register No. : " + this.RegNo);
        System.out.println("Department: " + this.Dept);
        System.out.println("Year of Study: " + this.YrOfStudy + " year.");
    }

    // Main function

    public static void main(String[] args) {
        Ex1 e = new Ex1();
        e.printData();
    }
}
