import java.util.Scanner;

public class ExtendedEuclidean {
    // Function to implement the Extended Euclidean Algorithm
    public static int extendedGCD(int a, int b, int[] x, int[] y) {
        if (a == 0) {
            x[0] = 0;
            y[0] = 1;
            return b;
        }
        
        int[] x1 = {0}, y1 = {0};
        int gcd = extendedGCD(b % a, a, x1, y1);
        
        x[0] = y1[0] - (b / a) * x1[0];
        y[0] = x1[0];
        
        return gcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int[] x = {0}, y = {0};
        
        // Compute GCD and coefficients
        int gcd = extendedGCD(a, b, x, y);
        
        // Display results
        System.out.println("GCD of " + a + " and " + b + " is " + gcd);
        System.out.println("Coefficients x = " + x[0] + ", y = " + y[0]);
        
        scanner.close();
    }
}
