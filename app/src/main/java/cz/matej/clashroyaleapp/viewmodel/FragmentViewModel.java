package cz.matej.clashroyaleapp.viewmodel;

import android.databinding.BaseObservable;


import javax.inject.Inject;

import cz.matej.clashroyaleapp.di.component.ApplicationComponent;

import cz.matej.clashroyaleapp.rest.RoyalApiRepository;

/**
 * Created by Fanda on 12.5.2017.
 */

public class FragmentViewModel extends BaseObservable{




    @Inject
    public ApplicationComponent mApplicationComponent;

    public FragmentViewModel() {
            // fetchCards();
    }

    public void getHandler()
    {
        try {
          // TODO
        }
        catch (ClassCastException r)
        {
            throw new RuntimeException("That error" + r.getMessage());
        }
    }



}
