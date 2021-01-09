package com.example.myapplication.fitview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class FitViewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_view);

        findViewById(R.id.btn_ft_spinner).setOnClickListener(this);
        findViewById(R.id.btn_ft_simpleAdapter).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //3.3.1 下拉框 Spinner
        if(v.getId() == R.id.btn_ft_spinner){
            Intent intent = new Intent(this , SpinnerActivity.class);
            startActivity(intent);

            //3.3.3 简单适配器 SimpleAdapter
        }else if(v.getId() == R.id.btn_ft_simpleAdapter){
            Intent intent = new Intent(this, SimpleAdapterActivity.class);
            startActivity(intent);
        }

    }
}