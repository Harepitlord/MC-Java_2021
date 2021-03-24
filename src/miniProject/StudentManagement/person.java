package miniProject.StudentManagement;

public class person {
    private String name;
    private int age;
    private int birthYear;

    public person(String n,int a, int year) {
        name = n;
        age = a;
        birthYear = year;
    }

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
        return "name= " + name +", age=" + age +", birthYear=" + birthYear;
    }
}
