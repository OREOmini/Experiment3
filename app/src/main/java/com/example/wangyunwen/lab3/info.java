package com.example.wangyunwen.lab3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Context context = getApplicationContext();
        //View rootView = LayoutInflater.from(context).inflate(R.layout.activity_info,null);

        Intent intent = this.getIntent();
        Contact contact = (Contact) intent.getSerializableExtra("contact");

        if (contact == null) Log.d("tag", "contact is null");
        //System.console().printf(contact);

        RelativeLayout head_bar = (RelativeLayout) findViewById(R.id.head_bar);
        //head_bar.setBackground();
        //head_bar.setBackgroundColor(Color.parseColor(contact.getBackgroundColor()));

        TextView name = (TextView) findViewById(R.id.name);
        TextView phoneNum = (TextView) findViewById(R.id.phoneNum);
        TextView category = (TextView) findViewById(R.id.category);
        TextView location = (TextView) findViewById(R.id.location);

//        name.setText(contact.getName());
//        phoneNum.setText(contact.getPhoneNum());
//        category.setText(contact.getCategory());
//        location.setText(contact.getLocation());
    }
}
