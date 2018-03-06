package zhou.com.demo.ui.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.demo.api.Api;
import zhou.com.demo.base.RxPresenter;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.ui.contract.AcceptContract;
import zhou.com.demo.ui.fragment.accept.AcceptFragment;

/**
 * Created by zhou on 2018/3/1.
 */

public class AcceptPresenter extends RxPresenter<AcceptContract.View> implements AcceptContract.Presenter<AcceptContract.View> {

    Api api;
    AcceptFragment acceptFragment;
    OkHttpClient okHttpClient = new OkHttpClient();

    public AcceptPresenter(AcceptFragment acceptFragment) {
        this.acceptFragment = acceptFragment;
        this.api = new Api(okHttpClient);
    }

    @Override
    public void GetSWHandleListOfBLState() {
        Log.d("草拟么么", "GetSWHandleListOfBLState: ");
        Subscription rxSubscription = Api.getInstance(okHttpClient).GetSWHandleListOfBLState("GetSWHandleListOfBLState", getAction())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ListOfBLState>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        Log.d("", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(ListOfBLState listOfBLState) {
                        Log.d("", "onNext: " + listOfBLState.toString());
                        List<ListOfBLState.DatasBean> datas = listOfBLState.getDatas();
                        mView.GetSWHandleListOfBLStateComplete(datas);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public String getAction() {
        return mView.setAction();
    }
}
