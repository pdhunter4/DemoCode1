package passwordencryption;

import org.apache.commons.codec.binary.Base64;

public class EncodingAndDecoding {

	public static void main(String[] args) {

		/*
		 * Apache Commons Codec package is use for String encoding
		 */
		
		String password = "Mtech123$";
		
		// Base64 is the class
		byte[] encodedValue = Base64.encodeBase64(password.getBytes());
		System.out.println("Encoded String: " + new String(encodedValue));
		
		byte[] decodedValue = Base64.decodeBase64(encodedValue);
		System.out.println("Decoded String: " + new String(decodedValue));

	}

}
