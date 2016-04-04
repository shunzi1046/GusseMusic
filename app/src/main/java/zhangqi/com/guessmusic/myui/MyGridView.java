package zhangqi.com.guessmusic.myui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

import zhangqi.com.guessmusic.R;
import zhangqi.com.guessmusic.model.WordButton;
import zhangqi.com.guessmusic.util.Util;

public class MyGridView extends GridView {

    private ArrayList<WordButton> mArrayList = new ArrayList<WordButton>();

    private MyGridAdapter mAdapter ;

    private Context mContext;

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        mAdapter = new MyGridAdapter();
        this.setAdapter(mAdapter);//关联Adapter和GridView
    }

    class MyGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View v, ViewGroup p) {
            WordButton holder;
            if(v==null){
                v= Util.getView(mContext, R.layout.self_ui_gridview_item);

                holder = mArrayList.get(position);
            }
            return null;
        }
    }

}
