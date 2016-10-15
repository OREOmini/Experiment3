package com.example.wangyunwen.lab3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    List<Contact> list = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        putData();

        final ListView contact_list = (ListView) findViewById(R.id.contact_list);
        final MyAdapter myAdapter = new MyAdapter(this, list);
        contact_list.setAdapter(myAdapter);

        contact_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, info.class);
                Bundle bundle = new Bundle();
                Contact c = list.get(position);
                bundle.putString("name", c.getName());
                bundle.putString("phoneNum", c.getPhoneNum());
                bundle.putString("location", c.getLocation());
                bundle.putString("category", c.getCategory());
                bundle.putString("bg", "#"+c.getBackgroundColor());
                intent.putExtras(bundle);
                //bundle.putSerializable("contact", list.get(position));
                //intent.putExtra("id", id);
                //startActivityForResult(intent, REQUEST_CODE);
                startActivity(intent);
            }
        });

        contact_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Context context = view.getContext();
                Dialog delete_contact = new AlertDialog.Builder(context).
                        setTitle("删除联系人").
                        setMessage("确定删除联系人"+list.get(position).getName()).
                        setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                Context context = getApplicationContext();
                                //View rootView = LayoutInflater.from(context).inflate(R.layout.activity_info,null);
                                MyAdapter myAdapter1 = new MyAdapter(context, list);
                                contact_list.setAdapter(myAdapter1);
                            }
                        }).
                        create();
                delete_contact.show();
                return true;
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
