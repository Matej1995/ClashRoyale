package cz.matej.clashroyaleapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import cz.matej.clashroyaleapp.R;
import cz.matej.clashroyaleapp.adapter.CardsAdapter;
import cz.matej.clashroyaleapp.databinding.FragmentCardsBinding;
import cz.matej.clashroyaleapp.db.DatabaseManager;
import cz.matej.clashroyaleapp.di.component.ApplicationComponent;
import cz.matej.clashroyaleapp.di.component.DaggerApplicationComponent;
import cz.matej.clashroyaleapp.di.module.RoyaleApiModule;
import cz.matej.clashroyaleapp.model.CardEntity;
import cz.matej.clashroyaleapp.rest.ApiCallback;
import cz.matej.clashroyaleapp.rest.RoyalApiRepository;
import cz.matej.clashroyaleapp.viewmodel.FragmentViewModel;


public class CardsFragment extends Fragment implements ApiCallback<List<CardEntity>>
{

	public static CardsFragment newInstance()
	{
		return new CardsFragment();
	}


	private FragmentCardsBinding mBinding;
    private DatabaseManager databaseManager;

	@Inject
	public ApplicationComponent mApplicationComponent;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		this.mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cards, container, false);
		return mBinding.getRoot();
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		injectModule();
		super.onCreate(savedInstanceState);
        initDatabase();
	}

    private void initDatabase() {
        databaseManager = new DatabaseManager(getContext());
        databaseManager.open();
    }


    @Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		this.mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // initFragmentViewModel();
        fetchCards();
	}


	@Override
	public void onSuccess(List<CardEntity> cardEntityList)
	{
        databaseManager.selectAllCards(cardEntityList);
		mBinding.recyclerView.setAdapter(CardsAdapter.newInstance(cardEntityList));
	}


	@Override
	public void onError(Throwable e)
	{
		Log.e("Error API", e.getMessage());
	}


	private void injectModule()
	{
		this.mApplicationComponent = DaggerApplicationComponent
				.builder()
				.royaleApiModule(RoyaleApiModule.newInstance())
				.build();
	}

	public void initFragmentViewModel()
    {
        FragmentViewModel model = new FragmentViewModel();
        mBinding.setFragmentModel(model);
    }

    private void fetchCards()
    {
        RoyalApiRepository royalApiRepository = RoyalApiRepository.getInstance(mApplicationComponent.getRoyalApi());
        royalApiRepository.retrieveCards(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        databaseManager.open();
    }

    @Override
    public void onPause() {
        super.onPause();
        databaseManager.close();
    }
}
