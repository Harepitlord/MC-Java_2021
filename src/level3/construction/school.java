
// This class school extends the building class and creates a structure for the school class

package level3.construction;

public class school extends building {
    private int noClass;
    private String grade;

    public school() {
        noClass = 0;
        grade = "";
    }

    public void setNoClass(int noClass) {
        this.noClass = noClass;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public int getNoClass() {
        return noClass;
    }

    @Override
    public String toString() {
        return "noClass=" + noClass + ", grade='" + grade + "'";
    }
}
