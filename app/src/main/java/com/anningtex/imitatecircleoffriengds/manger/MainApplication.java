package com.anningtex.imitatecircleoffriengds.manger;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;

/**
 * @author Song
 */
public class MainApplication extends Application {
    private static final String TAG = "Init";
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        // Android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }
    }

    public static Context getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        new Handler(getMainLooper()).post(() -> {
            while (true) {
                try {
                    Looper.loop();//try-catch主线程的所有异常；Looper.loop()内部是一个死循环，出现异常时才会退出，所以这里使用while(true)。
                } catch (Throwable e) {
                    Log.d(TAG, "Looper.loop(): " + e.getMessage());
                }
            }
        });

        //try-catch子线程的所有异常。
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            Log.d(TAG, "UncaughtExceptionHandler: " + e.getMessage());
        });
    }
}