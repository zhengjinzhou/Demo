package zhou.com.demo.ui.presenter;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.demo.api.Api;
import zhou.com.demo.base.RxPresenter;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.ui.activity.LoginActivity;
import zhou.com.demo.ui.activity.accept.SelectActivity;
import zhou.com.demo.ui.contract.LoginContract;
import zhou.com.demo.ui.contract.SelectContract;

/**
 * Created by zhou on 2018/3/2.
 */

public class SelectPresenter extends RxPresenter<SelectContract.View> implements SelectContract.Presenter<SelectContract.View>{

    Api api;
    SelectActivity loginActivity;
    OkHttpClient okHttpClient = new OkHttpClient();

    public SelectPresenter(SelectActivity loginActivity){
        this.loginActivity = loginActivity;
        this.api = new Api(okHttpClient);
    }
    /**
     * 科室列表
     */
    @Override
    public void Get_QZDWKS_List() {
        Subscription rxSubscription = Api.getInstance(okHttpClient).QZDWKS("Get_QZDWKS_List",getActiveCode())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<QZDWKSList>() {
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
                    public void onNext(QZDWKSList qzdwksList) {
                        Log.d("", "onNext: "+qzdwksList.toString());
                        List<QZDWKSList.DatasBean> datas = qzdwksList.getDatas();
                        if (qzdwksList != null && mView != null) {
                            mView.ShowQZDWKS_ListComplete(datas);
                        }
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public String getActiveCode() {
        return mView.setActiveCode();
    }

    @Override
    public void Get_KSUser() {

    }
}
