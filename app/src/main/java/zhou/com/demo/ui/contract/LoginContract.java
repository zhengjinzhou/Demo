package zhou.com.demo.ui.contract;

import okhttp3.RequestBody;
import zhou.com.demo.base.BaseContract;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;

/**
 * Created by zhou on 2018/2/26.
 */

public interface LoginContract {
    interface View extends BaseContract.BaseView{
        void loginComplete(LoginBean loginBean);
        String setBody();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void login();
        String getBody();

    }
}
