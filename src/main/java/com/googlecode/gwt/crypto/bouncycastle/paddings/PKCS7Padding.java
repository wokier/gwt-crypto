package com.googlecode.gwt.crypto.bouncycastle.paddings;


//import org.bouncycastle.crypto.InvalidCipherTextException;
//import org.bouncycastle.java.security.SecureRandom;

import com.googlecode.gwt.crypto.bouncycastle.InvalidCipherTextException;
import com.googlecode.gwt.crypto.util.SecureRandom;



/**
 * A padder that adds PKCS7/PKCS5 padding to a block.
 */
public class PKCS7Padding
    implements BlockCipherPadding
{
    /**
     * Initialise the padder.
     *
     * @param random - a SecureRandom if available.
     */
    @Override
	public void init(SecureRandom random)
        throws IllegalArgumentException
    {
        // nothing to do.
    }

    /**
     * Return the name of the algorithm the padder implements.
     *
     * @return the name of the algorithm the padder implements.
     */
    @Override
	public String getPaddingName()
    {
        return "PKCS7";
    }

    /**
     * add the pad bytes to the passed in block, returning the
     * number of bytes added.
     */
    @Override
	public int addPadding(
        byte[]  in,
        int     inOff)
    {
        byte code = (byte)(in.length - inOff);

        while (inOff < in.length)
        {
            in[inOff] = code;
            inOff++;
        }

        return code;
    }

    /**
     * return the number of pad bytes present in the block.
     */
    @Override
	public int padCount(byte[] in)
        throws InvalidCipherTextException
    {
        int count = in[in.length - 1] & 0xff;

        if (count > in.length || count == 0)
        {
            throw new InvalidCipherTextException("pad block corrupted");
        }
        
        for (int i = 1; i <= count; i++)
        {
            if (in[in.length - i] != count)
            {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        }

        return count;
    }
}
