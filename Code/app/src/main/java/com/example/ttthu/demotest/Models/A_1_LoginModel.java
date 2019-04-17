package com.example.ttthu.demotest.Models;

import android.text.TextUtils;

public class A_1_LoginModel {
    private A_1_Entity mEntity;

    public A_1_LoginModel() {
        mEntity = new A_1_Entity();
    }

    public void fetchMemberLogin(ISendResultCallBack callBack, String strUserName, String strPassword) {
        if(TextUtils.isEmpty(strUserName) || TextUtils.isEmpty(strPassword)) {
            mEntity.errorMessage = "Please enter in enough information";
            mEntity.isErrorMessage = true;
            callBack.onFailed();
        } else if(strUserName.equals("thutran") && strPassword.equals("123456")) {
            mEntity.isErrorMessage = false;
            callBack.onSuccess();
        } else {
            mEntity.errorMessage = "Username or password is incorrect";
            mEntity.isErrorMessage = true;
            callBack.onFailed();
        }
    }

    public A_1_Entity getEntity() {
        return mEntity;
    }

    public void clearEntity() {
        mEntity.errorMessage = "";
        mEntity.isErrorMessage = false;
    }
}
