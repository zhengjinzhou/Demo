package zhou.com.demo.base;

import android.app.Application;
import android.content.Context;

import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.utils.AppUtils;
import zhou.com.demo.utils.SharedPreferencesUtil;

/**
 * Created by zhou on 2018/2/26.
 *
 */

public class App extends Application {
    public static App app;
    private LoginBean loginBean;
    private ListOfBLState.DatasBean datasBean;//用于传参

    public ListOfBLState.DatasBean getDatasBean() {
        return datasBean;
    }

    public void setDatasBean(ListOfBLState.DatasBean datasBean) {
        this.datasBean = datasBean;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppUtils.init(this);
        initPrefs();
    }

    public static App getInstance(){
        return app;
    }

    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }
}
