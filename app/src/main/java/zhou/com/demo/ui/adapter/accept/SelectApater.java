package zhou.com.demo.ui.adapter.accept;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

import zhou.com.demo.R;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.view.recyclerview.BaseViewHolder;
import zhou.com.demo.view.recyclerview.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/3/2.
 */

public class SelectApater extends EasyRVAdapter<QZDWKSList.DatasBean> {

    private OnRvItemClickListener itemClickListener;
    public SelectApater(Context context, List<QZDWKSList.DatasBean> list, OnRvItemClickListener listener) {
        super(context,list,R.layout.recycler_select);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder viewHolder, final int position, final QZDWKSList.DatasBean item) {
        viewHolder.setText(R.id.tvKSName,item.getKSName());
        viewHolder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(viewHolder.getItemView(), position, item);
            }
        });
    }
}
