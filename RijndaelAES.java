import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class RijndaelAES{
    public static String encrypt(String plaintext, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String ciphertext, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to encrypt: ");
            String plaintext = scanner.nextLine();
            System.out.print("Enter 16-character key: ");
            String key = scanner.nextLine();
            while (key.length() != 16) {
                System.out.print("Invalid key length! Enter a 16-character key: ");
                key = scanner.nextLine();
            }
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            String encryptedText = encrypt(plaintext, secretKey);
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Encrypted: " + encryptedText);
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
