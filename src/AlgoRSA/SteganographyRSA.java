package AlgoRSA;

import java.math.BigInteger;
import java.util.Random;

public class SteganographyRSA {
	public static BigInteger[] ciphertext = null;

	static String publicKey = "";
	static String dataToEncrypt = "";
	// Bit length of each prime number.
	int primeSize;
	// Two distinct large prime numbers p and q.
	BigInteger p, q;
	// Modulus N.
	BigInteger N;
	// r = ( p - 1 ) * ( q - 1 )
	BigInteger r;
	// Public exponent E and Private exponent D
	BigInteger E, D;

	public SteganographyRSA(int primeSize) {
		this.primeSize = primeSize;
		// Generate two distinct large prime numbers p and q.
		generatePrimeNumbers();
		// Generate Public and Private Keys.
		generatePublicPrivateKeys();
	}

	// Generate two distinct large prime numbers p and q.
	public void generatePrimeNumbers() {
		p = new BigInteger(primeSize, 10, new Random());
		do {
			q = new BigInteger(primeSize, 10, new Random());
		} while (q.compareTo(p) == 0);
	}

	// Generate Public and Private Keys.
	public void generatePublicPrivateKeys() {
		// N = p * q
		N = p.multiply(q);
		// r = ( p - 1 ) * ( q - 1 )
		r = p.subtract(BigInteger.valueOf(1));
		r = r.multiply(q.subtract(BigInteger.valueOf(1)));
		// Choose E, coprime to and less than r
		do {
			E = new BigInteger(2 * primeSize, new Random());
		} while ((E.compareTo(r) != -1)
				|| (E.gcd(r).compareTo(BigInteger.valueOf(1)) != 0));
		// Compute D, the inverse of E mod r
		D = E.modInverse(r);
	}

	public BigInteger getp() {
		return (p);
	}

	public BigInteger getq() {
		return (q);
	}

	public BigInteger getr() {
		return (r);
	}

	public BigInteger getN() {
		return (N);
	}

	public BigInteger getE() {
		return (E);
	}

	public BigInteger[] getCipherText(byte[] message) {
		return encrypt(message);
	}

	public boolean validate(String dhash, String lt) {
		return dhash.endsWith(lt);
	}

	public BigInteger getD() {
		return (D);
	}
//***************************************************************************
	//Encrypts the plaintext (Using Private Key).
	public BigInteger[] encrypt(byte[] message) {
		int i;
		byte[] temp = new byte[1];
		byte[] digits = message;
		BigInteger[] bigdigits = new BigInteger[digits.length];
		for (i = 0; i < bigdigits.length; i++) {
			temp[0] = digits[i];
			bigdigits[i] = new BigInteger(temp);
		}
		BigInteger[] encrypted = new BigInteger[bigdigits.length];
		for (i = 0; i < bigdigits.length; i++)
			encrypted[i] = bigdigits[i].modPow(D, N);

		return (encrypted);
	}

	// Decrypts the ciphertext (Using Public Key).

	public byte[] decrypt(BigInteger[] encrypted) {
		int i;
		BigInteger[] decrypted = new BigInteger[encrypted.length];
		for (i = 0; i < decrypted.length; i++)
			decrypted[i] = encrypted[i].modPow(E, N);
		byte[] temp = new byte[1];
		byte[] byteArray = new byte[decrypted.length];
		for (i = 0; i < byteArray.length; i++){
			temp = decrypted[i].toByteArray();
			byteArray[i] =temp[0];
		}
		return byteArray;
	}
}
