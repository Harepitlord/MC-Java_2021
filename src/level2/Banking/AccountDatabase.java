// This java class account database will serve as the mediocre database for this application
// thanks to the hashmap, this class holds all accounts in the bank
// Specific account can be retrieved by the account holder's name

package level2.Banking;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class AccountDatabase {

    // Class members
    private static HashMap<String, Account> data;

    // Initialize the database with a default csv (inside the package)
    public static void initialize() {
        if (data == null) {
            data = new HashMap<>();
            loadAccounts(new FileResource("src/level2/Banking/accounts.csv"));

        }
    }

    // Initialize the database with a custom csv file using the file selector dialog box
    public static void initialize(FileResource fr) {
        if (data == null) {
            data = new HashMap<>();
            loadAccounts(fr);
        }
    }

    // Loading accounts from arraylist into the database
    private static void loadAccounts(FileResource fr) {

        ArrayList<Account> acc = loadAccount(fr);
        for (Account a : acc) {
            data.put(a.getName(), a);
        }
        System.out.println(data.size());
        data = sortByValues(data);
    }

    // Loading accounts from csv into arraylist
    private static ArrayList<Account> loadAccount(FileResource fr) {
        CSVParser parser = fr.getCSVParser();
        ArrayList<Account> accounts = new ArrayList<>();
        for (CSVRecord record : parser) {
            int accNo = Integer.parseInt(record.get("accNo"));
            String name = StringUtils.capitalize(record.get("Name"));
            double amt = Double.parseDouble(record.get("amount"));
            accounts.add(new Account(accNo, name, amt));
        }
        return accounts;
    }

    // This function will print the number accounts that has been read and stored in the account database.
    public static int getAccNo(String n) {
        initialize();
        return data.get(n).getAccNo();
    }

    // Account functions

    // This function will return the amount in the given account.
    public static double getAmount(String n) {
        initialize();
        return data.get(n).getAmount();
    }

    // This function will return true if the deposit process is successful for the given account holder's name
    public static boolean deposit(String n, double amt) {
        if (data.containsKey(n))
            data.get(n).deposit(amt);
        else
            return false;
        return true;
    }

    // This function will return true if the withdraw process is successful for the given account holder's name
    public static int withdraw(String n, double amt) {
        if (data.containsKey(n))
            if (data.get(n).withdraw(amt))
                return 1;
            else
                return 0;
        else
            return -1;
    }

    // This function will return the account details if present or else a empty string is returned
    public static String getAccount(String n) {
        if (data.containsKey(n))
            return data.get(n).toString();
        return "";
    }

    // This function will print all the details of all accounts
    public static void toStrings() {
        data.forEach((key, value) -> System.out.println(value.toString()));
    }

    // This function is to sort the database according to the account number
    private static HashMap<String, Account> sortByValues(HashMap<String, Account> map) {
        List<Map.Entry<String, Account>> list = new LinkedList<>(map.entrySet());

        list.sort((Comparator) (o1, o2) -> ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue()));
        HashMap<String, Account> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Account> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}

