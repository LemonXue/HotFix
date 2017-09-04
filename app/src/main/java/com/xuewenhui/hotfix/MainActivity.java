package com.xuewenhui.hotfix;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button create, update;
    //    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名
    private static final String TAG = "MainActivity";
    private String path = "/fix.apatch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = (Button) findViewById(R.id.btn_create);
        update = (Button) findViewById(R.id.btn_update);
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            path = Environment.getExternalStorageDirectory().getAbsolutePath().concat(path);
        }
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "HelloWord";
                str = str.substring(0, 1);
                Toast.makeText(MainActivity.this, "str:" + str, Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndfixPatchManager.getInstance().addPatch(path);
    }
});
    }

    /**
     * 动态更新，加载补丁文件
     */
    private void update() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            path = Environment.getExternalStorageDirectory().getAbsolutePath().concat(path);
        }
    }
}
