package zhou.com.demo.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.NumBean;
import zhou.com.demo.bean.QZDWKSList;

/**
 * Created by zhou on 2018/2/26.
 */

public interface ApiService {

    /**
     * 登录
     *
     * @return
     */
    @FormUrlEncoded
    @POST("DMS_FileMan_Handler.ashx")
    Observable<LoginBean>
    login(@Field("Action") String action, @Field("jsonRequest") String jsonRequest);

    /**
     * 科室列表
     *
     * @param action
     * @param jsonRequest
     * @return
     */
    @FormUrlEncoded
    @POST("DMS_FileMan_Handler.ashx")
    Observable<QZDWKSList> QZDWKS(@Field("Action") String action,@Field("jsonRequest") String jsonRequest);

    /**
     * 收文待办数量
     * 收文急件待办数量
     * 收文办件待办数量
     * 收文阅件待办数量
     * @param action
     * @param jsonRequest
     * @return
     */
    @FormUrlEncoded
    @POST("SWMan/SWHandler.ashx")
    Observable<?> GetNum(@Field("Action")String action, @Field("jsonRequest") String jsonRequest);

    /**
     * 按收文办理状态
     * 查询文件
     * @param action
     * @param jsonRequest
     * @return
     */
    @FormUrlEncoded
    @POST("SWMan/SWHandler.ashx")
    Observable<ListOfBLState> GetSWHandleListOfBLState(@Field("Action")String action, @Field("jsonRequest") String jsonRequest);

    /**
     * 科室人员列表
     * @param action
     * @param jsonRequest
     * @return
     */
    @FormUrlEncoded
    @POST("DMS_FileMan_Handler.ashx")
    Observable<KSUserBean> Get_KSUser(@Field("Action") String action,@Field("jsonRequest") String jsonRequest);

}
