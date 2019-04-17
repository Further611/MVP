package com.example.ttthu.demotest.Views;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ttthu.demotest.Models.A_1_Entity;
import com.example.ttthu.demotest.Presenter.A_1_LoginPresenter;
import com.example.ttthu.demotest.R;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("Registered")
public class A_1_LoginActivity extends BaseActivity implements A_1_ILoginViewActivity {

    @BindView(R.id.tv_a_1_errormessage)
    TextView tvErrorMessage;
    @BindView(R.id.edt_a_1_username)
    EditText edtUsername;
    @BindView(R.id.edt_a_1_password)
    EditText edtPassword;
    @BindView(R.id.btn_a_1_login)
    Button btnLogin;

    private A_1_LoginPresenter mPresenter;

    @Override
    protected int getView() {
        return R.layout.activity_a_1_login;
    }

    @Override
    protected void initView() {
        mPresenter = new A_1_LoginPresenter(this);
    }

    @OnClick(R.id.btn_a_1_login)
    void onClick() {
        mPresenter.handleLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void update() {
        A_1_Entity entity = mPresenter.getEntity();
        if (entity.isErrorMessage) {
            tvErrorMessage.setVisibility(View.VISIBLE);
            tvErrorMessage.setText(entity.errorMessage);
        } else {
            tvErrorMessage.setVisibility(View.GONE);
        }
    }

    @Override
    public void showToastMessage(String message) {
        showToast(message);
    }
}
