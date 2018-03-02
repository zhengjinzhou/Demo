package zhou.com.demo.ui.contract;

import java.util.List;

import zhou.com.demo.base.BaseContract;
import zhou.com.demo.bean.ListOfBLState;

/**
 * Created by zhou on 2018/3/1.
 */

public interface AcceptContract {

    interface View extends BaseContract.BaseView {
        void GetSWHandleListOfBLStateComplete(List<ListOfBLState.DatasBean> list);
        String setAction();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void GetSWHandleListOfBLState();
        String getAction();
    }
}
