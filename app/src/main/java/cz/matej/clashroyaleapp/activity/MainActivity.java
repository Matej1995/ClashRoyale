package cz.matej.clashroyaleapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cz.matej.clashroyaleapp.R;
import cz.matej.clashroyaleapp.databinding.ActivityMainBinding;
import cz.matej.clashroyaleapp.fragment.CardsFragment;


public class MainActivity extends AppCompatActivity
{

	ActivityMainBinding binding;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		initFilesFragment();
	}


	private void initFilesFragment()
	{
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.cardsFragment, CardsFragment.newInstance())
				.commit();
	}
}
