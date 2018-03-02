package zhou.com.demo.ui.fragment.accept.record;

import android.view.View;
import android.widget.TextView;

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
    }

    @Override
    public void configViews() {
        SWBH.setText(datasBean.getSWBH());
        LWDW.setText(datasBean.getLWDW());
        Title.setText(datasBean.getTitle());
        WH.setText(datasBean.getWH());
        HJ.setText(datasBean.getHJ());
        SendDate.setText(datasBean.getSendDate());
        LastDate.setText(datasBean.getLastDate());
    }

    @OnClick({R.id.rlSelect}) void onClick(View view){
        switch (view.getId()){
            case R.id.rlSelect:
                startToActivity(SelectActivity.class);
                break;
        }
    }
}
