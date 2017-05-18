package cz.matej.clashroyaleapp.rest;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;



public abstract class BaseCallback<T> implements SingleObserver<T>
{
	@Override
	public void onSubscribe(Disposable d)
	{

	}
}
