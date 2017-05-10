package cz.matej.clashroyaleapp.rest;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


/**
 * Created by Jirka Helmich on 09.05.17.
 */

public abstract class BaseCallback<T> implements SingleObserver<T>
{
	@Override
	public void onSubscribe(Disposable d)
	{

	}
}
