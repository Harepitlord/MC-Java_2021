// This java class account is used to store the bank customer details namely
// account number, name, and account balance


package level2.Banking;

public class Account implements Comparable<Account> {

    //The class data members
    private final int accNo;
    private final String name;
    private double amount;

    // getter function for the private variables
    public int getAccNo() {
        return this.accNo;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    // to deposit amount in a given account
    public void deposit(double amt) {
        this.amount += amt;
    }

    // to withdraw amount for a given account
    public boolean withdraw(double amt) {
        if (this.amount < amt)
            return false;
        else {
            this.amount -= amt;
            return true;
        }
    }

    // constructor
    public Account(int id, String n, Double a) {
        this.accNo = id;
        this.name = n;
        this.amount = a;
    }

    public String toString() {
        return "{ accNo=" + accNo + ", name='" + name + '\'' + ", amount=" + amount + '}';
    }

    public int compareTo(Account other) {
        if (accNo < other.accNo) return -1;
        return 1;
    }
}
