package com.link.hi.library.log;

/**
 * @author dingyx
 * @description: 线程格式化
 * @date: 2023/4/6
 */
public class HiThreadFormatter implements HiLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
