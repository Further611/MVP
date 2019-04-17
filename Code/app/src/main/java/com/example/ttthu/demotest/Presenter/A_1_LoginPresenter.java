package com.example.ttthu.demotest.Presenter;

import com.example.ttthu.demotest.Models.A_1_Entity;
import com.example.ttthu.demotest.Models.A_1_LoginModel;
import com.example.ttthu.demotest.Models.ISendResultCallBack;
import com.example.ttthu.demotest.Views.A_1_ILoginViewActivity;

public class A_1_LoginPresenter implements A_1_ILoginPresenter {
    private A_1_ILoginViewActivity mView;
    private A_1_LoginModel mModel;
    private ISendResultCallBack mLoginCallBack = new ISendResultCallBack() {
        @Override
        public void onSuccess() {
            mView.update();
            mView.showToastMessage("Success");
        }

        @Override
        public void onFailed() {
            mView.update();
        }
    };

    public A_1_LoginPresenter(A_1_ILoginViewActivity mView) {
        this.mView = mView;
        mModel = new A_1_LoginModel();
    }

    @Override
    public void handleLogin(String strUsername, String strPassword) {
        mModel.clearEntity();
        mModel.fetchMemberLogin(mLoginCallBack, strUsername, strPassword);
    }

    public A_1_Entity getEntity() {
        return mModel.getEntity();
    }
}
