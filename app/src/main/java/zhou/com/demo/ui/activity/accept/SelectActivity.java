package zhou.com.demo.ui.activity.accept;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
import zhou.com.demo.ui.adapter.accept.SelectAdapter;
import zhou.com.demo.ui.contract.SelectContract;
import zhou.com.demo.ui.presenter.SelectPresenter;
import zhou.com.demo.view.CustomExpandableListView;

/**
 * 选择经办人  清空
 */
public class SelectActivity extends BaseActivity implements SelectContract.View {

    private static final String TAG = "SelectActivity";
    private SelectPresenter mPresenter = new SelectPresenter(this);
    @BindView(R.id.elvListView) CustomExpandableListView elvListView;
    @BindView(R.id.iv) ImageView iv;

    private List<QZDWKSList.DatasBean> maleGroups = new ArrayList<>();
    private List<List<KSUserBean>> maleChilds = new ArrayList<>();
    private SelectAdapter selectAdapter;
    String ActiveCode = App.getInstance().getLoginBean().getActiveCode();
    boolean isWanve = false;

    @Override
    public int getLayout() {
        return R.layout.activity_select;
    }

    @Override
    public void configView() {
        iv.setBackground(getResources().getDrawable(R.drawable.next));
        elvListView.setAdapter(selectAdapter);
        dialog.show();
        mPresenter.attachView(this);
        mPresenter.Get_QZDWKS_List();
    }

    @Override
    public void initDatas() {
        selectAdapter = new SelectAdapter(this, maleGroups, maleChilds);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        dialog.dismiss();
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    public void ShowQZDWKS_ListComplete(List<QZDWKSList.DatasBean> qzdwksList) {
        Log.d(TAG, "ShowQZDWKS_ListComplete: "+qzdwksList.toString());
        maleGroups.clear();
        for (int i=0;i<qzdwksList.size();i++){
            maleGroups.add(new QZDWKSList.DatasBean(qzdwksList.get(i).getQZH(),qzdwksList.get(i).getKSCode(),qzdwksList.get(i).getKSName()));
            String json = "{\"ActiveCode\":\""+ActiveCode+"\",\"QZH\":\""+qzdwksList.get(i).getQZH()+"\",\"KSCode\":\""+qzdwksList.get(i).getKSCode()+"\",\"UserRightType\":\"SW\"}";
            Log.d("jsonRequest", "ShowQZDWKS_ListComplete: "+json);
            mPresenter.Get_KSUser(json);
        }
        selectAdapter.notifyDataSetChanged();
    }

    @Override
    public String setActiveCode() {
        return "{\"ActiveCode\":\""+ActiveCode+"\"}";
    }

    @Override
    public void showKSUserComplete(List<KSUserBean> ksUserBeans) {
        Log.d(TAG, "showKSUserComplete: "+ksUserBeans.toString());
        maleChilds.add(ksUserBeans);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                selectAdapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.rlWanve,R.id.btCancel})void onClick(View view){
        switch (view.getId()){
            case R.id.rlWanve:
                if (!isWanve){
                    iv.setBackground(getResources().getDrawable(R.drawable.bottom));
                    elvListView.setVisibility(View.GONE);
                    isWanve = !isWanve;
                }else {
                    iv.setBackground(getResources().getDrawable(R.drawable.next));
                    elvListView.setVisibility(View.VISIBLE);
                    isWanve = !isWanve;
                }
                break;
            case R.id.btCancel:
                finish();
                break;
        }
    }
}
