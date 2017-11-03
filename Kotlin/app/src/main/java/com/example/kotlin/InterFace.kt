package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lixiaoming on 2017/11/2.
 */

class InterFace : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

//    lateinit var callBack:CallBack;
//    interface CallBack {
//        fun onClick(position: Int){
//            System.out.println("回调");
//        }
//    }
}
