package com.example.myapplication.editbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.util.ViewUtil;

public class EditTextActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        EditText et_elevenHide = findViewById(R.id.et_elevenHide);

        et_elevenHide.addTextChangedListener(new HideTextWatcher(et_elevenHide));

        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_password);
        Button btn_login = findViewById(R.id.btn_login);
        et_username.addTextChangedListener(new JumpTextWatcher(et_username,et_password));
        et_password.addTextChangedListener(new JumpTextWatcher(et_password,btn_login));
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_login){
            Toast.makeText(this, "这个登录按钮啥事也没做", Toast.LENGTH_SHORT).show();
        }
    }

    private class HideTextWatcher implements TextWatcher{

        private EditText mView;
        private int mMaxLength;
        private CharSequence mStr;

        public HideTextWatcher(EditText v) {
            super();
            mView = v;

            mMaxLength = ViewUtil.getMaxLength(v);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mStr = s;

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(mStr == null || mStr.length() == 0)
                return;

                if(mStr.length() == 11 && mMaxLength == 11){
                    ViewUtil.hideAllInputMethod(EditTextActivity.this);
                }

        }
    }

    private class JumpTextWatcher implements TextWatcher{

        private EditText mThisView;
        private View mNextView;

        public JumpTextWatcher(EditText mThis, View mNext) {
            super();
            this.mThisView = mThis;
            if(mNext != null){
                mNextView = mNext;
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            String str = s.toString();

            if(str.contains("\r") || str.contains("/n")){
                mThisView.setText(str.replace("\r","").replace("\n",""));
                if(mNextView != null){
                    mNextView.requestFocus();

                    if(mNextView instanceof EditText){
                        EditText et = (EditText) mNextView;


                        et.setSelection(et.getText().length());

//                        Editable editable = et.getText();
//                        Selection.setSelection(editable,editable.length());
                    }
                }
            }


        }
    }
}