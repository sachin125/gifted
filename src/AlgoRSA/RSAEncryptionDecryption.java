package AlgoRSA;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

import com.algoritham.MySignature;

public class RSAEncryptionDecryption {

	static long time = System.currentTimeMillis();
	public static final String PUBLIC_KEY_FILE = time+"Public.key";
	public static final String PRIVATE_KEY_FILE = time+"Private.key";
	PublicKey publicKey = null;
	PrivateKey  privateKey  = null;
	KeyPair keyPair =null;
	KeyFactory keyFactory = null;
	public RSAEncryptionDecryption()  {
		super();
	}
	public void start()throws Exception{
		System.out.println("-------GENRATE PUBLIC and PRIVATE KEY-------------");
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		keyPair = keyPairGenerator.generateKeyPair();
		keyFactory = KeyFactory.getInstance("RSA");		
	}

	public String generatePrivatekey(String root) throws Exception{
		privateKey = keyPair.getPrivate();
		RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

		System.out.println("PrivKey Modulus : "+ rsaPrivKeySpec.getModulus());
		System.out.println("PrivKey Exponent : "+ rsaPrivKeySpec.getPrivateExponent());
		saveKeys(PRIVATE_KEY_FILE, rsaPrivKeySpec.getModulus(),rsaPrivKeySpec.getPrivateExponent(),root);
		return PRIVATE_KEY_FILE;
		
	}
	public String generatePublickey(String root) throws Exception{
		publicKey = keyPair.getPublic();	
		RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey,RSAPublicKeySpec.class);
		System.out.println("PubKey Modulus : " + rsaPubKeySpec.getModulus());
		System.out.println("PubKey Exponent : "+ rsaPubKeySpec.getPublicExponent());
		saveKeys(PUBLIC_KEY_FILE, rsaPubKeySpec.getModulus(),rsaPubKeySpec.getPublicExponent(),root);
		return PUBLIC_KEY_FILE;
		
	}
	public byte[] sign(byte[] data) throws Exception{
		MySignature mySignature = new MySignature();
		mySignature.createSignature(privateKey, data);
		return data;
		
	}
	//copy bytes
	public static byte[] copyByte(byte[] arr, int length){
		
		byte[] newarr = null;
		if(arr.length == length){
			newarr = arr;
		}else{
			newarr = new byte[length];
			for(int i=0; i<length; i++){
				
				newarr[i] = (byte)arr[i];
			}
		}
	return newarr;
	}
	
	
	/**
	 * Save Files
	 * 
	 * @param fileName
	 * @param mod
	 * @param exp
	 * @throws IOException
	 */
	private void saveKeys(String fileName, BigInteger mod, BigInteger exp,String root)
			throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			System.out.println("Generating " + fileName + "...");
			File root1 = new File(root,fileName);
			fos = new FileOutputStream(root1);
			oos = new ObjectOutputStream(new BufferedOutputStream(fos));

			oos.writeObject(mod);
			oos.writeObject(exp);

			System.out.println("fileNmae : "+root1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				oos.close();

				if (fos != null) {
					fos.close();
				}
			}
		}
	}

	/**
	 * read Public Key From File
	 * 
	 * @param fileName
	 * @return PublicKey
	 * @throws IOException
	 */
	public PublicKey readPublicKeyFromFile(File file) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			BigInteger modulus = (BigInteger) ois.readObject();
			BigInteger exponent = (BigInteger) ois.readObject();

			// Get Public Key
			RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus,
					exponent);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PublicKey publicKey = fact.generatePublic(rsaPublicKeySpec);

			return publicKey;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
				if (fis != null) {
					fis.close();
				}
			}
		}
		return null;
	}
	
	public File encrypData(File file,File privatekeyfile) throws IOException {
		FileInputStream fis=new FileInputStream(file);
		File encfile = new File(file.getAbsolutePath()+".enc");
		FileOutputStream fos=new FileOutputStream(encfile);
		int x=0;
		byte myData[]=new byte[1024];
		while((x=fis.read(myData))>0){
			fos.write(myData,0,x);
			
		}			
		fis.close();
		fos.close();
		return encfile;
	}
	public String decrypData(File file,File privatekeyfile) throws IOException {
		int sep = file.getName().lastIndexOf(".");
	    String filename = file.getName().substring(0, sep);
	    return filename;
	}
	public PrivateKey readPrivateKeyFromFile(File file)
			throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			System.out.println("readPrivateKeyFromFile : "+file.getAbsolutePath());
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			BigInteger modulus = (BigInteger) ois.readObject();
			BigInteger exponent = (BigInteger) ois.readObject();

			// Get Private Key
			RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(
					modulus, exponent);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = fact.generatePrivate(rsaPrivateKeySpec);

			return privateKey;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
				if (fis != null) {
					fis.close();
				}
			}
		}
		return null;
	}

	
	public File encryptData(File file,File privatekeyfile) throws IOException {
		System.out.println("\n----------------ENCRYPTION STARTED------------"+file.getAbsolutePath());

		FileInputStream fis =new FileInputStream(file);
		File encfile = new File("enc.txt");
		FileOutputStream fos =new FileOutputStream(encfile);
		CipherOutputStream cout=null;
		try {
			PrivateKey privateKey = readPrivateKeyFromFile(privatekeyfile);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			cout=new CipherOutputStream(fos, cipher);

			byte[] buf = new byte[1024];
			int read;

			while((read=fis.read(buf))!=-1){ //reading data
				cout.write(buf,0,read); //writing encrypted data
				System.out.println("buf : :"+buf);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		fis.close();
		cout.flush();
		cout.close();
		System.out.println("----------------ENCRYPTION COMPLETED------------");
		return file;
	}
	
	public File decryptData(File file,File publickeyfile) throws IOException {
		System.out.println("\n----------------DECRYPTION STARTED------------file "+file.getAbsolutePath());
		FileInputStream fis =new FileInputStream(file);
		File decfile = new File("dec.txt");		
		FileOutputStream fos =new FileOutputStream(decfile);	
		CipherInputStream cin = null;
		try {
			PublicKey publicKey = readPublicKeyFromFile(publickeyfile);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			cin=new CipherInputStream(fis, cipher);
	
			byte[] buf = new byte[1024];
			int read=0;

			while((read=cin.read(buf))!=-1){ //reading encrypted data
				fos.write(buf,0,read); //writing decrypted data
				System.out.println("buf : :"+buf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------DECRYPTION COMPLETED------------");
		cin.close();
		fos.flush();
		fos.close();
		return file;
	}
}