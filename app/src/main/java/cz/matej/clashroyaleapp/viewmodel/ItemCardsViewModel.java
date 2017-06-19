package cz.matej.clashroyaleapp.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import cz.matej.clashroyaleapp.activity.DetailCardActivity;
import cz.matej.clashroyaleapp.model.CardEntity;
import cz.matej.clashroyaleapp.rest.ApiConfig;


public class ItemCardsViewModel extends BaseObservable
{

	private CardEntity cards;
	private Context context;


	public ItemCardsViewModel(CardEntity cards, Context context)
	{
		this.cards = cards;
		this.context = context;
	}


	public String getName()
	{
		return cards.getName();
	}


	public String getIdName()
	{
		return cards.getIdName();
	}


	public String getImageUrl()
	{
		return ApiConfig.URL_IMAGE + getIdName() + ".png";
	}


	public void onItemClick(View view)
	{
		context.startActivity(DetailCardActivity.newIntent(view.getContext(), cards));
	}


	public void setCards(CardEntity cards)
	{
		this.cards = cards;
		notifyChange();
	}
}
