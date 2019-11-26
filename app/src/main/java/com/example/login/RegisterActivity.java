package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {
    String tittle[] = {"Mr.","Mrs.","Ms."};
    ArrayAdapter <String> adapter;
    Spinner spinner;
    String record = "";
    EditText txtfirst;
    EditText txtsecond;
    EditText fullname;
    String livetext;
    String firstname;
    String lastname;
    String fullresult;
    String livetext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        spinner = findViewById(R.id.spntitle);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tittle);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        record = "Mr.";
                        break;
                    case 1:
                        record = "Mrs.";
                        break;
                    case 2:
                        record = "Ms.";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        txtfirst = findViewById(R.id.regfirstname);
        txtsecond = findViewById(R.id.reglastname);
        fullname = findViewById(R.id.txtfullname);
        fullname.setEnabled(false);
        txtfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullname.setText(record);
            }
        });
        txtfirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                livetext = record;
                firstname = txtfirst.getText().toString();
                fullresult = livetext + " " + firstname;
                fullname.setText(fullresult);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullresult = record + " " + firstname;
                fullname.setText(fullresult);
            }
        });
        txtsecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                livetext = fullresult;
                lastname = txtsecond.getText().toString();
                livetext2 = livetext + " " + lastname;
                fullname.setText(livetext2);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final Button next = findViewById(R.id.btnnext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent security = new Intent(RegisterActivity.this, SecurityActivity.class);
                startActivity((security));
            }
        });
    }
}
