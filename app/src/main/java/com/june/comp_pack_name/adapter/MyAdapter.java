package com.june.comp_pack_name.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.june.R;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List namelist;

    //MyAdapter的构造函数，一个Context类型的参数，也就是哪一个Activity
    //这里传进去的是 ListViewActivity,ListView所在的Activity
    public MyAdapter(Context context, List list) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.namelist = list;
    }

    public void updataDataList(List list){
        this.namelist = list;
    }

    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //写一个静态的class,把layout_list_item的控件转移过来使用
    static class ViewHolder {
        //声明引用
        public TextView tvAppName;
    }

    //重要的方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //实例化ViewHolder
        ViewHolder holder = null;
        //如果视图为空
        if (convertView == null) {
            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            convertView = mLayoutInflater.inflate(R.layout.adapter_lv, null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //把layout_list_item对象转移过来，以便修改和赋值
            holder.tvAppName = (TextView) convertView.findViewById(R.id.tv_appName);

            //把这个holder传递进去
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvAppName.setText((String) namelist.get(position));

        return convertView;
    }
}