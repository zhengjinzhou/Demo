package zhou.com.demo.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zhou.com.demo.base.Constant;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;

/**
 * Created by zhou on 2018/2/26.
 */

public class Api {

    public static Api instance;

    private ApiService service;

    public Api(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new Api(okHttpClient);
        return instance;
    }

    public Observable<LoginBean> login(String action,String jsonRequest) {
        return service.login(action,jsonRequest);
    }

    public Observable<QZDWKSList> QZDWKS(String action,String jsonRequest){
        return service.QZDWKS(action,jsonRequest);
    }

    public Observable<?> getNum(String action, String jsonRequest){
        return service.GetNum(action,jsonRequest);
    }

    public Observable<ListOfBLState> GetSWHandleListOfBLState(String action,String jsonRequest){
        return service.GetSWHandleListOfBLState(action,jsonRequest);
    }

    public Observable<KSUserBean> Get_KSUser(String action,String jsonRequest){
        return service.Get_KSUser(action,jsonRequest);
    }
}
