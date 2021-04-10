package miniProject.StudentManagement;

// To select and open a file using a select dialog box
import edu.duke.FileResource;

// To read the CSV records from the CSV file and store it in the database
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

// To use the HashMap and Scanner utilities
import java.util.*;

// This class serves as the database for the student management system and has required functions
public class StudentDatabase {
    protected HashMap<String , Student> database;
    private final Scanner sc;

    // Constructors
    public StudentDatabase() {
        this.database = new HashMap<>();
        sc = new Scanner(System.in);
        this.initialize();
    }

    public StudentDatabase(FileResource fr) {
        this.database = new HashMap<>();
        sc = new Scanner(System.in);
        this.initialize(fr);
    }

    // Function to load the CSV and initiate the CSV to database transfer using default CSV file
    public void initialize() {
        if (this.database == null) {
            this.database = new HashMap<>();
            loadAccounts(new FileResource("src/miniProject/StudentManagement/students.csv"));

        }
    }

    // Function to load the CSV and initiate the CSV to database transfer using user's CSV file
    public void initialize(FileResource fr) {
        if (this.database == null) {
            this.database = new HashMap<>();
            loadAccounts(fr);
        }
    }

    // This function loads the student record data from the arraylist and stores into database
    private void loadAccounts(FileResource fr) {
        ArrayList<Student> arr = loadAccount(fr);
        for (Student s: arr) {
            this.database.put(s.getRegNo(),s);
        }
        System.out.println("size: "+this.database.size());
        this.sortDatabase();

    }

    // This function reads the CSV file line by line and gets the data as student class object and stores it in the arraylist
    private ArrayList<Student> loadAccount(FileResource fr) {
        CSVParser parser = fr.getCSVParser();
        ArrayList<Student> arr = new ArrayList<>();
        for (CSVRecord record:  parser) {
            String regno = record.get("RegNo");
            String name = record.get("Name");
            int age = Integer.parseInt(record.get("Age"));
            String dept = record.get("Dept");
            int year = Integer.parseInt(record.get("Year"));
            int dob = Integer.parseInt(record.get("DOB"));
            arr.add(new Student(regno,name,age,dept,year,dob));
        }
        return arr;
    }

    // This function adds a student to the database and sorts the database
    public void addStudent() {
        System.out.println("Enter the register number: ");
        String regno = sc.nextLine();
        System.out.println("Enter the Student's Name: ");
        String name = sc.nextLine();
        System.out.println("Enter the Student's Age: ");
        int age = sc.nextInt();
        System.out.println("Enter the Student's Dept: ");
        String dept = sc.nextLine();
        System.out.println("Enter the Student's studying year: ");
        int yr = sc.nextInt();
        System.out.println("Enter the Student's birth year: ");
        int dob = sc.nextInt();
        this.database.put(regno,new Student(regno,name,age,dept,yr,dob));
        this.sortDatabase();
        System.out.println("The new student has been added to the database.");
    }

    // This function calls the sorting function
    private void sortDatabase() {
        this.database = sortByValues(this.database);
    }

    // This function is to prompt the user to continue the modification or deletion of a student record
    private boolean userContinue() {
        System.out.print("Do you want to continue: (Y/y - to continue) ");
        String choice = sc.nextLine();
        return choice.equals("Y") || choice.equals("y");
    }

    // This function enables us to modify the specific student record
    public void modifyStudent() {
        System.out.println("Enter the Student's Name that needs change: ");
        String name =  sc.nextLine();
        System.out.println(this.database.get(name).toString());
        System.out.println("Which field your gonna change: ");
        System.out.println("1.Register Number \t2.Name \t3.Age\t4.Dept\t5.Year of study\t6.Birth Year");
        switch(sc.nextInt()) {
            case 1 -> {
                if (userContinue()) {
                    System.out.println("Enter the Student's new Register number: ");
                    this.database.get(name).setRegNo(sc.nextLine());
                }
            }
            case 2 -> {
                if (userContinue()) {
                    System.out.print("Enter the Student's new Name: ");
                    String newName = sc.nextLine();
                    Student s = this.database.get(name);
                    this.database.remove(name);
                    s.setName(newName);
                    this.database.put(newName,s);
                }
            }
            case 3 -> {
                if (userContinue()) {
                    System.out.print("Enter the Student's new Age: ");
                    this.database.get(name).setAge(sc.nextInt());
                }
            }
            case 4 -> {
                if (userContinue()) {
                    System.out.print("Enter the Student's new Department: ");
                    this.database.get(name).setDept(sc.nextLine());
                }
            }
            case 5 -> {
                if (userContinue()) {
                    System.out.print("Enter the Student's new Year of Study: ");
                    this.database.get(name).setYear(sc.nextInt());
                }
            }
            case 6 -> {
                if (userContinue()) {
                    System.out.print("Enter the Student's new Birth Year: ");
                    this.database.get(name).setBirthYear(sc.nextInt());
                }
            }
        }
        this.sortDatabase();
    }

    // This function enables us to delete a specific student record
    public void deleteStudent() {
        System.out.println("Enter the Student's Name that needs change: ");
        String name =  sc.nextLine();
        System.out.println(this.database.get(name).toString());
        System.out.println("The Student record will be deleted.");
        if (userContinue()) {
            this.database.remove(name);
            this.sortDatabase();
        }
    }

    // This function will sort the student database on the basis of the register number
    private static HashMap<String, Student> sortByValues(HashMap<String, Student> map) {
        List<Map.Entry<String, Student>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> ((o1.getValue()).compareTo(o2.getValue())));
        HashMap<String, Student> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    // This function will fetch the specific student's record from database
    public String getStudent(String reg) {
        if (this.database.containsKey(reg))
            return this.database.get(reg).toString();
        return "No such student in the database.";
    }

    public void toStrings() {
        this.database.forEach((key, value) -> System.out.println(value.toString()));
    }

}
