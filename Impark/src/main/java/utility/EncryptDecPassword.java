package utility;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecPassword 
{
	public static final String SECRET_KEY = "bhavikautomat78i";
	public static final String password= "bhavik123!";
	
	public static String encrypt(String strToEncrypt)
	{
	    try
	    {
	        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	}

	public static String decrypt(String strToDecrypt)
	{
	    try
	    {
	        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public static void main(String[] args)
	{
		System.out.println(EncryptDecPassword.encrypt(password));
	}

}
