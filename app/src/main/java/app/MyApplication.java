package app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lenovo on 2018/12/20.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mSharedPreferences = getSharedPreferences("application",
                Context.MODE_PRIVATE);
   /* JPushInterface.setDebugMode(true);
    JPushInterface.init(this);  */   		// 初始化 JPush
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public SharedPreferences getShare() {
        return mSharedPreferences;
    }

}