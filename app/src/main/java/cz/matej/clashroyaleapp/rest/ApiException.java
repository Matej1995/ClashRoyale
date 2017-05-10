package cz.matej.clashroyaleapp.rest;

/**
 * Created by Jirka Helmich on 09.05.17.
 */

public class ApiException extends Throwable
{

	public static ApiException create(int code)
	{
		return new ApiException(code);
	}


	private int code;


	public ApiException(int code)
	{
		this.code = code;
	}


	public int getCode()
	{
		return code;
	}


	public void setCode(int code)
	{
		this.code = code;
	}
}
