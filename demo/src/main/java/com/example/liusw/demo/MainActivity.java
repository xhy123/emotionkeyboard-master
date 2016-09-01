package com.example.liusw.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{

    private String tag = "TAG";
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btnStart);

        Button btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动service 方式2
                bindService();

                Toast.makeText(MainActivity.this,"ddjjdjjj",Toast.LENGTH_LONG).show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //停止service 方式2
                unBindService();
                Toast.makeText(MainActivity.this,"uuuuuuuu",Toast.LENGTH_LONG).show();
            }
        });
    }

    //启动service 方式2
    //
    private void bindService(){
        Intent intent = new Intent(MainActivity.this,MyService.class);
        Log.i(tag, "bindService()");
        intent.putExtra("name",new MyDemo());
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private void unBindService(){
        Log.i(tag, "unBindService() start....");
        if(flag == true){
            Log.i(tag, "unBindService() flag");
            unbindService(conn);
            flag = false;
        }
    }

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            Log.i(tag, "onServiceDisconnected()");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            Log.i(tag, "onServiceConnected()");
            MyService.MyBinder binder = (MyService.MyBinder)service;
            MyService bindService = binder.getService1();
            bindService.MyMethod();
            flag = true;
        }
    };
}
