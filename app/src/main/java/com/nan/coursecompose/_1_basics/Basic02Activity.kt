package com.nan.coursecompose._1_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nan.coursecompose.ui.theme.CourseComposeTheme

private const val TAG = "Basic02Activity"

class Basic02Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CourseComposeTheme {
                Text("huannan", Modifier.safeDrawingPadding().background(Color.Yellow), fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

/*
1. 传统界面组件在 Compose 的等价物

关于参数设置：
通用的属性使用Modifier设置
组件专用的属性使用函数参数设置

 */