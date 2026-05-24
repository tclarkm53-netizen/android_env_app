package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.backblaze.b2.client.B2Sdk;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.main_text);
        
        try {
            // সেফ মোডে ভার্সন গেট করা হচ্ছে
            String sdkVersion = B2Sdk.getVersion();
            if (sdkVersion != null && !sdkVersion.isEmpty()) {
                tv.setText("B2 SDK Version: " + sdkVersion);
            } else {
                tv.setText("B2 SDK Loaded (Version string empty)");
            }
        } catch (Throwable e) {
            // যদি কোনো ক্লাস মিসিং বা রিফ্লেকশন এরর হয়, অ্যাপ ক্র্যাশ না করে স্ক্রিনে এরর দেখাবে
            tv.setText("SDK Error: " + e.getMessage() + "\n" + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}
