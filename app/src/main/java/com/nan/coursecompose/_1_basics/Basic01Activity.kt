package com.nan.coursecompose._1_basics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.nan.coursecompose.ui.theme.CourseComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "Basic01Activity"

class Basic01Activity : ComponentActivity() {
    var name by mutableStateOf("Huannan")
    var name1 = name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // setContent是连接外部世界和Compose世界的桥梁
        setContent {
            CourseComposeTheme {
                Column(Modifier.safeContentPadding()) {
                    Text(name)

                    // remember防止由于重组引起的变量的反复初始化，预防带来不可控的结果
                    var title by remember { mutableStateOf("abc") }
                    Text(title)
                    CharCounter(title)
                    Button({
                        title = "abcd"
                    }) {
                        Text("按钮")
                    }
                }
            }
        }

        lifecycleScope.launch {
            delay(2000L)
            name = "Panpan"
        }
    }
}

@Composable
fun CharCounter(value: String) {
    val result = remember(value) {
        Log.d(TAG, "count=${value.length}")
        "字符数量统计结果=${value.length}"
    }
    Log.d(TAG, "recompose")
    Text(result)
}

/*
1. 声明式UI概念

声明式UI：只需要在写界面的时候对界面进行一次「声明」，无需在各种条件下对界面元素进行更新
命令式UI：imperative，对界面原色实施了命令

声明式UI自动更新：关键在于根据State进行初始化显示，以及State变化的时候自动更新
声明式UI的阴暗面：对开发者友好，但是不好实现，例如考虑性能的情况下的自动更新，即怎么检测界面里面的所有状态，在状态改变的时候自动刷新改变的部分


2. MutableState和mutableStateOf()

自动更新的原理
1. 找到Compose界面里面所用到State的代码位置
2. ReCompose重新执行State的代码位置所在的代码块，即重组作用域ReCompose Scope，即函数类型的对象


使用基本类型时，mutableXXXStateOf()代替mutableStateOf()可以避免装箱拆箱带来的性能损耗

代理功能-订阅性by不能通过赋值=操作进行传递
1. 直接在界面里面使用的状态，可以使用by
2. 需要间接使用如在ViewModel里面定义然后在界面里面使用的状态，需要使用=

// 不能传递
var name by mutableStateOf("Huannan")
var name1 = name
// 可以传递
val name = mutableStateOf("Huannan")
val name1 = name


3. 组合、重组作用域和 remember()

界面刷新的过程，多一个组合过程是为了实现声明式UI，实现界面的自动更新工作
组合-布局-绘制

组合：Composition，执行各个Compose函数的过程，即创建和组合界面元素。
底层原理：各种函数内部会创建各种具有布局和绘制功能的对象，底层实现是LayoutNode、NodeCoordinator

重组：部分或全部Compose代码重新执行的过程

remember()
起到一个组合过程中缓存记忆的作用，第一次调用的时候会执行并保存lambda的结果；之后每一次重组的时候直接返回之前的结果
防止由于重组引起的变量的反复初始化，预防带来不可控的结果

注意事项：
组合过程里面的创建State对象，都需要包上一层remember()
组合过程里面的创建的其它代码块也可以包上一层remember()，防止重复执行，可以通过key值来区分，key值不同则重新执行一次代码块

remember()局限性
布局和绘制中的重复执行，不能通过remember()解决，需要使用Modifier解决

 */