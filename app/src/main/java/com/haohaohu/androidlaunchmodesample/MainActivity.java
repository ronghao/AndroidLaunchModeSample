package com.haohaohu.androidlaunchmodesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.haohaohu.androidlaunchmodesample.activity.SingleInstance1Activity;
import com.haohaohu.androidlaunchmodesample.activity.SingleTask1Activity;
import com.haohaohu.androidlaunchmodesample.activity.SingleTop1Activity;
import com.haohaohu.androidlaunchmodesample.activity.Standard1Activity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
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
    }
}


