package zhou.com.demo.ui.activity.accept;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.base.Constant;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.ui.adapter.SelectAdapter;
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
    private List<QZDWKSList.DatasBean> maleGroups = new ArrayList<>();
    private List<List<KSUserBean>> maleChilds = new ArrayList<>();
    private SelectAdapter selectAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_select;
    }

    @Override
    public void configView() {
        elvListView.setAdapter(selectAdapter);
        dialog.show();
        mPresenter.attachView(this);
        mPresenter.Get_QZDWKS_List();
    }

    @Override
    public void initDatas() {
        selectAdapter = new SelectAdapter(this, maleGroups, maleChilds);
        selectAdapter.setItemClickListener(new ClickListener());
    }

    class ClickListener implements OnRvItemClickListener<QZDWKSList.DatasBean> {

        @Override
        public void onItemClick(View view, int position, QZDWKSList.DatasBean data) {
            Log.d(TAG, "onItemClick: 111111111111111");
            String ActiveCode = App.getInstance().getLoginBean().getActiveCode();
            String jsonRequest = "{\"ActiveCode\":\"" + ActiveCode + "\",\"QZH\":\"" + data.getQZH() + "\",\"KSCode\":\"" + data.getKSCode() + "\",\"UserRightType\":\"SW\"}";
            mPresenter.Get_KSUser(jsonRequest);
        }
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
        maleGroups.clear();
        for (int i=0;i<qzdwksList.size();i++){
            maleGroups.add(new QZDWKSList.DatasBean(qzdwksList.get(i).getQZH(),qzdwksList.get(i).getKSCode(),qzdwksList.get(i).getKSName()));
        }
        selectAdapter.notifyDataSetChanged();
    }

    @Override
    public String setActiveCode() {
        return "{\"ActiveCode\":\""+App.getInstance().getLoginBean().getActiveCode()+"\"}";
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
}
