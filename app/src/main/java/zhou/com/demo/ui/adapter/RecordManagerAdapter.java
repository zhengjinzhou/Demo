package zhou.com.demo.ui.adapter;

import android.content.Context;
import android.view.View;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

import zhou.com.demo.R;
import zhou.com.demo.bean.BaseBean;
import zhou.com.demo.bean.GetSWQWListBean;
import zhou.com.demo.bean.MainBean;
import zhou.com.demo.commno.OnRvItemClickListener;

/**
 * Created by zhou on 2018/3/6.
 */

public class RecordManagerAdapter extends EasyRVAdapter<GetSWQWListBean.DatasBean> {

    private OnRvItemClickListener itemClickListener;

    public RecordManagerAdapter(Context context, List<GetSWQWListBean.DatasBean> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.recycler_manager_record);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder viewHolder, final int position, final GetSWQWListBean.DatasBean item) {
        viewHolder.setText(R.id.tvName, item.getName());
        viewHolder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(viewHolder.getItemView(), position, item);
            }
        });
    }
}
