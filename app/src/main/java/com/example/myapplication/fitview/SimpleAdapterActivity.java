package com.example.myapplication.fitview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private String[] startArray = {"水星","金星","地球","火星","木星","土星"};

    private int[] iconArray = {R.drawable.shuixing, R.drawable.jinxing, R.drawable.diqiu,
            R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};

    class MySelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(SimpleAdapterActivity.this, "您选择的是"+startArray[position], Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        initSpinner();
    }

    private void initSpinner(){

        List<Map<String , Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < iconArray.length; i++) {
            Map<String , Object> item = new HashMap<String, Object>();

            item.put("icon",iconArray[i]);
            item.put("name",startArray[i]);

            list.add(item);

            SimpleAdapter starAdapter = new SimpleAdapter(this,list,R.layout.item_simple,new String[]{"icon","name"},new int[]{R.id.iv_icon,R.id.tv_name});

            starAdapter.setDropDownViewResource(R.layout.item_simple);

            Spinner sp = findViewById(R.id.sp_icon);

            sp.setPrompt("请选择行星");

            sp.setAdapter(starAdapter);

            sp.setSelection(0);

            sp.setOnItemSelectedListener(new MySelectedListener());
        }

    }
}