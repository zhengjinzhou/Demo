package zhou.com.demo.ui.fragment.accept;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.LinkedHashSet;
import java.util.List;

import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseRVFragment;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.ui.activity.accept.AcceptInfoActivity;
import zhou.com.demo.ui.adapter.accept.AcceptAdapter;
import zhou.com.demo.ui.contract.AcceptContract;
import zhou.com.demo.ui.presenter.AcceptPresenter;
import zhou.com.demo.ui.presenter.LoginPresenter;
import zhou.com.demo.view.recyclerview.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/2/27.
 * 待办
 */

public class AcceptFragment extends BaseRVFragment<ListOfBLState.DatasBean> implements AcceptContract.View,RecyclerArrayAdapter.OnItemLongClickListener {

    private static final String TAG = "AcceptFragment";
    private AcceptPresenter mPresenter = new AcceptPresenter(this);

    public final static String BUNDLE_ID = "_id";
    private String id;
    public static AcceptFragment newInstance(String id) {
        AcceptFragment fragment = new AcceptFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }
    List<ListOfBLState.DatasBean> mDatas;


    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }


    @Override
    public void GetSWHandleListOfBLStateComplete(List<ListOfBLState.DatasBean> list) {
        mDatas = list;
        Log.d(TAG, "GetSWHandleListOfBLStateComplete: "+list.toString());
        mAdapter.clear();
        mAdapter.addAll(list);
    }

    @Override
    public String setAction() {
        return "{\"ActiveCode\":\""+App.getInstance().getLoginBean().getActiveCode()+"\",\"BLState\":\""+id+"\"}";
    }

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void initDatas() {
        id = getArguments().getString(BUNDLE_ID);
    }

    @Override
    public void configViews() {
        Log.d(TAG, "configViews: ");
        initAdapter(AcceptAdapter.class, true, false);
        mAdapter.setOnItemLongClickListener(this);
        mPresenter.GetSWHandleListOfBLState();
    }

    @Override
    public void onItemClick(int position) {
        //这里需要存在的是app里面，要不然要通过两次传送很麻烦
        Log.d(TAG, "onItemClick: "+mDatas.get(position));
        App.getInstance().setDatasBean(mDatas.get(position));
        startToActivity(AcceptInfoActivity.class);
    }

    @Override
    public void onRefresh() {
        mPresenter.GetSWHandleListOfBLState();
        super.onRefresh();
    }

    /**
     * [此方法不可再重写]
     */
    @Override
    public void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public boolean onItemLongClick(int position) {
        Log.d(TAG, "onItemLongClick: "+position);
        return false;
    }
}
