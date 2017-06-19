package cz.matej.clashroyaleapp.viewmodel;

import android.databinding.BaseObservable;

import cz.matej.clashroyaleapp.model.CardEntity;
import cz.matej.clashroyaleapp.rest.ApiConfig;


public class DetailCardViewModel extends BaseObservable
{

	private CardEntity cards;


	public DetailCardViewModel(CardEntity cards)
	{
		this.cards = cards;
	}


	public String getIdName()
	{
		return cards.getIdName();
	}


	public String getRarity()
	{
		return cards.getRarity();
	}


	public String getType()
	{
		return cards.getType();
	}


	public String getName()
	{
		return cards.getName();
	}


	public String getImageUrl()
	{
		return ApiConfig.URL_IMAGE + getIdName() + ".png";
	}

}
