package com.lzy.pullzoomview.app;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;
import com.lzy.pullzoomview.R;

/**
 * @author Pinger
 * @since 18-7-7 下午2:13
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ViewTarget.setTagId(R.id.glide_tag);
    }
}
