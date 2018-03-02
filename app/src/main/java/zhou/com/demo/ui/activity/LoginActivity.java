package zhou.com.demo.ui.activity;


import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.bean.BaseBean;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.ui.contract.LoginContract;
import zhou.com.demo.ui.presenter.LoginPresenter;
import zhou.com.demo.utils.ToastUtils;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_password) EditText et_password;
    private String ActiviteCode;
    private LoginPresenter mPresenter = new LoginPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        et_username.setText("hhl");
        et_password.setText("1234qwer");
    }

    @Override
    public void initDatas() {
        //Android5.0以上状态栏颜色修改
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @OnClick({R.id.iv_clear, R.id.bt_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_clear:
                break;
            case R.id.bt_login:
                dialog.show();
                mPresenter.login();
                break;
        }
    }

    @Override
    public void loginComplete(LoginBean loginBean) {
        if (loginBean.isIsSuccess()) {
            startToActivity(MainActivity.class);
            ActiviteCode = loginBean.getActiveCode();
            finish();
        } else {
            ToastUtils.showToast(loginBean.getErrorManage());
        }
        dialog.dismiss();
    }

    @Override
    public String setBody() {
        String UserID = et_username.getText().toString();
        String PSW = et_password.getText().toString();
        if (TextUtils.isEmpty(UserID)) {
            ToastUtils.showToast(getString(R.string.username));
            return null;
        }
        if (TextUtils.isEmpty(PSW)) {
            ToastUtils.showToast(getString(R.string.psd));
            return null;
        }
        BaseBean bean = new BaseBean(UserID, PSW);
        return bean.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
