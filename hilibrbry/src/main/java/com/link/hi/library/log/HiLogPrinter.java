package com.link.hi.library.log;

import androidx.annotation.NonNull;

/**
 * @author dingyx
 * @description:日志打印接口
 * @date: 2023/4/6
 */
public interface HiLogPrinter {
    void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString);
}
