package com.arkham.gradeview.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arkham.gradeview.R;

public class LoginChatActivity extends AppCompatActivity {

    Button btn_login;

    TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_chat);


        btn_login = findViewById(R.id.btn_login);
        forgot_password = findViewById(R.id.forgot_password);


        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(LoginChatActivity.this, ResetPasswordChatActivity.class);
                startActivity(k);
            }
        });
    }
}
