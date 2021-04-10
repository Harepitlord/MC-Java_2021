
// This class is to create a data structure for the building class

package level3.construction;

public class building {
    private double sqFt;
    private int noFloor;
    private boolean apartment;

    // Constructor
    public building() {
        sqFt = 0.0;
        noFloor = 0;
        apartment = false;
    }

    // Setter functions
    public void setApartment(boolean apartment) {
        this.apartment = apartment;
    }

    public void setNoFloor(int noFloor) {
        this.noFloor = noFloor;
    }

    public void setSqFt(double sqFt) {
        this.sqFt = sqFt;
    }

    // Getter functions
    public boolean isApartment() {
        return apartment;
    }

    public double getSqFt() {
        return sqFt;
    }

    public int getNoFloor() {
        return noFloor;
    }

    @Override
    public String toString() {
        String apart;
        if (apartment)
            apart = "Yes";
        else
            apart = "No";
        return "sqFt=" + sqFt + ", noFloor=" + noFloor + ", apartment=" + apart;
    }
}
