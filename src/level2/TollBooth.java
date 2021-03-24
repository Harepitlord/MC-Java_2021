package level2;

import java.util.Scanner;

public class TollBooth {

    private int noBuses;
    private int noPaidBuses;
    private double amount;

    //constructor
    public TollBooth() {
        noBuses = 0;
        amount = 0;
        noPaidBuses = 0;
    }

    public void addPayToll(double toll) {
        noBuses++;
        amount += toll;
    }

    public void addNonPayToll() {
        noBuses++;
        noPaidBuses++;
    }

    public void displayAll() {
        System.out.println("Total no. of Buses: "+noBuses);
        System.out.println("Total no. of Paying Buses: "+noPaidBuses);
        System.out.println("Total no. of Non-Paying Buses: "+(noBuses - noPaidBuses));
        System.out.println("Total amount: "+amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amt;
        TollBooth tb = new TollBooth();
        while(true) {
            System.out.println("Enter the choice: 1.Paying Bus\t 2.Non-Paying Bus\t 3. Display\t 4.Exit");
                choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    amt = sc.nextDouble();
                    tb.addPayToll(amt);                }
                case 2 -> tb.addNonPayToll();
                case 3 -> tb.displayAll();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice ");
            }
        }
    }
}
