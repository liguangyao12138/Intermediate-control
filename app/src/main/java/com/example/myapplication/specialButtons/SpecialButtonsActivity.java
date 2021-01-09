package com.example.myapplication.specialButtons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class SpecialButtonsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_buttons);

        findViewById(R.id.btn_specialButton_checkBox).setOnClickListener(this);
        findViewById(R.id.btn_button_switch).setOnClickListener(this);
        findViewById(R.id.btn_button_radioButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //3.2.1  复选框 CheckBox
        if(v.getId() == R.id.btn_specialButton_checkBox){
            Intent intent = new Intent(this,CheckBoxActivity.class);
            startActivity(intent);

            //3.2.2  开关按钮 Switch
        }else if(v.getId() == R.id.btn_button_switch){
            Intent intent = new Intent(this, SwitchActivity.class);
            startActivity(intent);

            //3.2.3 单选按钮 RadioButton
        }else if(v.getId() == R.id.btn_button_radioButton){
            Intent intent = new Intent(this, RadioButtonActivity.class);
            startActivity(intent);
        }
    }
}