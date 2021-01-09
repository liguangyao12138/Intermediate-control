package com.example.myapplication.otherLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class OtherLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "OtherLayoutActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_layout);

        findViewById(R.id.btn_relativeLayoutView).setOnClickListener(this);
        findViewById(R.id.btn_frameLayoutView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_relativeLayoutView){
            Intent intent = new Intent(this,RelativeLayoutActivity.class);
            startActivity(intent);
            Log.i(TAG,"v.getId() = R.id.btn_relativeLayoutView");

        }else if(v.getId()==R.id.btn_frameLayoutView){
            Intent intent = new Intent(this,FrameLayoutActivity.class);
            startActivity(intent);
            Log.i(TAG,"v.getId()= R.id.btn_frameLayoutView");
        }
    }
}