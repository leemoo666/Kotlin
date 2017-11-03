package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by lixiaoming on 2017/11/2.
 */
class HomeAdapter(private var context: Context) : BaseAdapter() {

    private var list: ArrayList<String> = ArrayList();

    private lateinit var callBack: CallBack;

    fun setList(list: ArrayList<String>) {
        this.list = list;
        notifyDataSetChanged();
    }

    fun setCallBack(callBack: CallBack) {
        this.callBack = callBack;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var holder: ViewHolder;
        var view: View;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
            holder = ViewHolder(view);
            view.tag = holder;
        } else {
            view = convertView;
            holder = view.tag as ViewHolder;
        }
        holder.tvItemHome.setText(list.get(position));

        holder.tvItemHome.setOnClickListener({
            callBack?.onclick(position);
        })
        return view;
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    class ViewHolder(viewItem: View) {
        var tvItemHome: TextView = viewItem.findViewById(R.id.item_tv)
    }

    interface CallBack {
        fun onclick(position: Int);
    }
}