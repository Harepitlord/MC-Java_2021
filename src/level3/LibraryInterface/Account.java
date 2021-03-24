package level3.LibraryInterface;

public class Account {

    private final String Name;
    private int noBooksIssued;
    private int noBooksReserved;

    public String getName() {
        return Name;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getNoBooksReserved() {
        return noBooksReserved;
    }

    public Account(String n,int nobi,int nobr) {
        Name = n;
        noBooksIssued = nobi;
        noBooksReserved = nobr;
    }

    @Override
    public String toString() {
        return "Name=" + Name +
                ", noBooksIssued=" + noBooksIssued +
                ", noBooksReserved=" + noBooksReserved +
                '}';
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public void setNoBooksReserved(int noBooksReserved) {
        this.noBooksReserved = noBooksReserved;
    }

}
