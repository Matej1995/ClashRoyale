package cz.matej.clashroyaleapp.rest;


import cz.matej.clashroyaleapp.model.CardEntity;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;


public interface RoyalApi
{
	@GET("/api/cards")
	Single<Response<List<CardEntity>>> retrieveCards();
}
