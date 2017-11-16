package com.shmily.fujinjing.enjoylife.presentation.view.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shmily.fujinjing.enjoylife.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AdvertisingActivity extends BaseActivity implements AdvertisingIView {
    Timer mTimer = new Timer();
    TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(AdvertisingActivity.this, MainActivity.class);
            startActivity(intent);
            mTimerTask.cancel();
            mTimer.cancel();
            finish();
        }
    };
    @InjectView(R.id.img_advertising)
    ImageView mImgAdvertising;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);
        ButterKnife.inject(this);
    }

    @Override
    public void onCreatePresenter() {

    }

    @OnClick(R.id.skip_advertising)
    public void onSkipAdvertisingClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        mTimerTask.cancel();
        mTimer.cancel();
        finish();
    }

    @Override
    public void requestAdvertisingSuccess(String imgUrl) {
        Glide.with(this)
                .load(imgUrl)
                .into(mImgAdvertising);
        mTimer.schedule(mTimerTask, 3000);
    }

    @Override
    public void requestAdvertisingFail(String failMsg) {

    }

    @Override
    public void requestAdvertisingError() {

    }
}
