package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SecurityActivity extends AppCompatActivity {

    String question[] = {"What is your father's name?","What is your mother's name?","What kind of fruit do you like?"};
    String question1[] = {"What is your mother's name?","What kind of fruit do you like?"};
    ArrayAdapter<String> secadapter;
    ArrayAdapter<String> secadapter1;
    Spinner questionspn1;
    Spinner questionspn2;
    String questiontext = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        questionspn1 = findViewById(R.id.spnquestion1);
        secadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, question);
        questionspn1.setAdapter(secadapter);
        questionspn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        questiontext = "What is your father's name?";
                        break;
                    case 1:
                        questiontext = "What is your mother's name?";
                        break;
                    case 2:
                        questiontext = "What kind of fruit do you like?";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        questionspn2 = findViewById(R.id.spnquestion2);
        secadapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, question1);
        questionspn2.setAdapter(secadapter);
        if(questionspn1.getAdapter().getItem(0) == questionspn2.getAdapter().getItem(0)){
            questionspn2.setAdapter(secadapter1);
            questionspn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            questiontext = "What is your mother's name?";
                            break;
                        case 1:
                            questiontext = "What kind of fruit do you like?";
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else if (questionspn2.getAdapter().getItem(0) != questionspn1.getAdapter().getItem(0)) {
            questionspn2.setAdapter(secadapter);
        }

    }
}
