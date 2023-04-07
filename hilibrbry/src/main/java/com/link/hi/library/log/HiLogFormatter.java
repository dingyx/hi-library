package com.link.hi.library.log;

/**
 * @author dingyx
 * @description:日志格式化接口
 * @date: 2023/4/6
 */
public interface HiLogFormatter<T> {
    String format(T data);
}
