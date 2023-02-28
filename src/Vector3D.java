import java.util.Scanner;
import java.text.DecimalFormat;

public class Vector3D {
    static Scanner console;
    
    private double x;
    private double y;
    private double z;

    public Vector3D () {
        x = 0; y = 0; z = 0; 
    }

    public Vector3D (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3D Add(Vector3D next) {
        return new Vector3D(
            this.x + next.x, 
            this.y + next.y,
            this.z + next.z
        );
    }

    public Vector3D Substract(Vector3D next) {
        return new Vector3D(
            this.x - next.x, 
            this.y - next.y,
            this.z - next.z
        );
    }

    public double ScalarProductOfVectors(Vector3D next) {
        double result = this.x * next.x + this.y * next.y + this.z * next.z;
        return result;
    }

    public Vector3D MultiplyOnScalar(double scalar) {
        return new Vector3D(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    public boolean Comparsion(Vector3D next) {
        return this.x == next.x && this.y == next.y && this.z == next.z;
    }

    public double vectorLength() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + this.z * this.z);
    }

    public int compareLength(Vector3D next) {
        DecimalFormat df = new DecimalFormat("#.###");
        double difference = this.vectorLength() - next.vectorLength();
        String len1 = df.format(this.vectorLength());
        String len2 = df.format(next.vectorLength());
        String diffToString = df.format(difference);
        if (difference > 0) {
            System.out.println(" " + len1 + " > " + len2);
            System.out.println(" Difference = " + diffToString);
            return 1;
        } else if (difference < 0) {
            System.out.println(" " + len1 + " < " + len2);
            System.out.println(" Difference = " + diffToString);
            return -1;
        } else {
            System.out.println(" " + len1 + " = " + len2);
            System.out.println(" Difference = " + diffToString);
            return 0;
        }
    }

    public void Print () {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
    
    public static void main(String[] args) {
        // Empty vector
        System.out.println("\nLab 1 - Vector3D\n");
        System.out.print("Empty vector: ");
        Vector3D emptyObj = new Vector3D();
        emptyObj.Print();

        // Adding
        System.out.print("\n----------------------------");
        System.out.print("\n A");
        Vector3D A = new Vector3D(10, -10, 7);
        A.Print();
        System.out.print(" B");
        Vector3D B = new Vector3D(-2, 3, 11);
        B.Print();
        System.out.println(" Adding vectors A, B:");
        System.out.print(" C");
        Vector3D C = new Vector3D();
        C = A.Add(B);
        C.Print();

        // Substraction
        System.out.print("----------------------------");
        System.out.print("\n D");
        Vector3D D = new Vector3D(15, 20, 10);
        D.Print();
        System.out.print(" E");
        Vector3D E = new Vector3D(5, -5, 10);
        E.Print();
        System.out.println(" Substraction of vectors D & E:");
        System.out.print(" F");
        Vector3D F = new Vector3D();
        F = D.Substract(E);
        F.Print();

        // Scalar product of vectors
        System.out.print("----------------------------");
        System.out.println("\n Scalar products of vectors A & B:");
        System.out.print(" A"); A.Print();
        System.out.print(" B"); B.Print();
        System.out.print(" Product: ");
        double product = A.ScalarProductOfVectors(B);
        System.out.print(product);

        // Multiply on scalar
        System.out.print("----------------------------");
        System.out.println("\n Multiply vector A on scalar:");
        System.out.print(" A"); A.Print();
        double scalarG = 3;
        Vector3D G = A.MultiplyOnScalar(scalarG);
        System.out.println(" scalar: " + scalarG);
        System.out.print(" G"); G.Print();

        // Comparing two vectors
        System.out.println("\n----------------------------");
        System.out.println(" Comparsion of vectors:");
        System.out.print("\n vec1");
        Vector3D vec1 = new Vector3D(3, 7, 1);
        vec1.Print();
        System.out.print(" vec2");
        Vector3D vec2 = new Vector3D(3, 7, 1);
        vec2.Print();
        boolean res1 = vec1.Comparsion(vec2);
        System.out.println(" vec1 == vec2: " + res1);
        System.out.print("\n A"); A.Print();
        System.out.print(" B"); B.Print();
        boolean res2 = A.Comparsion(B);
        System.out.println(" A == B: " + res2);

        // Vector length
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("\n----------------------------");
        System.out.println(" Vector length:");
        System.out.print("\n A"); A.Print();
        double lengthA = A.vectorLength();
        String stringLengthA = df.format(lengthA);
        System.out.print(" Length of vector A: " + stringLengthA);

        // Comparing difference of vector lengths
        System.out.println("\n----------------------------");
        System.out.println(" Comparing difference of vector lengths:");
        System.out.print("\n A"); A.Print();
        System.out.print(" Length of vector A: " + stringLengthA);
        System.out.print("\n B"); B.Print();
        double lengthB = B.vectorLength();
        String stringLengthB = df.format(lengthB);
        System.out.println(" Length of vector B: " + stringLengthB);
        System.out.print("\n Result of comprasion: \n");
        int comparing = A.compareLength(B);
    }
}
