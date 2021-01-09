package com.example.myapplication.otherLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.util.Utils;


public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //普通RelativeLayout页面
        //setContentView(R.layout.activity_relative_layout);

        //动态添加视图
        setContentView(R.layout.activity_relative_code_layout);

        bindView();
    }

    //初始化控件
    private void bindView() {

        findViewById(R.id.btn_relative_add_left).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_above).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_right).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_below).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_center).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_parent_left).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_parent_top).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_parent_right).setOnClickListener(this);
        findViewById(R.id.btn_relative_add_parent_bottom).setOnClickListener(this);

        rl_content = findViewById(R.id.rl_content);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_relative_add_left){
            addNewView(RelativeLayout.LEFT_OF,RelativeLayout.ALIGN_TOP,v.getId());
        }else if(v.getId()==R.id.btn_relative_add_above){
            addNewView(RelativeLayout.ABOVE,RelativeLayout.ALIGN_LEFT,v.getId());
        }else if (v.getId() == R.id.btn_relative_add_right) {
            addNewView(RelativeLayout.RIGHT_OF, RelativeLayout.ALIGN_BOTTOM, v.getId());
        } else if (v.getId() == R.id.btn_relative_add_below) {
            addNewView(RelativeLayout.BELOW, RelativeLayout.ALIGN_PARENT_RIGHT, v.getId());
        } else if (v.getId() == R.id.btn_relative_add_center) {
            addNewView(RelativeLayout.CENTER_IN_PARENT, -1, rl_content.getId());
        } else if (v.getId() == R.id.btn_relative_add_parent_left) {
            addNewView(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.CENTER_VERTICAL, rl_content.getId());
        } else if (v.getId() == R.id.btn_relative_add_parent_top) {
            addNewView(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.CENTER_HORIZONTAL, rl_content.getId());
        } else if (v.getId() == R.id.btn_relative_add_parent_right) {
            addNewView(RelativeLayout.ALIGN_PARENT_RIGHT, -1, rl_content.getId());
        } else if (v.getId() == R.id.btn_relative_add_parent_bottom) {
            addNewView(RelativeLayout.ALIGN_PARENT_BOTTOM, -1, rl_content.getId());
        }

    }

    private void addNewView(int firstAlign, int secondAlign, int referId){

        View v = new View(this);

        v.setBackgroundColor(0xaa66ff66);

        RelativeLayout.LayoutParams rl_params = new RelativeLayout.LayoutParams(Utils.dip2px(this,100),Utils.dip2px(this,100));

        rl_params.addRule(firstAlign,referId);

        if(secondAlign>=0){

            rl_params.addRule(secondAlign,referId);
        }

        v.setLayoutParams(rl_params);

        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rl_content.removeView(v);
                return true;
            }
        });

        rl_content.addView(v);
    }
}