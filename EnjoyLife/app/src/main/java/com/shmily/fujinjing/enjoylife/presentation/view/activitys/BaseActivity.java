package com.shmily.fujinjing.enjoylife.presentation.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.shmily.fujinjing.enjoylife.http.rxjava.ActivityLifecycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import rx.Subscriber;

/**
 * 所有activity的基类，便于统一管理
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreatePresenter();
    }

    /**
     * 用于实现presenter接口
     */
    public abstract void onCreatePresenter();
    @Override
    protected void onDestroy() {
        //unsubscribe网络请求
        Iterator<SubscriberWrapper> it = subscribers.iterator();
        while (it.hasNext()) {
            SubscriberWrapper subscriberWrapper = it.next();
            if (subscriberWrapper.unsubscribeOn == ActivityLifecycle.OnDestroy) {
                Log.e("rxjava", "onDestroy==============>");
                subscriberWrapper.subscriber.unsubscribe();
                it.remove();
            }
        }
        super.onDestroy();
    }

    private List<SubscriberWrapper> subscribers = new LinkedList<>();
    public void addSubscriber(Subscriber subscriber, ActivityLifecycle unsubscribeOn) {
        subscribers.add(new SubscriberWrapper(subscriber, unsubscribeOn));
    }

    private class SubscriberWrapper {
        Subscriber subscriber;
        ActivityLifecycle unsubscribeOn;

        public SubscriberWrapper(Subscriber subscriber, ActivityLifecycle unsubscribeOn) {
            this.subscriber = subscriber;
            this.unsubscribeOn = unsubscribeOn;
        }
    }
}
