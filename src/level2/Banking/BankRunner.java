// This java class is the runner class for the bank management system
// It will initialize the account database and has a menu to operate the management system

package level2.Banking;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;


public class BankRunner {

    // This is the runner funtion of the bank management system
    public void runBank() {

        //Scanner class to read inputs from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the csv file: ");

        AccountDatabase.initialize();
        //FileResource fr = new FileResource();
        //AccountDatabase.initialize(fr);

        // the menu
        while (true) {
            System.out.println("Enter your choice: \n 1. Display All \n 2.Search by account");
            System.out.println("3. Deposit \n 4. Withdraw \n 5. Exit ");
            int c = sc.nextInt();
            String n;
            n = sc.nextLine();
            double amt;
            switch (c) {
                case 1 -> {
                    // Display all accounts in the database
                    AccountDatabase.toStrings();
                }
                case 2 -> {
                    // Search for a account with given name
                    System.out.println("Enter the Account holder name: ");
                    n = sc.nextLine();
                    System.out.println(AccountDatabase.getAccount(StringUtils.capitalize(n)));
                }
                case 3 -> {
                    // Deposit amount in the account for the given name
                    System.out.println("Enter the Account holder name: ");
                    n = sc.nextLine();
                    System.out.println("Enter the amount to be deposited: ");
                    amt = sc.nextDouble();
                    if (AccountDatabase.deposit(n, amt))
                        System.out.println("Deposit successful");
                    else
                        System.out.println("Deposit unsuccessful, No such account holder");
                }
                case 4 -> {
                    // Withdraw amount from the account for the given name
                    System.out.println("Enter the Account holder name: ");
                    n = sc.nextLine();
                    System.out.println("Enter the amount to be withdrawn: ");
                    amt = sc.nextDouble();
                    switch (AccountDatabase.withdraw(n, amt)) {
                        case 1 -> System.out.println("Withdraw Successful \n Balance: " + AccountDatabase.getAmount(n));
                        case 0 -> System.out.println("Withdraw unsuccessful \n Insufficient money Balance: " + AccountDatabase.getAccount(n));
                        case -1 -> System.out.println("Withdraw unsuccessful \n No such account holder");
                    }
                }
                // Exit the run of the program or terminate the program run
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        BankRunner br = new BankRunner();
        br.runBank();
    }
}
