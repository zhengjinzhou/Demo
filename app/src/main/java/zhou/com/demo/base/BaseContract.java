package zhou.com.demo.base;

/**
 * Created by zhou on 2018/2/26.
 */

public interface BaseContract {
    interface BasePresenter<T>{
        void attachView(T view);

        void detachView();
    }

    interface BaseView{
        void showError();

        void complete();
    }
}
