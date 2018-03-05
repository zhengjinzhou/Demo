package zhou.com.demo.ui.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.demo.api.Api;
import zhou.com.demo.base.Constant;
import zhou.com.demo.base.RxPresenter;
import zhou.com.demo.bean.KSUserBean;
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
    SelectActivity selectActivity;
    OkHttpClient okHttpClient = new OkHttpClient();

    public SelectPresenter(SelectActivity selectActivity){
        this.selectActivity = selectActivity;
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
                        Log.d("科室列表", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(QZDWKSList qzdwksList) {
                        Log.d("科室列表", "onNext: "+qzdwksList.toString());
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

    /**
     * 科室人员列表
     * @param jsonRequest
     */
    @Override
    public void Get_KSUser(String jsonRequest) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("Action", "Get_KSUser")
                .add("jsonRequest", jsonRequest)
                .build();
        Request request = new Request.Builder().url(Constant.API_BASE_URL + "DMS_FileMan_Handler.ashx").post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("科室人员列表", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                List<KSUserBean> list = gson.fromJson(string, new TypeToken<List<KSUserBean>>() {}.getType());
                Log.d("科室人员列表", "onResponse: " + string);
                List<KSUserBean> mDatas = new ArrayList<>();
                for (int i=0;i<list.size();i++){
                    mDatas.add(new KSUserBean(list.get(i).getUserName()));
                }
                mView.showKSUserComplete(mDatas);
            }
        });
    }
}
