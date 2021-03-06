package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class SingleTask2WithTaskAffinityActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletaskwithtaskaffinity_2);
        initClick();
    }

    private void initClick() {
        findViewById(R.id.activity_singletaskwithtaskaffinity2_text_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SingleTask2WithTaskAffinityActivity.this, SingleTask3WithTaskAffinityActivity.class);
                        intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
        TextView textView = ((TextView) findViewById(R.id.activity_singletaskwithtaskaffinity2_text_2));
        String str = textView.getText() + "   task：" + getTaskId();
        textView.setText(str);
    }

}
