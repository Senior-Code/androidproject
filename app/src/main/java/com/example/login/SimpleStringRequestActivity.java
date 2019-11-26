package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SimpleStringRequestActivity extends AppCompatActivity {

    String serverurl = "http://172.20.10.2/android.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_string_request);
    }
}
