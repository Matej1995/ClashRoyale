package cz.matej.clashroyaleapp.rest;

import android.support.annotation.NonNull;

import cz.matej.clashroyaleapp.db.DatabaseManager;
import cz.matej.clashroyaleapp.model.CardEntity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class RoyalApiRepository
{

	private static RoyalApiRepository sInstance;


	public static RoyalApiRepository getInstance(@NonNull final RoyalApi royalApi)
	{
		if(sInstance == null) sInstance = new RoyalApiRepository(royalApi);
		return sInstance;
	}


	private RoyalApi mRoyalApi;


	public RoyalApiRepository(RoyalApi royalApi)
	{
		this.mRoyalApi = royalApi;
	}


	public void retrieveCards(@NonNull final ApiCallback<List<CardEntity>> apiCallback)
	{
		this.mRoyalApi.retrieveCards()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.timeout(30, TimeUnit.SECONDS)
				.subscribe(new BaseCallback<Response<List<CardEntity>>>()
				{
					@Override
					public void onSuccess(Response<List<CardEntity>> response)
					{
						if(response.isSuccessful())
						{
							apiCallback.onSuccess(response.body());
						}
						else
						{
							apiCallback.onError(ApiException.create(response.code()));
						}
					}


					@Override
					public void onError(Throwable e)
					{
						apiCallback.onError(e);
					}
				});
	}
}
