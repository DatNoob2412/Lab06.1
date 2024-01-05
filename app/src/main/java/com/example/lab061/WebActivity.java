package com.example.lab061;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        // Xử lý Intent để hiển thị trang web
        Intent intent = getIntent();
        Uri uri = intent.getData();

        if (uri != null) {
            showWebPage(uri.toString());
        } else {
            // Xử lý nếu không có URI
            finish();
        }
    }

    private void showWebPage(String url) {
        // Sử dụng CustomTabsIntent để hiển thị trang web trong ứng dụng của bạn
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        finish();
    }
}
