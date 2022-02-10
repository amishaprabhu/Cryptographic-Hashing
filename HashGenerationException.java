package com.exp;

public class HashGenerationException extends Exception 
{

	public HashGenerationException(String string, Exception ex)
	{
		System.out.println(string+ex);
	}
	

}
