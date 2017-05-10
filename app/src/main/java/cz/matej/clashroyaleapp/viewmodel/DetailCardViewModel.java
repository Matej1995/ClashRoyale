package cz.matej.clashroyaleapp.viewmodel;

import android.databinding.BaseObservable;

import cz.matej.clashroyaleapp.model.CardEntity;


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
		return "http://www.clashapi.xyz/images/cards/" + getIdName() + ".png";
	}

}
