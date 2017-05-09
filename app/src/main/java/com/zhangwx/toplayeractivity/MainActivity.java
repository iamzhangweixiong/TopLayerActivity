package com.zhangwx.toplayeractivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        findViewById(R.id.ToastBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String top = TopLayerUtils.getTopLayerActivity(mActivityManager);
                Toast.makeText(getApplicationContext(), top, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
