package com.example.rosinek.scoreapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.ui.login.LoginActivity;
import com.example.rosinek.scoreapp.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
public class SplashActivity extends AppCompatActivity implements SplashView,SplashNavigator {

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
    }

    @Override
    public void startLoginViewAnimation(int delay) {
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.2f);
        animation.setDuration(delay);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               goToLoginView();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivBackground.startAnimation(animation);
        animation.setFillAfter(true);
    }

    @Override
    public void goToLoginView() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override
    public void goToMainView() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}
