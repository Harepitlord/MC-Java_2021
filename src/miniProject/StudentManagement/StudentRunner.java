package miniProject.StudentManagement;

import java.util.Scanner;

// This class is to run the student management system
public class StudentRunner {

    public void runStudentManagement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the csv file: ");

        StudentDatabase data = new StudentDatabase();
        //FileResource fr = new FileResource();
        //StudentDatabase data = new StudentDatabase(fr);


        // Menu
        while (true) {
            System.out.print("Enter your choice: \n 1. Display All \t 2.Search by Register Number ");
            System.out.println("3. Add a student \t 4. Modify a student record \t 5. Delete a Student record \t 6. Exit ");
            int c = sc.nextInt();
            String n;
            n = sc.nextLine();
            switch(c) {
                case 1->data.toStrings();
                case 2->{
                    System.out.print("Enter the Register number of the student: ");
                    n = sc.nextLine();
                    System.out.println(data.getStudent(n));
                }
                case 3-> data.addStudent();
                case 4->data.modifyStudent();
                case 5->data.deleteStudent();
                case 6->System.exit(0);
                default -> System.out.println("!!..Invalid choice..!!");
            }

        }
    }
}
