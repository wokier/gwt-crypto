package com.googlecode.gwt.crypto.bouncycastle.digests;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.junit.client.GWTTestCase;
import com.googlecode.gwt.crypto.common.CryptoTest;

@SuppressWarnings("unused")
public class SHA1DigestTest extends CryptoTest {
	@Override
	public void onModuleLoad() {
		//Do nothing
	}

	public void testCreateDigest() {
		try {
			String passwordString = "abcdefghi";
			SHA1Digest digest = new SHA1Digest();
			byte[] inputBytes = new byte[digest.getDigestSize()];
			byte[] pwBytes = passwordString.getBytes();
			for (int i = 0; i < pwBytes.length; i++) {
				inputBytes[i] = pwBytes[i];
			}

			digest.update(inputBytes, 0, inputBytes.length);

			int val = digest.doFinal(inputBytes, 0);
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			fail(e.toString());
		}
		
	}


	public void testCreateEmptyDigest() {
		try {
			String passwordString = "";
			SHA1Digest digest = new SHA1Digest();
			byte[] inputBytes = new byte[digest.getDigestSize()];
			byte[] pwBytes = passwordString.getBytes();
			for (int i = 0; i < pwBytes.length; i++) {
				inputBytes[i] = pwBytes[i];
			}

			digest.update(inputBytes, 0, inputBytes.length);

			int val = digest.doFinal(inputBytes, 0);
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			fail(e.toString());
		}
		
	}


	public void testCreateShortDigest() {
		try {
			String passwordString = "ab";
			SHA1Digest digest = new SHA1Digest();
			byte[] inputBytes = new byte[digest.getDigestSize()];
			byte[] pwBytes = passwordString.getBytes();
			for (int i = 0; i < pwBytes.length; i++) {
				inputBytes[i] = pwBytes[i];
			}

			digest.update(inputBytes, 0, inputBytes.length);

			int val = digest.doFinal(inputBytes, 0);
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			fail(e.toString());
		}
		
	}


	public void testCreateUnicodeDigest() {
		try {
			String passwordString = "\u00D6 \u00C4 (German)\n";
			SHA1Digest digest = new SHA1Digest();
			byte[] inputBytes = new byte[digest.getDigestSize()];
			byte[] pwBytes = passwordString.getBytes();
			for (int i = 0; i < pwBytes.length; i++) {
				inputBytes[i] = pwBytes[i];
			}

			digest.update(inputBytes, 0, inputBytes.length);

			int val = digest.doFinal(inputBytes, 0);
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			fail(e.toString());
		}
		
	}
}
