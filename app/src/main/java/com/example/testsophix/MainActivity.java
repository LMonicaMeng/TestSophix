package com.example.testsophix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testsophix.keep.KeepHelper;
import com.taobao.sophix.SophixManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KeepHelper.INSTANCE.open(this);
        clickButton();
    }

    private void clickButton() {
        //资源文件
        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResActivity.class));
            }
        });
        //查询patch包
        findViewById(R.id.btn_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SophixManager.getInstance().queryAndLoadNewPatch();
                //替换文字
                Button btn = findViewById(R.id.btn_02);
//                btn.setText("测试指定设备");
            }
        });


    }
}
