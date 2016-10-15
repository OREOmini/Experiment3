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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class info extends AppCompatActivity {
    private boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        clicked = false;
        final Intent intent = this.getIntent();
        Bundle bundle = (Bundle) intent.getExtras();

        RelativeLayout head_bar = (RelativeLayout) findViewById(R.id.head_bar);
        TextView name = (TextView) findViewById(R.id.name);
        TextView phoneNum = (TextView) findViewById(R.id.phoneNum);
        TextView category = (TextView) findViewById(R.id.category);
        TextView location = (TextView) findViewById(R.id.location);

        name.setText(bundle.getString("name"));
        phoneNum.setText(bundle.getString("phoneNum"));
        category.setText(bundle.getString("category"));
        location.setText(bundle.getString("location"));
        head_bar.setBackgroundColor(Color.parseColor(bundle.getString("bg")));

        final ImageButton star = (ImageButton) findViewById(R.id.star);
        ImageButton back = (ImageButton) findViewById(R.id.back);

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!clicked) {
                    clicked = true;
                    star.setImageResource(R.drawable.full_star);
                } else {
                    clicked = false;
                    star.setImageResource(R.drawable.empty_star);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ListView info_list = (ListView) findViewById(R.id.info_list);
        List<Map<String, Object>> data = new ArrayList<>();
        String[] info_string = new String[]{"编辑联系人","分享联系人", "加入黑名单", "删除联系人"};
        for(int i = 0; i < 4; i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("text2",info_string[i]);
            data.add(temp);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.contact_item,
                new String[] {"text2"}, new int[]{R.id.text2});
        info_list.setAdapter(simpleAdapter);

    }
}
