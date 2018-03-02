package zhou.com.demo.ui.adapter.accept;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;

import zhou.com.demo.R;
import zhou.com.demo.bean.ListOfBLState;
import zhou.com.demo.view.recyclerview.BaseViewHolder;
import zhou.com.demo.view.recyclerview.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/3/1.
 */

public class AcceptAdapter extends RecyclerArrayAdapter<ListOfBLState.DatasBean> {

    public AcceptAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<ListOfBLState.DatasBean>(parent, R.layout.item_accept) {
            @SuppressLint("ResourceAsColor")
            @Override
            public void setData(ListOfBLState.DatasBean item) {
                super.setData(item);

                holder.setText(R.id.tvTitle, item.getLWDW());
                holder.setText(R.id.tvContent, item.getTitle());
                holder.setText(R.id.tvTime, item.getSendDate());
                holder.setText(R.id.tvName, item.getWhoGiveName());
                holder.setText(R.id.tvRead, item.getBLSort());
                holder.setText(R.id.tvCommon, item.getHJ());
                if (item.getBLSort().equals("拟办"))
                    holder.getView(R.id.tvRead).setBackgroundResource(R.drawable.ic_accept_common22);
                if (item.getBLSort().equals("主办"))
                    holder.getView(R.id.tvRead).setBackgroundResource(R.drawable.ic_accept_common222);
                if (item.getBLSort().equals("批示"))
                    holder.getView(R.id.tvRead).setBackgroundResource(R.drawable.ic_accept_common2222);
            }
        };
    }
}
