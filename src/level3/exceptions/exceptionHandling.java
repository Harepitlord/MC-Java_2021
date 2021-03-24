package level3.exceptions;

import java.util.Scanner;

public class exceptionHandling {
    private int[] num;
    private int pos;
    private final Scanner sc;

    public exceptionHandling(int n) {
        num = new int[n];
        pos = -1;
        sc = new Scanner(System.in);
    }

    private void stackPush() {
        System.out.println("Enter a value: ");
        int val = sc.nextInt();
        try {
            num[++pos] = val;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The stack is full");
        }
    }

    private void stackPop() {
        try {
            if (pos == -1) {
                throw new underflow("The stack is empty");
            }
            System.out.println("The top element : " + num[pos--]);
        } catch (underflow u) {
            System.out.println("The stack is empty");
        }
    }

    private void stackDisplay() {
        System.out.print("The stack values: [");
        for (int i = 0; i < pos; i++) {
            System.out.print(num[i] + ", ");
        }
        System.out.println("]");
    }

    public void runner() {
        while (true) {
            System.out.println("Enter your choice: \n1.Push\t2.Pop\t3.Display\t4.Exit");
            switch (sc.nextInt()) {
                case 1 -> stackPush();
                case 2 -> stackPop();
                case 3 -> stackDisplay();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stack size: ");
        exceptionHandling ex = new exceptionHandling(sc.nextInt());
        ex.runner();
    }

}
