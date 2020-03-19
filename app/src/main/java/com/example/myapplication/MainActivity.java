package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.entity.LoginBean;
import com.example.myapplication.presenter.LoginPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final String TAG = "LoginActivity";
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pwd)
    EditText editPwd;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onViewClicked(View view) {
        String name = editName.getText().toString().trim();
        String pwd = editPwd.getText().toString().trim();
        Map<String, String> map = new HashMap<>();
        map.put("phone", name);
        map.put("pwd", pwd);
        switch (view.getId()) {
            case R.id.btn_register:
                p.requestRegister(map);
                break;
            case R.id.btn_login:
                p.requestLogin(map);
                break;
        }
    }

    @Override
    public void success(Object o) {
        if (o instanceof LoginBean){
            LoginBean loginBean= (LoginBean) o;
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void error(Throwable t) {

    }
}
