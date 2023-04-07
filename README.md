# Android 项目架构

## 通用UI组件

`hilibrary`  

### HiLog

通用日志打印框架	 `com.link.hi.library.log`

1. MyApplication 初始化
2. HiLogDemoActivity 使用

```kotlin
package com.link.hi.library.app.demo
    
class HiLogDemoActivity : AppCompatActivity() {

    // App可视化打印
    var viewPrinter: HiViewPrinter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)
        
        // 初始化 Printter
        viewPrinter = HiViewPrinter(this)


        findViewById<View>(R.id.btn_log).setOnClickListener {
            // 点击打印日志
            printLog()
        }

        // 显示悬浮按钮 可显示、隐藏窗口
        viewPrinter!!.viewProvider.showFloatingView()

    }

    private fun printLog() {

        // 添加可视化打印
        HiLogManager.getInstance().addPrinter(viewPrinter)

        // 自定义Log配置
        HiLog.log(object : HiLogConfig() {
            override fun includeThread(): Boolean {
                return true
            }

            override fun stackTraceDepth(): Int {
                return 0
            }

        }, HiLogType.E, "- - - - - -", "6666")
        HiLog.a("123456")
    }
}
```

