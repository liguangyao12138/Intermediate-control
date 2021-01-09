package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.fitview.FitViewActivity;
import com.example.myapplication.otherLayout.OtherLayoutActivity;
import com.example.myapplication.specialButtons.SpecialButtonsActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_otherLayout).setOnClickListener(this);
        findViewById(R.id.btn_specialButton).setOnClickListener(this);
        findViewById(R.id.btn_fitViewBasics).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //3.1 其他布局
        if(v.getId() == R.id.btn_otherLayout){
            Intent intent = new Intent(this, OtherLayoutActivity.class);
            startActivity(intent);

            //3.2 特殊按钮
        }else if(v.getId() == R.id.btn_specialButton){
            Intent intent = new Intent(this, SpecialButtonsActivity.class);
            startActivity(intent);

            //3.3 适配视图基础
        }else if(v.getId() == R.id.btn_fitViewBasics){
            Intent intent = new Intent(this, FitViewActivity.class);
            startActivity(intent);
        }
    }
}