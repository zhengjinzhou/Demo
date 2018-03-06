package zhou.com.demo.ui.presenter;

import android.util.Log;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.demo.api.Api;
import zhou.com.demo.base.RxPresenter;
import zhou.com.demo.bean.GetSWMainBean;
import zhou.com.demo.bean.GetSWQWListBean;
import zhou.com.demo.ui.contract.RecordManagerContract;
import zhou.com.demo.ui.contract.SelectContract;
import zhou.com.demo.ui.fragment.accept.AcceptFragment;
import zhou.com.demo.ui.fragment.accept.record.RecordManagerFragment;

/**
 * Created by zhou on 2018/3/6.
 */

public class RecordManagerPresenter extends RxPresenter<RecordManagerContract.View> implements RecordManagerContract.Presenter<RecordManagerContract.View> {

    Api api;
    RecordManagerFragment recordManagerFragment;
    OkHttpClient okHttpClient = new OkHttpClient();

    public RecordManagerPresenter(RecordManagerFragment recordManagerFragment) {
        this.recordManagerFragment = recordManagerFragment;
        this.api = new Api(okHttpClient);
    }

    @Override
    public void GetSWMain() {
        Subscription rxSubscription = Api.getInstance(okHttpClient).GetSWMain("GetSWMain", getAction())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetSWMainBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        Log.d("查看单件收文", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(GetSWMainBean getSWMainBean) {
                        Log.d("", "onNext: "+getSWMainBean.toString());
                        mView.showGetSWMain(getSWMainBean);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public String getAction() {
        return mView.setAction();
    }

    @Override
    public void GetSWQWList() {
        Subscription rxSubscription = Api.getInstance(okHttpClient).GetSWQWList("GetSWQWList", getActionMain())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetSWQWListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        Log.d("GetSWQWList", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(GetSWQWListBean getSWQWListBean) {
                        Log.d("", "onNext: "+getSWQWListBean.toString());
                        mView.showGetSWQWList(getSWQWListBean);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public String getActionMain() {
        return mView.setActionMain();
    }
}
