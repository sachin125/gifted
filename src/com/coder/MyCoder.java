package com.coder;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class MyCoder {

	//encoder using base64
	public static String encodeBASE64(byte[] bytes) {
		BASE64Encoder b64 = new BASE64Encoder();
		return b64.encode(bytes);
	}

	//decoder using base64
	public byte[] decodeBASE64(String text) throws Exception {
		BASE64Decoder b64 = new BASE64Decoder();
		return b64.decodeBuffer(text);
	}
	
}
