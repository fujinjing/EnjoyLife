package com.shmily.fujinjing.enjoylife.http;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @anthor: gaotengfei
 * @time: 2016/12/28
 * @tel: 18511913443
 * @desc:
 */

public interface RetrofitControler {
    /**接口封装类，网络请求时调用该类的相应的方法*/

    /**
     * 获取音频首页的banner
     */
    @GET("/getbanner")
    Observable<String> getAudioBanner(@Query("bannerType") String bannerType);
    /**
     * 获取音频首页的歌单
     */
    @GET("/getsongmenu")
    Observable<String> getSongmenu();
    /**
     * 获取音频首页的音乐
     */
    @GET("/getmusicList")
    Observable<String> getAudio();


}
