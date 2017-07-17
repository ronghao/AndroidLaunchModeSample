package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class SingleTask3WithTaskAffinityActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletaskwithtaskaffinity_3);
        initClick();
    }

    private void initClick() {
        findViewById(R.id.activity_singletaskwithtaskaffinity3_text_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SingleTask3WithTaskAffinityActivity.this, SingleTask2WithTaskAffinityActivity.class);
                        intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
        TextView textView = ((TextView) findViewById(R.id.activity_singletaskwithtaskaffinity3_text_2));
        String str = textView.getText() + "   task：" + getTaskId();
        textView.setText(str);
    }

}
