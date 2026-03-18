package com.nan.coursecompose._1_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nan.coursecompose.R

private const val TAG = "Basic02Activity"

class Basic02Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Column(Modifier.safeContentPadding()) {
                var name by remember { mutableStateOf("huannan") }
                Text(name, Modifier.background(Color.Yellow), fontSize = 28.sp, fontWeight = FontWeight.Bold)

                Image(painterResource(R.drawable.avatar_rengwuxian), "头像")

                var buttonText by remember { mutableStateOf("点我") }
                Button({
                    buttonText = "点了"
                }) {
                    Text(buttonText)
                }
            }

            Row(Modifier.safeContentPadding()) {
                var name by remember { mutableStateOf("huannan") }
                Text(name, Modifier.background(Color.Yellow), fontSize = 28.sp, fontWeight = FontWeight.Bold)

                Image(painterResource(R.drawable.avatar_rengwuxian), "头像")

                var buttonText by remember { mutableStateOf("点我") }
                Button({
                    buttonText = "点了"
                }) {
                    Text(buttonText)
                }
            }
        }
    }
}

/*
1. 传统界面组件在 Compose 的等价物

关于参数设置：
通用的属性使用Modifier设置
组件专用的属性使用函数参数设置

Android常用布局：
FrameLayout
    相框布局，放多个时会叠加
    Box/setContent
LinearLayout
    线性布局
    Column、Row，内部都是通过Layout实现
RelativeLayout
    功能更强的FrameLayout
    可以用FrameLayout+LinearLayout实现，但是为了性能，一般推荐使用RelativeLayout
    Compose里面没有等价物，且性能不会随着布局嵌套而下降，不支持重复测量 因此可以通过Column+Row+Box实现
ConstraintLayout
    全新升级到不向后兼容的RelativeLayout
    Compose里面也有ConstraintLayout，但是不推荐使用
ScrollView
    预先加载好的布局，现有组件套一层就自动变成可滑动
       Modifier
RecyclerView
    按需的动态的懒加载布局
    LazyColumn
    LazyRow
ViewPager
    HotizontalPager
 */