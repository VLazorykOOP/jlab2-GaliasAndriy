import java.text.DecimalFormat;
import java.util.Scanner;

public class Cone {
    static Scanner console;

    private double r;
    private double h;

    public Cone () {
        r = 0; h = 0;
    }

    public Cone (double h, double r) {
        this.h = h;
        this.r = r;
    }
    
    // l^2 = r^2 + h^2  Pythagor
    // S = pi * r * l
    public double getSideBaseArea() {
        double l = Math.sqrt(r * r + h * h);
        return Math.PI * r * l;
    }

    // V = 1/3 * pi * r^2 * h
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * (r * r) * h;
    }

    public void Print () {
        System.out.println("(h: " + h + ", r: " + r + ")");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        Cone newCone = new Cone(15, 7.5);
        System.out.println("Task 2 Cone\n");
        System.out.print("Cone A ");
        newCone.Print();

        double sideBA = newCone.getSideBaseArea();
        double volume = newCone.getVolume();
        String SBA = df.format(sideBA);
        String V = df.format(volume);
        System.out.println(" Side base area of cone A = " + SBA);
        System.out.println(" V = " + V);
    }
}
