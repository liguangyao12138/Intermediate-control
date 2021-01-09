package com.example.myapplication.fitview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class SpinnerActivity extends AppCompatActivity {

    private String[] startArray = {"水星","金星","地球","火星","木星","土星"};

    class MySelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(SpinnerActivity.this, "您选择的是"+startArray[position], Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initSpinner();
    }

    private void initSpinner(){

        //声明下拉数组适配器
        ArrayAdapter<String> startAdapter = new ArrayAdapter<String>(this, R.layout.item_select, startArray);

        startAdapter.setDropDownViewResource(R.layout.item_dropdown);

        Spinner sp = findViewById(R.id.spinner_dialog);

        sp.setPrompt("请选择行星");

        sp.setAdapter(startAdapter);

        sp.setSelection(0);

        sp.setOnItemSelectedListener(new MySelectedListener());

    }


}