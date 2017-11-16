package com.shmily.fujinjing.enjoylife.presentation.view.activitys;

/**
 * Created by fujinjing on 2017/10/31.
 */

public interface AdvertisingIView {
    /**
     * 请求广告回调成功
     */
    void requestAdvertisingSuccess(String imgUrl);

    /**
     * 请求广告网络失败
     */
    void requestAdvertisingFail(String failMsg);

    /**
     * 请求广告本地失败
     */
    void requestAdvertisingError();
}
