package com.link.hi.library.log;

import androidx.annotation.NonNull;

import static com.link.hi.library.log.HiLogConfig.MAX_LEN;

import android.util.Log;

/**
 * @author dingyx
 * @description:控制台日志打印
 * @date: 2023/4/6
 */
public class HiConsolePrinter implements HiLogPrinter {

    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            // 不整除 打印剩余内容
            if (index != len) {
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            // 不足一行时
            Log.println(level, tag, printString);
        }
    }

}
