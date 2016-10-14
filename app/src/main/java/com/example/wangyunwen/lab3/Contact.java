package com.example.wangyunwen.lab3;

import java.io.Serializable;
/**
 * Created by wangyunwen on 16/10/13.
 */
public class Contact implements Serializable {
    private String name;
    private String phoneNum;
    private String location;
    private String category;
    private String backgroundColor;

    public Contact(String n, String pn, String c, String l, String bc) {
        name = n;
        phoneNum = pn;
        category = c;
        location = l;
        backgroundColor = bc;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }
}
