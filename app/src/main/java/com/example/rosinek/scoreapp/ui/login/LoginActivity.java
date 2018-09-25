package com.example.rosinek.scoreapp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.ui.main.MainActivity;
import com.example.rosinek.scoreapp.utils.Preferences;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity implements LoginView, LoginNavigator {

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
    }


    @OnClick(R.id.btn_login)
    public void loginClick(){
      presenter.saveFirstLogin();
      goToMainActivity();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}
