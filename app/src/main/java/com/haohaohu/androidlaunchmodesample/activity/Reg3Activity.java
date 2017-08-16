package com.haohaohu.androidlaunchmodesample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

/**
 * @author haohao on 2017/8/16 13:40
 * @version v1.0
 */
public class Reg3Activity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_3);
        init();
    }

    private void init() {
        TextView textView1 = ((TextView) findViewById(R.id.reg3_show_text));
        String str = "   task：" + getTaskId();
        textView1.setText(str);
    }
}
