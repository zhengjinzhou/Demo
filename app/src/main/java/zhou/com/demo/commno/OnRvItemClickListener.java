package zhou.com.demo.commno;

import android.view.View;

/**
 * Created by zhou on 2018/2/26.
 */

public interface OnRvItemClickListener<T> {

    void onItemClick(View view, int position, T data);

}