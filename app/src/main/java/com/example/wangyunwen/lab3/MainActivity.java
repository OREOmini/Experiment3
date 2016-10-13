package com.example.wangyunwen.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> list = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        putData();

        ListView contact_list = (ListView) findViewById(R.id.contact_list);
        MyAdapter myAdapter = new MyAdapter(this, list);
        contact_list.setAdapter(myAdapter);

        contact_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, info.class);
            }
        });

        contact_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    private void putData() {

        list.add(new Contact("Aaron","17715523654","手机","江苏苏州电信","BB4C3B"));
        list.add(new Contact("Elvis","18825653224","手机","广东揭阳移动","c48d30"));
        list.add(new Contact("David","15052116654","手机","江苏无锡移动","4469b0"));
        list.add(new Contact("Edwin","18854211875","手机","山东青岛移动","20A17B"));
        list.add(new Contact("Frank","13955188541","手机","安徽合肥移动","BB4C3B"));
        list.add(new Contact("Joshua","13621574410","手机","江苏苏州移动","c48d30"));
        list.add(new Contact("Ivan","15684122771","手机","山东烟台联通","4469b0"));
        list.add(new Contact("Mark","17765213579","手机","广东珠海电信","20A17B"));
        list.add(new Contact("Joseph","13315466578","手机","河北石家庄电信","BB4C3B"));
        list.add(new Contact("Phoebe","17895466428","手机","山东东营移动","c48d30"));
    }
}
