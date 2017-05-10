package cz.matej.clashroyaleapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import cz.matej.clashroyaleapp.R;
import cz.matej.clashroyaleapp.databinding.RowCardsBinding;
import cz.matej.clashroyaleapp.model.CardEntity;
import cz.matej.clashroyaleapp.viewmodel.ItemCardsViewModel;


import java.util.List;


public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsAdapterViewHolder>
{

	public static CardsAdapter newInstance(@NonNull final List<CardEntity> cardsList)
	{
		return new CardsAdapter(cardsList);
	}


	private List<CardEntity> cardsList;


	public CardsAdapter(final List<CardEntity> cardsList)
	{
		this.cardsList = cardsList;
	}


	@Override
	public CardsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		RowCardsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_cards, parent, false);
		return new CardsAdapterViewHolder(binding);
	}


	@Override
	public void onBindViewHolder(CardsAdapterViewHolder holder, int position)
	{
		holder.bind(cardsList.get(position));
	}


	@Override
	public int getItemCount()
	{
		return this.cardsList.size();
	}


	static class CardsAdapterViewHolder extends RecyclerView.ViewHolder
	{

		RowCardsBinding rowCardsBinding;


		CardsAdapterViewHolder(RowCardsBinding binding)
		{
			super(binding.rowCards);
			this.rowCardsBinding = binding;
		}


		void bind(final CardEntity cards)
		{
			if(rowCardsBinding.getCardsModel() == null)
			{
				rowCardsBinding.setCardsModel(new ItemCardsViewModel(cards, itemView.getContext()));
			}
			else
			{
				rowCardsBinding.getCardsModel().setCards(cards);
			}
		}
	}
}
