package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.txtname);
        password = (EditText)findViewById(R.id.txtpassword);
        login  = (Button)findViewById(R.id.loginbtn);
        info = (TextView) findViewById(R.id.txtinfo);


        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String  Password = password.getText().toString();
                if (Username.equals("admin") && Password.equals("123")){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else{
                    info.setText("@string/incorrect");
                }
            }
        });
        TextView reg = findViewById(R.id.txtregister);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

    }
}
