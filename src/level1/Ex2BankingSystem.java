package level1;

import java.util.Scanner;

public class Ex2BankingSystem {
    private String accNo;
    private String name;
    private String branch;
    private double balance;

    public Ex2BankingSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number: ");
        this.accNo = sc.nextLine();
        System.out.println("Enter Your Name: ");
        this.name = sc.nextLine();
        System.out.println("Enter Your bank balance: ");
        this.balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter your Branch Name: ");
        this.branch = sc.nextLine();
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount your gonna deposit: ");
        double bal = sc.nextDouble();
        this.balance += bal;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you wanna withdraw: ");
        double bal = sc.nextDouble();
        this.balance -= bal;
    }

    public void changeBranch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your new branch: ");
        this.branch = sc.nextLine();
    }

    public String toString() {
        String str = "Account no: " + this.accNo + " \n Name: " + this.name + " \n Balance: " + this.balance + " \n Branch: " + this.branch;
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creation of Account: ");
        Ex2BankingSystem ebs = new Ex2BankingSystem();
        while (true) {
            System.out.println("Enter Choice: \n 1. Deposit \n 2. Withdraw \n 3. changeBranch \n 4. Account Status \n 5. Exit");
            int s = sc.nextInt();
            switch (s) {
                case 1:
                    ebs.deposit();
                    break;
                case 2:
                    ebs.withdraw();
                    break;
                case 3:
                    ebs.changeBranch();
                    break;
                case 4:
                    System.out.println(ebs.toString());
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice ");
            }
        }
    }
}
