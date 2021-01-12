package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViewById(R.id.btn_firstActivity).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"onRestart()");
        super.onRestart();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_firstActivity){
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
    }
}