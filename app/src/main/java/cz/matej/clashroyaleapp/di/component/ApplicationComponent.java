package cz.matej.clashroyaleapp.di.component;

import cz.matej.clashroyaleapp.di.RoyaleScope;
import cz.matej.clashroyaleapp.rest.RoyalApi;
import cz.matej.clashroyaleapp.di.module.ContextModule;
import cz.matej.clashroyaleapp.di.module.RoyaleApiModule;

import dagger.Component;


@RoyaleScope
@Component(modules = {RoyaleApiModule.class, ContextModule.class})
public interface ApplicationComponent
{
	RoyalApi getRoyalApi();
}
