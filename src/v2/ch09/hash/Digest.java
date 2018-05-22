package v2.ch09.hash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * This program computes the message digest of a file.
 * @version 1.20 2012-06-16
 * @author Cay Horstmann
 */
public class Digest {
	/** 
	* @param args args[0] is the filename, args[1] is optionally the algorithm (SHA-1 or MD5)
	*/
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		args = new String[2];
		args[0] = "/home/niu/workspace/java-core9/src/v2/ch09/hash/input.txt";
		String algname = args[1] = "SHA-1";
		args[1] = "MD5";
		MessageDigest alg = MessageDigest.getInstance(algname);
		byte[] input = Files.readAllBytes(Paths.get(args[0]));
		byte[] hash = alg.digest(input);
		System.out.println("hash:" + new String(hash));
		String d = "";
		for (int i = 0; i < hash.length; i++) {
			int v = hash[i] & 0xFF;
			if (v < 16)
				d += "0";
			d += Integer.toString(v, 16).toUpperCase() + " ";
		}
		System.out.println(d);
	}
}
