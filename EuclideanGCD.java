import java.util.Scanner;
public class EuclideanGCD {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd(num1, num2));
        scanner.close();
    }
}
