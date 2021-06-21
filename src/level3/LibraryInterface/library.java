package level3.LibraryInterface;

public interface library {
    public void drawBook(String bkName);

    public void checkStatus(String bkName);

    public void reserveBook(String bkName);

    public void returnBook(String bkName);

    public void displayAll();
}
