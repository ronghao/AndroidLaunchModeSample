package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

/**
 * @author haohao on 2017/8/16 13:40
 * @version v1.0
 */
public class Reg1Activity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_1);
        init();
    }

    private void init() {
        TextView textView = (TextView) findViewById(R.id.reg_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reg1Activity.this, Reg2Activity.class);
                startActivity(intent);
            }
        });

        TextView textView1 = ((TextView) findViewById(R.id.reg_show_text));
        String str = "   task：" + getTaskId();
        textView1.setText(str);

    }
}
