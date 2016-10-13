package com.example.wangyunwen.lab3;

/**
 * Created by wangyunwen on 16/10/13.
 */
public class Contact {
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

    String getName() {
        return name;
    }
    String getPhoneNum() {
        return phoneNum;
    }
    String getCategory() {
        return category;
    }
    String getLocation() {
        return location;
    }
    String getBackgroundColor() {
        return backgroundColor;
    }
}
