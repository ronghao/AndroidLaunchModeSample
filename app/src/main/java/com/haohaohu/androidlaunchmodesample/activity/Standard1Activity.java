package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.haohaohu.androidlaunchmodesample.R;

public class Standard1Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_1);
        initClick();
    }

    private void initClick() {
        findViewById(R.id.activity_standard1_text_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Standard1Activity.this, Standard2Activity.class);
                        startActivity(intent);
                    }
                });
    }

}
