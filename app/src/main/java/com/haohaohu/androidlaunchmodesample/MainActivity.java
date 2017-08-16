package com.haohaohu.androidlaunchmodesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.haohaohu.androidlaunchmodesample.activity.Reg1Activity;
import com.haohaohu.androidlaunchmodesample.activity.SingleInstance1Activity;
import com.haohaohu.androidlaunchmodesample.activity.SingleTask1Activity;
import com.haohaohu.androidlaunchmodesample.activity.SingleTask1WithTaskAffinityActivity;
import com.haohaohu.androidlaunchmodesample.activity.SingleTop1Activity;
import com.haohaohu.androidlaunchmodesample.activity.Standard1Activity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void initEvent() {
        findViewById(R.id.main_text_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Standard1Activity.class);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.main_text_2)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SingleTop1Activity.class);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.main_text_3)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SingleTask1Activity.class);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.main_text_4)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SingleInstance1Activity.class);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.main_text_5)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SingleTask1WithTaskAffinityActivity.class);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.main_text_6)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Reg1Activity.class);
                        startActivity(intent);
                    }
                });
    }

    public boolean onKeyDown(int kCode, KeyEvent kEvent) {
        switch (kCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                break;
            case KeyEvent.KEYCODE_BACK:
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count != 0) {
                    return super.onKeyDown(kCode, kEvent);
                }
                Log.v("MyKeyDown", "onkeydown=where");
                exitBy2Click();
                return true;
        }
        return super.onKeyDown(kCode, kEvent);
    }

    private boolean isExit;

    private void exitBy2Click() {
        Timer tExit;
        if (!isExit) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            onDestroy();
            finish();
            System.exit(0);
        }
    }
}


