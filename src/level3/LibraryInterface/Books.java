package level3.LibraryInterface;


public class Books {
    private final String BookName;
    private boolean Issued;
    private boolean reserved;
    private String reserveName;

    public Books(String BkName, boolean issued, boolean reserve, String RName) {
        BookName = BkName;
        Issued = issued;
        reserved = reserve;
        reserveName = RName;
    }

    public String getBookName() {
        return BookName;
    }

    public String getReserveName() {
        return reserveName;
    }

    public boolean isIssued() {
        return Issued;
    }

    public boolean isReserved() {
        return reserved;
    }

    @Override
    public String toString() {
        return "BookName= " + BookName;
    }


    public void setIssued() {
        Issued = !Issued;
    }

    public void setReserveName(String reserveName) {
        this.reserved = true;
        this.reserveName = reserveName;
    }

    public boolean available() {
        if (this.isIssued()) {
            System.out.println("The book " + this.BookName + " has been issued.");
            return false;
        } else if (this.isReserved()) {
            System.out.println("The book " + this.BookName + " has been reserved.");
            return false;
        }
        System.out.println("The book " + this.BookName + " is available.");
        return true;
    }
}
