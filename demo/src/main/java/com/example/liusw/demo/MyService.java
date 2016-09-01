package com.example.liusw.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by liusw on 2016/9/1.
 */
public class MyService extends Service
{
    private static final String TAG = "BindService";
    private MyBinder myBinder = new MyBinder();
    public void MyMethod(){
        Log.i(TAG, "BindService-->MyMethod()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "BindService-->onBind()");
        MyDemo demo = (MyDemo) intent.getSerializableExtra("name");
        Toast.makeText(this,"uuuuuuuu"+demo.toString(),Toast.LENGTH_LONG).show();
        return myBinder;
    }

    public class MyBinder extends Binder
    {

        public MyService getService1(){
            return MyService.this;
        }
    }



    @Override
    public void onCreate() {
        Log.i(TAG, "BindService-->onCreate()");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "BindService-->onStart()");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "BindService-->onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "BindService-->onUnbind()");
        return super.onUnbind(intent);
    }
}
