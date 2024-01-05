package com.example.lab061;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUrl;
    private Button buttonShowWebPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);
        buttonShowWebPage = findViewById(R.id.buttonShowWebPage);

        buttonShowWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWebPage();
            }
        });
    }

    private void showWebPage() {
        String url = editTextUrl.getText().toString();

        // Tạo Intent để mở trang web
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        // Kiểm tra xem có Activity nào có thể xử lý Intent này không
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Nếu không có Activity nào hỗ trợ, mở trang web trong ứng dụng của bạn
            Intent webIntent = new Intent(MainActivity.this, WebActivity.class);
            webIntent.setData(Uri.parse(url));
            startActivity(webIntent);
        }
    }
}
