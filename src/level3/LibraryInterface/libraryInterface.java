package level3.LibraryInterface;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.HashMap;
import java.util.Scanner;

public class libraryInterface implements library {

    private HashMap<String, Books> bookData;
    private HashMap<String, Account> accountData;
    Scanner sc;

    public libraryInterface(String file1, String file2) {
        bookData = new HashMap<>();
        accountData = new HashMap<>();
        getBookData(file1);
        getBookData(file2);
        sc = new Scanner(System.in);
    }

    private void getBookData(String f1) {
        if (bookData == null) {
            FileResource fr = new FileResource(f1);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord r: parser) {
                String n = r.get("Name");
                boolean nobi = Integer.parseInt(r.get("Issued"))==1;
                boolean nobr = Integer.parseInt(r.get("Reserved"))==1;
                String rn = r.get("ReserveName");
                bookData.put(n,new Books(n,nobi,nobr,rn));
            }
        }
    }

    private void getAccountData(String f2) {
        if (accountData == null) {
            FileResource fr = new FileResource(f2);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord r : parser) {
                String n = r.get("Name");
                int nobi = Integer.parseInt(r.get("noBookIssued"));
                int nobr = Integer.parseInt(r.get("noBookReserved"));
                accountData.put(n, new Account(n, nobi, nobr));
            }
        }
    }

    private boolean containsBook(String n) {
        return bookData.containsKey(n);
    }

    private boolean containsAccount(String n) {
        return accountData.containsKey(n);
    }


    @Override
    public void drawBook() {
        System.out.println("Enter the book name: ");
        String n = sc.nextLine();
        if (containsBook(n)) {
            if (bookData.get(n).available()) {
                bookData.get(n).setIssued();
                System.out.println("The book "+n+" is available and issued");
            }
        }
    }

    @Override
    public void checkStatus() {
        System.out.println("Enter the book name: ");
        String n = sc.nextLine();
        if (containsBook(n)) {
            bookData.get(n).available();
        }
    }

    @Override
    public void reserveBook() {
        System.out.println("Enter the book name: ");
        String n = sc.nextLine();
        if (containsBook(n)) {
            if(bookData.get(n).available()){
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                bookData.get(n).setReserveName(name);
            }
        }
    }

    @Override
    public void returnBook() {

    }

    @Override
    public void displayAll() {

    }
}
