package miniProject.StudentManagement;

// Base class for the student and teachers
// but as of now only student management system is needed so only student class has been created and inherited

public class person {
    protected String name;
    protected int age;
    protected int birthYear;

    // Constructors
    public person(){}

    public person(String n, int a, int year) {
        name = n;
        age = a;
        birthYear = year;
    }

    // Getter functions

    public int getAge() {
        return age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name= " + name + ", age=" + age + ", birthYear=" + birthYear;
    }
}
