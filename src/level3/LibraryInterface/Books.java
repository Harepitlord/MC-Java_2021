package level3.LibraryInterface;


import java.time.LocalDate;

public class Books {
    private final String BookName;
    private boolean Issued;
    private boolean reserved;
    private String reserveName;
    private LocalDate reDate;

    public Books(String BkName, boolean issued, boolean reserve, String RName,LocalDate lo) {
        this.BookName = BkName;
        this.Issued = issued;
        this.reserved = reserve;
        this.reserveName = RName;
        this.reDate = lo;
    }

    public String getBookName() {
        return this.BookName;
    }

    public String getReserveName() {
        return this.reserveName;
    }

    public boolean isIssued() {
        return this.Issued;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    @Override
    public String toString() {
        return "BookName= " + BookName;
    }

    public void setIssued() {
        this.reDate = LocalDate.now().plusDays(15);
        Issued = !Issued;
    }

    public void setReserveName(String reserveName) {
        this.reserved = true;
        this.reserveName = reserveName;
        this.reDate = LocalDate.now().plusDays(15);
    }

    public boolean available() {
        if (this.isIssued()) {
            System.out.println("The book " + this.BookName + " has been issued.");
            System.out.println("The return date might be "+this.reDate.toString());
            return false;
        } else if (this.isReserved()) {
            System.out.print("The book " + this.BookName + " has been reserved. ");
            System.out.println("The Reservation expires on "+this.reDate.toString());
            return false;
        }
        System.out.println("The book " + this.BookName + " is available.");
        return true;
    }

    public void bookReturn() {
        this.Issued = false;
        this.reDate = null;
        this.reserved = false;
    }
}
