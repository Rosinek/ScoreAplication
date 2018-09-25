package com.example.rosinek.scoreapp.ui.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Module
public class LoginModule {

    @Provides
    LoginView provideLoginView(LoginActivity activity){
        return activity;
    }

    @Provides
    LoginNavigator provideLoginNavigator(LoginActivity activity){
        return activity;
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginView view){
        return new LoginPresenter(view);
    }

}
