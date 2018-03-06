package zhou.com.demo.ui.fragment.accept.record;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseFragment;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.ui.activity.accept.SelectActivity;

/**
 * Created by zhou on 2018/2/27.
 * 办理
 */

public class RecordManagerFragment extends BaseFragment {

    private ListOfBLState.DatasBean datasBean;
    @BindView(R.id.SWBH) TextView SWBH;
    @BindView(R.id.LWDW) TextView LWDW;
    @BindView(R.id.Title) TextView Title;
    @BindView(R.id.WH) TextView WH;
    @BindView(R.id.HJ) TextView HJ;
    @BindView(R.id.SendDate) TextView SendDate;
    @BindView(R.id.LastDate) TextView LastDate;
    @BindView(R.id.etOpinions) EditText etOpinions;
    @BindView(R.id.tvManaged) TextView tvManaged;
    @BindView(R.id.tvManaging) TextView tvManaging;
    @BindView(R.id.ivManaging) ImageView ivManaging;
    @BindView(R.id.ivManaged) ImageView ivManaged;
    @BindView(R.id.llRecycler) LinearLayout llRecycler;

    private List<String> mDatas;
    private OptionsPickerView pvOptions;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_manager_record;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initDatas() {
        datasBean = App.getInstance().getDatasBean();
        mDatas = Arrays.asList(getResources().getStringArray(R.array.record_opinion));
        initOptionPicker();
    }

    @Override
    public void configViews() {
        llRecycler.setVisibility(View.GONE);

        SWBH.setText(datasBean.getSWBH());
        LWDW.setText(datasBean.getLWDW());
        Title.setText(datasBean.getTitle());
        WH.setText(datasBean.getWH());
        HJ.setText(datasBean.getHJ());
        SendDate.setText(datasBean.getSendDate());
        LastDate.setText(datasBean.getLastDate());
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

    private void initOptionPicker() {
        pvOptions = new OptionsPickerView.Builder(getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                etOpinions.setText(mDatas.get(options1));
            }
        }).build();
        pvOptions.setPicker(mDatas);
    }
}
