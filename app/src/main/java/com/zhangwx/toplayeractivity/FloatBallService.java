package com.zhangwx.toplayeractivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by zhangwx on 2017/5/9.
 */

public class FloatBallService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
