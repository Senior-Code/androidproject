package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private EditText phonenumber;
    private RadioButton takeout;
    private RadioButton eatin;
    private CheckBox pepperoni;
    private CheckBox mushroom;
    private RatingBar ratingbar;
    private Button btnorder;
    private TextView result;
    private Button showresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showresult = (Button) findViewById(R.id.btnresult);
        phonenumber = (EditText) findViewById(R.id.txtphone);
        pepperoni = (CheckBox) findViewById(R.id.checkpepperoni);
        mushroom = (CheckBox) findViewById(R.id.checkmushroom);
        eatin = (RadioButton) findViewById(R.id.radioeatin);
        takeout = (RadioButton) findViewById(R.id.radiotakeout);
        ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        btnorder = (Button) findViewById(R.id.btnorder);
        result = (TextView) findViewById(R.id.txtresult);

        showresult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String order = phonenumber.getText().toString();
                if (order.isEmpty()) {
                    order = "";
                    result.setText("");
                } else {
                    order = "PhoneNumber: " + order + "\n";
                    result.setText(order);
                }
                if (pepperoni.isChecked()) {
                    String pep = pepperoni.getText().toString();
                    order = order + "Topping: \n" + pep + "\n";
                    result.setText(order);
                }
                if (mushroom.isChecked()) {
                    String mush = mushroom.getText().toString();
                    order = order + mush + "\n";
                    result.setText(order);
                }
                if (eatin.isChecked()) {
                    String eat = eatin.getText().toString();
                    order = order + "Delivery Method: \n" + eat + "\n";
                    result.setText(order);
                } else if (takeout.isChecked()) {
                    String take = takeout.getText().toString();
                    order = order + take + "\n";
                    result.setText(order);
                }
                float rate = ratingbar.getRating();
                if (rate > 0) {
                    order = order + "Rating: " + rate;
                    result.setText(order);
                }
            }
        });

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String order = phonenumber.getText().toString();
                if (order.isEmpty()) {
                    order = "";
                    result.setText("");
                } else {
                    order = "PhoneNumber: " + order + "\n";
                    result.setText(order);
                }
                if (pepperoni.isChecked()) {
                    String pep = pepperoni.getText().toString();
                    order = order + "Topping: \n" + pep + "\n";
                    result.setText(order);
                }
                if (mushroom.isChecked()) {
                    String mush = mushroom.getText().toString();
                    order = order + mush + "\n";
                    result.setText(order);
                }
                if (eatin.isChecked()) {
                    String eat = eatin.getText().toString();
                    order = order + "Delivery Method: \n" + eat + "\n";
                    result.setText(order);
                } else if (takeout.isChecked()) {
                    String take = takeout.getText().toString();
                    order = order + take + "\n";
                    result.setText(order);
                }
                float rate = ratingbar.getRating();
                if (rate > 0) {
                    order = order + "Rating: " + rate;
                    result.setText(order);
                }
                String getresult = result.getText().toString();
                Intent intent = new Intent(Main2Activity.this, ResultActivity.class);
                intent.putExtra("ExtraText", getresult);
                startActivity(intent);
            }
        });
    }
}
