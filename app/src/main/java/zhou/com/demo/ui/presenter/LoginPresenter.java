package zhou.com.demo.ui.presenter;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.demo.api.Api;
import zhou.com.demo.base.App;
import zhou.com.demo.base.Constant;
import zhou.com.demo.base.RxPresenter;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.ui.activity.LoginActivity;
import zhou.com.demo.ui.contract.LoginContract;

/**
 * Created by zhou on 2018/2/26.
 * 在这里进行两次请求
 * 一次：登录请求
 * 二次：获取登录之后的ActiveCode进行获取科室列表
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View>{

    Api api;
    LoginActivity loginActivity;
    OkHttpClient okHttpClient = new OkHttpClient();

    public LoginPresenter(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        this.api = new Api(okHttpClient);
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        Subscription rxSubscription = Api.getInstance(okHttpClient).login("Login",getBody())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        Log.d("", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.d("", "onNext: "+loginBean.toString());
                        if (loginBean != null && mView != null) {
                            mView.loginComplete(loginBean);
                            App.getInstance().setLoginBean(loginBean);
                        }
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public String getBody() {
        return mView.setBody();
    }

}
