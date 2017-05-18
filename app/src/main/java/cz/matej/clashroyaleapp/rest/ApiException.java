package cz.matej.clashroyaleapp.rest;


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
