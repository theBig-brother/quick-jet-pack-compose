package com.lzf.quickcheck


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.lzf.quickcheck.screens.*  // 引入页面
import com.lzf.quickcheck.screens.Home.*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp() // 设置应用的主界面为 MyApp Composable
        }
    }
}

@Composable
fun MyApp() {
    // 创建 NavController 进行导航控制
    val navController = rememberNavController()

    // 启动画面，2 秒后跳转到主界面

    var showSplash by remember { mutableStateOf(false) } // 定义状态控制是否显示 Splash 屏幕
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000) // 延迟 2 秒
        showSplash = false // 2 秒后切换状态，隐藏 Splash 屏幕
    }

    if (showSplash) {
        SplashScreen() // 显示 Splash 屏幕
    } else {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) } // 底部导航栏
        ) { paddingValues ->
            NavHost(
                navController = navController, // 导航控制器
                startDestination = "home", // 启动时默认显示 "home" 页面
                modifier = Modifier.padding(paddingValues) // 设置内容的 padding
            ) {
                composable("home") { HomeScreen(navController) } // 定义 "home" 页面
                composable("function") { FunctionScreen() } // 定义 "function" 页面
                composable("mine") { MineScreen() } // 定义 "mine" 页面
                composable("camera") { CameraScreen(navController) } // 添加 "camera" 页面，但不在底部导航栏中
                composable("todo") { ToDoScreen(navController) } // 添加 "camera" 页面，但不在底部导航栏中

            }
        }
    }
}