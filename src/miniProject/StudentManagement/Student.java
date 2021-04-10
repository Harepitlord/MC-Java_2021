package miniProject.StudentManagement;

// This student class has inherited the characteristics from the person class
// This class is used to hold the student's data in the database.

public class Student extends person {

    protected String regNo;
    protected String dept;
    protected int year;

    // Constructors

    public Student() {}

    public Student(String RegNo,String Name, int Age,String Dept, int Year,int BirthYear) {
        name = Name;
        age = Age;
        birthYear = BirthYear;
        regNo = RegNo;
        dept = Dept;
        year = Year;
    }

    // Getter functions
    public String getDept() {
        return dept;
    }

    public String getRegNo() {
        return regNo;
    }

    public int getYr() {
        return year;
    }

    // Setter functions
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBirthYear(int birthYear) {
        super.setBirthYear(birthYear);
    }

    // Custom toStrings function for the class
    public String toString(){
        return "name= " + name + ", age= " + age + ", birthYear= " + birthYear +
                ", RegNo= " + regNo + ", Dept= " + dept + ", Year= " + year;
    }

    // Custom compare function to sort the database
    public int compareTo(Student value) {
        return regNo.compareTo(value.regNo);
    }
}


