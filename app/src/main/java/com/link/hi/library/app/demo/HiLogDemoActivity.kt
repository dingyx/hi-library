package com.link.hi.library.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.link.hi.library.app.R
import com.link.hi.library.log.*

class HiLogDemoActivity : AppCompatActivity() {

    var viewPrinter: HiViewPrinter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)

        viewPrinter = HiViewPrinter(this)


        findViewById<View>(R.id.btn_log).setOnClickListener {
            printLog()
        }

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