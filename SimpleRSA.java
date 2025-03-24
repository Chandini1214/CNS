import java.math.BigInteger;
import java.util.Scanner;

public class SimpleRSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Choose two prime numbers
        System.out.print("Enter first prime number (p): ");
        BigInteger p = scanner.nextBigInteger();
        System.out.print("Enter second prime number (q): ");
        BigInteger q = scanner.nextBigInteger();
        
        // Step 2: Compute n = p * q
        BigInteger n = p.multiply(q);
        
        // Step 3: Compute Euler's Totient function φ(n) = (p-1)*(q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        // Step 4: Choose e (1 < e < φ(n), such that gcd(e, φ(n)) = 1)
        BigInteger e = BigInteger.valueOf(65537); // Commonly used public exponent
        
        // Step 5: Compute d (d * e ≡ 1 mod φ(n))
        BigInteger d = e.modInverse(phi);
        
        // Public and Private Keys
        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");
        
        // Encrypt a message
        System.out.print("Enter a message (as a number): ");
        BigInteger message = scanner.nextBigInteger();
        BigInteger encrypted = message.modPow(e, n);
        System.out.println("Encrypted Message: " + encrypted);
        
        // Decrypt the message
        BigInteger decrypted = encrypted.modPow(d, n);
        System.out.println("Decrypted Message: " + decrypted);
        
        scanner.close();
    }
}
