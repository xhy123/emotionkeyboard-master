package com.example.liusw.copylibrary.interfaces;

import android.view.ViewGroup;

/**
 * Created by liusw on 2016/9/1.
 */
public interface EmoticonDisplayListener<T>
{
    void onBindView(int position, ViewGroup parent,T t,boolean isDelBtn);
}
