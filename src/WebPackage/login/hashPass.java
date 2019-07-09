package WebPackage.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hashPass {
	private String s;
	/*
	 Given a byte[] array, produces a hex String,
	 such as "234a6f". with 2 chars for each byte in the array.
	 (provided code)
	*/
	public static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff;  // remove higher bits, sign
			if (val<16) buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}
	
	public hashPass(String s) {
		this.s = s;
	}
	
	public String getHash() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(s.getBytes());
		return hexToString(md.digest());
	}
	
	
}
