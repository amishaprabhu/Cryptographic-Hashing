package com.exp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class md5
{
	 public static String generateMD5(String message) throws HashGenerationException 
	 {
	        return hashString(message, "MD5");
	 }
	 
	 private static String hashString(String message, String algorithm)
	            throws HashGenerationException 
	 {
	        try 
	        {
	            MessageDigest digest = MessageDigest.getInstance(algorithm);
	            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
	 
	            return convertByteArrayToHexString(hashedBytes);
	        }
	        catch (NoSuchAlgorithmException | UnsupportedEncodingException ex)
	        {
	            throw new HashGenerationException(
	                    "Could not generate hash from String", ex);
	        }
	    }
	 
	 private static String convertByteArrayToHexString(byte[] arrayBytes) 
	 {
	        StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < arrayBytes.length; i++) 
	        {
	            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                    .substring(1));
	        }
	        return stringBuffer.toString();
	    }
}

class sha1
{
	String message;
	public sha1(String message)
	{
		this.message=message;
	}
	
	public static String generateSHA1(String message) throws HashGenerationException
	{
        return hashString(message, "SHA-1");
    }
	
	 private static String hashString(String message, String algorithm)
	            throws HashGenerationException 
	 {
	        try
	        {
	            MessageDigest digest = MessageDigest.getInstance(algorithm);
	            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
	 
	            return convertByteArrayToHexString(hashedBytes);
	        } 
	        catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) 
	        {
	            throw new HashGenerationException(
	                    "Could not generate hash from String", ex);
	        }
	    }
 
	 private static String convertByteArrayToHexString(byte[] arrayBytes) 
	 {
	        StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < arrayBytes.length; i++) 
	        {
	            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                    .substring(1));
	        }
	        return stringBuffer.toString();
	    }
}

public class Hashing 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("1. MD-5 2.SHA-1");
			System.out.println("Enter the cryptographic hash function to be performed:");
			int n=Integer.parseInt(br.readLine());
			System.out.println("Enter the message:");
			String message=br.readLine();
			switch(n)
			{
			case 1:String md5Hash = md5.generateMD5(message);
				   System.out.println("MD5 Hash value: " + md5Hash);
				   break;
			case 2:String sha1Hash = sha1.generateSHA1(message);
            	   System.out.println("SHA-1 Hash value: " + sha1Hash);
				   break;
			default:System.out.println("Please select valid option");
			}
		}
		catch (HashGenerationException ex) 
		{
            ex.printStackTrace();
        }
	}
}