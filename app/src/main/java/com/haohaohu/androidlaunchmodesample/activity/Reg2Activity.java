package com.haohaohu.androidlaunchmodesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.haohaohu.androidlaunchmodesample.R;

/**
 * @author haohao on 2017/8/16 13:40
 * @version v1.0
 */
public class Reg2Activity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_2);
        init();
    }

    private void init() {
        TextView textView = (TextView) findViewById(R.id.reg2_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reg2Activity.this, Reg3Activity.class);
                startActivity(intent);
            }
        });

        EditText editText = (EditText) findViewById(R.id.reg2_edit);

        TextView textView1 = ((TextView) findViewById(R.id.reg2_show_text));
        String str = "   task：" + getTaskId();
        textView1.setText(str);
    }
}
