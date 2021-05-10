package com.example.myapplication8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Toast
import com.example.myapplication8.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {
    /**
     * lateinit注释
     * 相关教程
     * https://www.bilibili.com/video/BV1wf4y1s7TG?p=81
     */
    private lateinit var popupwindow : PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         *  View Binding页面绑定
         *  相关博客和教程
         *  https://blog.csdn.net/weixin_38754349/article/details/116279660
         */
        val inflate = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inflate.root)

        //id调用+点击监听
        inflate.button.setOnClickListener {
            initPop()
            Log.d("TAG", "onCreate: 点了一下按钮")
        }

    }

    /**
     * PopupWindow设置
     * 相关博客和教程
     * https://blog.csdn.net/Minle_/article/details/79101321
     * https://www.jianshu.com/p/cb2809cb4ade
     *
     */
    @SuppressLint("InflateParams")
    private fun initPop() {
        //PopupWindow弹窗自定义页面
        val popupView = LayoutInflater.from(this).inflate(R.layout.pop_filter, null)
        //PopupWindow弹窗基础配置
        popupwindow = PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true
        )
        //设置PopUpWindow的焦点，设置为true之后，PopupWindow内容区域，才可以响应点击事件
        popupwindow.isTouchable = true

        //PopUpWindow弹窗里的点击监听
        popupView.setOnClickListener {
            Toast.makeText(this,"你点击了弹窗界面，我已帮您关闭了弹窗",Toast.LENGTH_SHORT).show()
            //关闭PopUpWindow弹窗
            popupwindow.dismiss()
        }

        //显示PopupWindow弹窗
        popupwindow.showAtLocation(popupView,Gravity.BOTTOM,0,0)
    }

    //PopUpWindow弹窗里的点击监听
    fun tvtext(view: View) {
        Toast.makeText(this,"你点击了弹窗里的文字",Toast.LENGTH_SHORT).show()
    }

}

