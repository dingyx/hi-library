package com.link.hi.library.app

import android.app.Application
import com.google.gson.Gson
import com.link.hi.library.log.HiConsolePrinter
import com.link.hi.library.log.HiLogConfig
import com.link.hi.library.log.HiLogManager

/**
 * @author dingyx
 * @description:
 * @date: 2023/4/6
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {
            override fun getGlobalTag(): String {
                return "MyApplication"
            }

            override fun enable(): Boolean {
                return true
            }

            override fun interfaceJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }
        }, HiConsolePrinter())
    }

}