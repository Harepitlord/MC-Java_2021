package level3;

import level3.construction.building;
import level3.construction.house;
import level3.construction.school;

import java.util.Scanner;

public class constructionClass {

    public static void main(String[] args) {
        double d;
        int i;
        Scanner sc = new Scanner(System.in);
        building build = new building();
        house home = new house();
        school academy = new school();
        System.out.println("Enter the sq.ft: ");
        d = sc.nextDouble();
        build.setSqFt(d);
        System.out.println("Enter the no floor: ");
        i = sc.nextInt();
        build.setNoFloor(i);
        sc.nextLine();
        System.out.println("Enter the whether it is a apartment: ");
        String s = sc.nextLine();
        boolean apart = s.equals("y") || s.equals("Y");
        build.setApartment(apart);
        System.out.println("Enter the no of bed: ");
        i = sc.nextInt();
        home.setNoBed(i);
        System.out.println("Enter the no of baths: ");
        i = sc.nextInt();
        home.setNoBaths(i);
        System.out.println("Enter the no of classes:  ");
        i = sc.nextInt();
        academy.setNoClass(i);
        System.out.println("Enter the grade : \t 1.Elementary school \t 2.High school");
        switch (sc.nextInt()) {
            case 1 -> {
                academy.setGrade("1.Elementary school");
            }
            case 2 -> {
                academy.setGrade("High school");
            }
        }
        System.out.println("Building: " + build.toString());
        System.out.println("House: " + home.toString());
        System.out.println("School: " + academy.toString());
    }
}
