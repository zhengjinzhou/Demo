package zhou.com.demo.ui.fragment.accept.record;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseFragment;
import zhou.com.demo.bean.GetSWMainBean;
import zhou.com.demo.bean.GetSWQWListBean;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.MainBean;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.ui.activity.accept.SelectActivity;
import zhou.com.demo.ui.adapter.MainAdapter;
import zhou.com.demo.ui.adapter.RecordManagerAdapter;
import zhou.com.demo.ui.contract.RecordManagerContract;
import zhou.com.demo.ui.presenter.AcceptPresenter;
import zhou.com.demo.ui.presenter.RecordManagerPresenter;

/**
 * Created by zhou on 2018/2/27.
 * 办理
 */

public class RecordManagerFragment extends BaseFragment implements RecordManagerContract.View, OnRvItemClickListener<GetSWQWListBean.DatasBean> {

    @BindView(R.id.SWBH)
    TextView SWBH;
    @BindView(R.id.LWDW)
    TextView LWDW;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.WH)
    TextView WH;
    @BindView(R.id.HJ)
    TextView HJ;
    @BindView(R.id.SendDate)
    TextView SendDate;
    @BindView(R.id.LastDate)
    TextView LastDate;
    @BindView(R.id.etOpinions)
    EditText etOpinions;
    @BindView(R.id.tvManaged)
    TextView tvManaged;
    @BindView(R.id.tvManaging)
    TextView tvManaging;
    @BindView(R.id.ivManaging)
    ImageView ivManaging;
    @BindView(R.id.ivManaged)
    ImageView ivManaged;
    @BindView(R.id.llRecycler)
    LinearLayout llRecycler;
    @BindView(R.id.llLWZY)
    LinearLayout llLWZY;
    @BindView(R.id.tvLWZY)
    TextView tvLWZY;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private ListOfBLState.DatasBean datasBean;
    private List<String> mDatas;
    private OptionsPickerView pvOptions;
    private static final String TAG = "RecordManagerFragment";
    private RecordManagerAdapter mAdapter;
    private List<GetSWQWListBean.DatasBean> mList = new ArrayList<>();

    private RecordManagerPresenter mPresenter = new RecordManagerPresenter(this);

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_manager_record;
    }

    @Override
    public void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void initDatas() {
        datasBean = App.getInstance().getDatasBean();
        mDatas = Arrays.asList(getResources().getStringArray(R.array.record_opinion));
        initOptionPicker();
    }

    @Override
    public void configViews() {

        mPresenter.GetSWMain();
        mPresenter.GetSWQWList();

        mAdapter = new RecordManagerAdapter(mContext, mList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        SWBH.setText(datasBean.getSWBH());
        LWDW.setText(datasBean.getLWDW());
        Title.setText(datasBean.getTitle());
        WH.setText(datasBean.getWH());
        HJ.setText(datasBean.getHJ());
        SendDate.setText(datasBean.getSendDate());
        LastDate.setText(datasBean.getLastDate());
        etOpinions.setText(datasBean.getYiJian());
    }

    @OnClick({R.id.rlSelect, R.id.btCommon, R.id.rlManaging, R.id.rlManaged})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlManaging://办理中
                tvManaging.setTextColor(getResources().getColor(R.color.bg_accept));
                ivManaged.setVisibility(View.GONE);
                ivManaging.setVisibility(View.VISIBLE);
                tvManaged.setTextColor(getResources().getColor(R.color.bg_color));
                break;
            case R.id.rlManaged://办完
                tvManaging.setTextColor(getResources().getColor(R.color.bg_color));
                tvManaged.setTextColor(getResources().getColor(R.color.managed));
                ivManaging.setVisibility(View.GONE);
                ivManaged.setVisibility(View.VISIBLE);
                break;
            case R.id.rlSelect:
                startToActivity(SelectActivity.class);
                break;
            case R.id.btCommon:
                pvOptions.show();
                break;
            case R.id.tvClear:
                etOpinions.setText("");
                break;
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void showGetSWMain(GetSWMainBean list) {
        Log.d(TAG, "showGetSWMain: " + list.toString());
        GetSWMainBean.DatasBean datas = list.getDatas();

        WH.setText(datas.getWHT() + "〔" + datas.getWHN() + "〕" + datas.getWHS() + "号");
        if (datas.getLWZY().equals("")) {
            llLWZY.setVisibility(View.GONE);
        } else {
            tvLWZY.setText(datas.getLWZY());
        }
    }

    @Override
    public String setAction() {
        return "{\"ActiveCode\":\"" + App.getInstance().getLoginBean().getActiveCode() + "\",\"Main_GUID\":\"" + App.getInstance().getDatasBean().getMGUID() + "\"}";
    }

    @Override
    public void showGetSWQWList(GetSWQWListBean bean) {
        Log.d(TAG, "---------showGetSWQWList: " + bean.toString());
        List<GetSWQWListBean.DatasBean> datas = bean.getDatas();
        if (datas.size() > 0) {
            mList = datas;
            mAdapter.clear();
            mAdapter.addAll(mList);
            mAdapter.notifyDataSetChanged();
        } else {
            llRecycler.setVisibility(View.GONE);
        }
    }

    @Override
    public String setActionMain() {
        return "{\"ActiveCode\":\"" + App.getInstance().getLoginBean().getActiveCode() + "\",\"GUID\":\"" + App.getInstance().getDatasBean().getMGUID() + "\"}";
    }

    private void initOptionPicker() {
        pvOptions = new OptionsPickerView.Builder(getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                etOpinions.setText(mDatas.get(options1));
            }
        }).build();
        pvOptions.setPicker(mDatas);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public void onItemClick(View view, int position, GetSWQWListBean.DatasBean data) {
        Log.d(TAG, "onItemClick: " + position);
    }
}
