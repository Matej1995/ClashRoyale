package cz.matej.clashroyaleapp.di.module;

import cz.matej.clashroyaleapp.rest.RoyalApi;
import cz.matej.clashroyaleapp.di.RoyaleScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class RoyaleApiModule
{
	@Provides
	@RoyaleScope
	public RoyalApi royalApi()
	{
		return retrofit().create(RoyalApi.class);
	}


	@Provides
	@RoyaleScope
	public Retrofit retrofit()
	{
		return new Retrofit.Builder()
				.baseUrl("http://www.clashapi.xyz")
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
	}


	public static RoyaleApiModule newInstance()
	{
		return new RoyaleApiModule();
	}
}
