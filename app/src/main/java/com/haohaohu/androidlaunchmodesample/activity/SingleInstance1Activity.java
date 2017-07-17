package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class SingleInstance1Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstance_1);
        initClick();
    }

    private void initClick() {
        findViewById(R.id.activity_singleinstance1_text_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SingleInstance1Activity.this, SingleInstance2Activity.class);
                        intent.addFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_MULTIPLE_TASK);
                        startActivity(intent);
                    }
                });

        TextView textView = ((TextView) findViewById(R.id.activity_singleinstance1_text_2));
        String str = textView.getText() + "   task：" + getTaskId();
        textView.setText(str);
    }

}
