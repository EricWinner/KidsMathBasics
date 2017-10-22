package kisdmathbasics.edwardadmin.com.kidsmathbasics;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by EdwardAdmin on 2017/10/9.
 */

public class SplashActivity extends AppCompatActivity{

    private static final String TAG = "SplashActivity";

    private static final int TIME_DELAY = 800; //ms
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏设置，隐藏窗口所有装饰
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        },TIME_DELAY);
    }


}
