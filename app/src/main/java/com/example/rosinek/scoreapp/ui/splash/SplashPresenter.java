package com.example.rosinek.scoreapp.ui.splash;

import com.example.rosinek.scoreapp.utils.Preferences;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
public class SplashPresenter {

    SplashView view;
    SplashNavigator navigator;

    SplashPresenter(SplashView view, SplashNavigator navigator) {
        this.navigator = navigator;
        this.view = view;
        checkFastLogin();
    }
    void checkFastLogin(){

    if (Hawk.get(Preferences.IS_LOGGED, false)) {
        navigator.goToMainView();
    } else {
        postponeLoginView();
    }
}

    private void postponeLoginView() {
        view.startLoginViewAnimation(1000);
    }
}
