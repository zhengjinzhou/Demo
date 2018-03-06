package zhou.com.demo.ui.contract;

import java.util.List;

import zhou.com.demo.base.BaseContract;
import zhou.com.demo.bean.GetSWMainBean;
import zhou.com.demo.bean.GetSWQWListBean;

/**
 * Created by zhou on 2018/3/6.
 */

public interface RecordManagerContract {
    interface View extends BaseContract.BaseView {
        void showGetSWMain(GetSWMainBean list);
        String setAction();

        void showGetSWQWList(GetSWQWListBean bean);
        String setActionMain();//这里参数改了
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void GetSWMain();
        String getAction();

        void GetSWQWList();
        String getActionMain();//这里参数改了
    }
}
