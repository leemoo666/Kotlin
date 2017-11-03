package com.example.kotlin

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView

/**
 * Created by lixiaoming on 2017/11/2.
 */

class HomeActivity : Activity(), AdapterView.OnItemClickListener {

    private lateinit var listview: ListView;

    private lateinit var btHome: Button;

    private lateinit var adapter: HomeAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);

        listview = findViewById(R.id.lvHome);

        adapter = HomeAdapter(this);

        adapter.setCallBack(object : HomeAdapter.CallBack {
            override fun onclick(position: Int) {
                Log.i("lxm","call position = "+position);
            }
        })
        listview.adapter = adapter;
//
        listview.onItemClickListener = this;

        btHome = findViewById(R.id.btHome);
        btHome.setOnClickListener { Log.i("lxm", "button click!") }

        initData();
    }

    fun initData() {
        var i: Int = 0;
        var end: Int = 100;
        val arrayList: ArrayList<String> = ArrayList<String>();
        do {
            arrayList.add("我是第 $i 条数据 ")
            i++
        } while (i < end);

        adapter.setList(arrayList);
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.i("lxm", "item click " + position);
    }
}
