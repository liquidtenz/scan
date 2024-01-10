import java.util.*;
import java.math.*;

class Rsa {

    static BigInteger p, q, n, phi, e, d;

    public static void main(String[] args) {

        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        p = BigInteger.probablePrime(1024, rd);
        q = BigInteger.probablePrime(1024, rd);

        n = p.multiply(q);

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(512, rd);
        d = e.modInverse(phi);

        System.out.println("Enter the plain text");
        String msg = sc.nextLine();

        byte[] enc = encrypt(msg.getBytes());
        System.out.println("Encrypted Message: " + new String(enc));

        byte[] dec = decrypt(enc);
        System.out.println("Decrypted Message: " + new String(dec));
    }

    public static byte[] encrypt(byte[] msg) {
        return (new BigInteger(msg)).modPow(e, n).toByteArray();
    }

     public static byte[] decrypt(byte[] msg) {
        return (new BigInteger(msg)).modPow(d, n).toByteArray();
    }

}