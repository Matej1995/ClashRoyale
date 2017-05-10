package cz.matej.clashroyaleapp.rest;

public interface ApiCallback<T>
{
	void onSuccess(T object);
	void onError(Throwable e);
}
