package com.nan.coursecompose._1_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.nan.coursecompose.ui.theme.CourseComposeTheme

private const val TAG = "Basic02Activity"

class Basic02Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CourseComposeTheme {
                // Row(Modifier.safeContentPadding()) {
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
FrameLayout 相框布局，放多个时会叠加
LinearLayout 线性布局
    Column、Row，内部都是通过Layout实现
RelativeLayout
ConstraintLayout
ScrollView
RecyclerView
ViewPager



 */