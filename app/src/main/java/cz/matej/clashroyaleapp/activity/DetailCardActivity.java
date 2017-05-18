package cz.matej.clashroyaleapp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import cz.matej.clashroyaleapp.R;
import cz.matej.clashroyaleapp.databinding.ActivityDetailCardBinding;
import cz.matej.clashroyaleapp.model.CardEntity;
import cz.matej.clashroyaleapp.viewmodel.DetailCardViewModel;


public class DetailCardActivity extends AppCompatActivity {

	private static final String ARG_CARD = "ARG_CARD";


	public static Intent newIntent(Context context, CardEntity cards)
	{
		Intent intent = new Intent(context, DetailCardActivity.class);
		intent.putExtra(ARG_CARD, cards);
		return intent;
	}


	private ActivityDetailCardBinding binding;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_card);
		setSupportActionBar(binding.toolbar);
		displayHomeBackButton();
		getExtrasFromIntent();
	}


	private void displayHomeBackButton()
	{
		ActionBar actionBar = getSupportActionBar();
		if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
	}


	private void getExtrasFromIntent()
	{
		CardEntity cards = (CardEntity) getIntent().getSerializableExtra(ARG_CARD);
		DetailCardViewModel detailCardViewModel = new DetailCardViewModel(cards);
		binding.setCardDetailViewModel(detailCardViewModel);
		setTitle(cards.getName());

	}
}
