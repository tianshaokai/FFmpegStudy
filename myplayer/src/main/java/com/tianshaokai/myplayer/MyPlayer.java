package com.tianshaokai.myplayer;

import android.text.TextUtils;

/**
 * Author : tianshaokai
 * Date   : 2019/11/19 17:51
 * Desc   :
 * Since  :
 */
public class MyPlayer {

    static {
        System.loadLibrary("ffmpeg_player");
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
    }

    private String url;


    public void setResource(String url) {
        this.url = url;
    }

    public void prepare() {
        if (TextUtils.isEmpty(url)) {
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                n_prepared(url);
            }
        }).start();

    }


    public native void n_prepared(String url);
}
