package com.example.liusw.demo;

import java.io.Serializable;

/**
 * Created by liusw on 2016/9/1.
 */
public class MyDemo implements Serializable
{
    private String name;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
