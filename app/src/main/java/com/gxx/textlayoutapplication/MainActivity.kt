package com.gxx.textlayoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gxx.textlayoutapplication.weiget.TextViewLeftOtherLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewLeftOtherLayout = findViewById<TextViewLeftOtherLayout>(R.id.tv_other_textview_left_other_layout);
        textViewLeftOtherLayout.setLeftRightTextValue("来来来","在自定义View中通过Canvas绘制文字时，经常需要测量文字的宽度和高度的宽度和高度的宽度和高度");
    }
}