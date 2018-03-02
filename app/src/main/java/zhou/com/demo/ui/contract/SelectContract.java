package zhou.com.demo.ui.contract;

import java.util.List;

import zhou.com.demo.base.BaseContract;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.LoginBean;
import zhou.com.demo.bean.QZDWKSList;

/**
 * Created by zhou on 2018/3/2.
 */

public interface SelectContract {
    interface View extends BaseContract.BaseView{
        void ShowQZDWKS_ListComplete(List<QZDWKSList.DatasBean> qzdwksList);
        String setActiveCode();

        void showKSUserComplete(List<KSUserBean> ksUserBeans);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void Get_QZDWKS_List();
        String getActiveCode();

        void Get_KSUser();
    }
}
