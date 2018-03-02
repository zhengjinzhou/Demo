package zhou.com.demo.ui.activity.accept;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.ui.adapter.accept.AcceptAdapter;
import zhou.com.demo.ui.adapter.accept.SelectApater;
import zhou.com.demo.ui.contract.LoginContract;
import zhou.com.demo.ui.contract.SelectContract;
import zhou.com.demo.ui.presenter.LoginPresenter;
import zhou.com.demo.ui.presenter.SelectPresenter;
import zhou.com.demo.view.SupportDividerItemDecoration;

/**
 * 选择经办人
 */
public class SelectActivity extends BaseActivity implements SelectContract.View, OnRvItemClickListener<QZDWKSList.DatasBean> {

    private static final String TAG = "SelectActivity";
    private SelectPresenter mPresenter = new SelectPresenter(this);
    private SelectApater mHotReviewAdapter;
    private List<QZDWKSList.DatasBean> mHotReviewList = new ArrayList<>();
    @BindView(R.id.recyclerView) RecyclerView mRvHotReview;
    @BindView(R.id.iv) ImageView iv;
    boolean isClick = false;


    @Override
    public int getLayout() {
        return R.layout.activity_select;
    }

    @Override
    public void configView() {
        mRvHotReview.setHasFixedSize(true);
        mRvHotReview.setLayoutManager(new LinearLayoutManager(this));
        mHotReviewAdapter = new SelectApater(mContext, mHotReviewList, this);
        mRvHotReview.setAdapter(mHotReviewAdapter);

        mPresenter.attachView(this);
        mPresenter.Get_QZDWKS_List();

        iv.setBackground(getResources().getDrawable(R.drawable.next));
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initToolBar() {

    }

    @OnClick({R.id.rlWanve,R.id.tvSelect,R.id.tvClear,R.id.btSure,R.id.btCancel}) void onClick(View view){
        switch (view.getId()){
            case R.id.rlWanve:
                if (!isClick){
                    mRvHotReview.setVisibility(View.GONE);
                    iv.setBackground(getResources().getDrawable(R.drawable.bottom));
                    isClick = true;
                }else {
                    mRvHotReview.setVisibility(View.VISIBLE);
                    iv.setBackground(getResources().getDrawable(R.drawable.next));
                    isClick = false;
                }
                break;
            case R.id.tvSelect:
                break;
            case R.id.tvClear:
                break;
            case R.id.btSure:
                break;
            case R.id.btCancel:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onItemClick(View view, int position, QZDWKSList.DatasBean data) {
        String jsonRequest = "{\"ActiveCode\":\"xxx\",\"QZH\":\"\",\"KSCode\":\"\",\"UserRightType\":\"\"}";
        Log.d(TAG, "onItemClick: "+data.getKSCode());
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }


    @Override
    public void ShowQZDWKS_ListComplete(List<QZDWKSList.DatasBean> qzdwksList) {
        mHotReviewList.clear();
        mHotReviewList.addAll(qzdwksList);
        mHotReviewAdapter.notifyDataSetChanged();
    }

    @Override
    public String setActiveCode() {
        return "{\"ActiveCode\":\""+App.getInstance().getLoginBean().getActiveCode()+"\"}";
    }

    @Override
    public void showKSUserComplete(List<KSUserBean> ksUserBeans) {

    }
}
