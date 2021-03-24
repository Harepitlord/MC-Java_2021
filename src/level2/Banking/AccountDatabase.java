package level2.Banking;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class AccountDatabase {

    // Class members
    private static HashMap<String,Account> data;

    // Initialize the database with a csv
    public static void initialize() {
        if (data == null) {
            data = new HashMap<>();
            loadAccounts(new FileResource("src/level2/Banking/accounts.csv"));

        }
    }

    public static void initialize(FileResource fr) {
        if (data == null) {
            data = new HashMap<>();
            loadAccounts(fr);
        }
    }

    // Loading accounts from arraylist into the database
    private static void loadAccounts(FileResource fr) {

        ArrayList<Account> acc = loadAccount(fr);
        for( Account a : acc) {
            data.put(a.getName(),a);
        }
        System.out.println(data.size());
        data = sortByValues(data);
    }

    // Loading accounts from csv into arraylist
    private static ArrayList<Account> loadAccount(FileResource fr) {
        CSVParser parser = fr.getCSVParser();
        ArrayList<Account> accounts = new ArrayList<>();
        for(CSVRecord record : parser) {
            int accNo = Integer.parseInt(record.get("accNo"));
            String name = StringUtils.capitalize(record.get("Name"));
            double amt = Double.parseDouble(record.get("amount"));
            accounts.add(new Account(accNo,name,amt));
        }
        return accounts;
    }

    public static int getAccNo(String n){
        initialize();
        return data.get(n).getAccNo();
    }

    public static double getAmount(String n) {
        initialize();
        return data.get(n).getAmount();
    }

    // Account functions

    public static boolean deposit(String n,double amt) {
        if (data.containsKey(n))
            data.get(n).deposit(amt);
        else
            return false;
        return true;
    }

    public static int withdraw(String n, double amt) {
        if (data.containsKey(n))
            if (data.get(n).withdraw(amt))
                return 1;
            else
                return 0;
        else
            return -1;
    }

    public static String getAccount(String n) {
        if (data.containsKey(n))
            return data.get(n).toString();
        return "";
    }

    public static void toStrings() {
//        data.forEach((key,val)-> System.out.println(val.toString()));
//        for (String s : data.keySet())
//            System.out.println(data.get(s).toString());
        data.forEach((key, value) -> System.out.println(value.toString()));
    }

    private static HashMap<String,Account> sortByValues(HashMap<String,Account> map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}

