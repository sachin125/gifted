package com.algoritham;

import java.io.File;
import java.io.FileInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/*
 * generate Signature using SHA1withRSA
 */

public class MySignature {

	public byte[] createSignature(PrivateKey privatekey, byte[] data)
			throws Exception {
		Signature instance = Signature.getInstance("SHA1withRSA");
		instance.initSign(privatekey);
		instance.update(data);
		byte[] signature = instance.sign();
		return signature;
	}

	public boolean verifySignature(PublicKey publickey, byte[] bytemessage,
			byte[] signatureBytes) throws Exception {

		Signature sig = Signature.getInstance("SHA1withRSA");
		sig.initVerify(publickey);
		sig.update(bytemessage);
		boolean b = sig.verify(signatureBytes);
		return b;
	}

}// end of class
