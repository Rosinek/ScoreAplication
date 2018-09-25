package com.example.rosinek.scoreapp.ui.login;

import com.example.rosinek.scoreapp.utils.Preferences;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class LoginPresenter {

    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void saveFirstLogin(){
        Hawk.put(Preferences.IS_LOGGED, true);
    }

}
