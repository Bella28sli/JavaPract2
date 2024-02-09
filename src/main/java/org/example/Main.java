package org.example;
import java.lang.Math.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double EARTH = 6378.160;
        double Alatitude = 0, Blatitude = 0, Alongitude = 0, Blongitude = 0;
        try {
            System.out.println("Введите широту точки А в градусах");
            Alatitude = sc.nextDouble(); sc.nextLine();
            System.out.println("Введите долготу точки А в градусах");
            Alongitude = sc.nextDouble(); sc.nextLine();
            System.out.println("Введите широту точки В в градусах");
            Blatitude = sc.nextDouble(); sc.nextLine();
            System.out.println("Введите долготу точки В в градусах");
            Blongitude = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Неверный формат");
        }
        Alatitude = Math.toRadians(Alatitude);
        Alongitude =Math.toRadians(Alongitude);
        Blatitude = Math.toRadians(Blatitude);
        Blongitude =Math.toRadians(Blongitude);

        double sinlatA = Math.sin(Alatitude);
        double coslatA = Math.cos(Alatitude);

        double sinlatB = Math.sin(Blatitude);
        double coslatB = Math.cos(Blatitude);

        double sindel = Math.sin(Blongitude - Alongitude);
        double cosdel = Math.cos(Blongitude - Alongitude);

        double y = Math.sqrt(Math.pow(coslatB*sindel,2)+Math.pow(coslatA*sinlatB-sinlatA*coslatB*cosdel,2));
        double x = sinlatA*sinlatB+coslatA*coslatB*cosdel;
        double ad = Math.atan2(y,x);
        double result = ad*EARTH;

        System.out.println("Расстояние между точкой А и точкой В: " + result + " километров");

    }
}