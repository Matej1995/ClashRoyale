package cz.matej.clashroyaleapp.di.module;

import android.content.Context;


import cz.matej.clashroyaleapp.di.RoyaleScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fanda on 25.4.2017.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @RoyaleScope
    public Context context(){
        return context;
    }

}
