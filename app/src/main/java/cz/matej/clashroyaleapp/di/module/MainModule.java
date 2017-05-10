package cz.matej.clashroyaleapp.di.module;

import android.support.v4.app.FragmentTransaction;

import cz.matej.clashroyaleapp.activity.MainActivity;
import cz.matej.clashroyaleapp.di.MainAppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fanda on 26.4.2017.
 */
@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    protected  MainActivity activity(){
        return activity;
    }

    @MainAppScope
    @Provides
    FragmentTransaction provideFragmentTransaction(){
        return activity.getSupportFragmentManager().beginTransaction();
    }


}
