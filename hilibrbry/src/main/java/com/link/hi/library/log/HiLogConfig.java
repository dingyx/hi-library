package com.link.hi.library.log;

/**
 * @author dingyx
 * @description: HiLog 配置
 * @date: 2023/4/4
 */
public abstract class HiLogConfig {

    static int MAX_LEN = 512;

    static HiStackTraceFormatter HI_STACK_TRACE_FORMATTER = new HiStackTraceFormatter();
    static HiThreadFormatter HI_THREAD_FORMATTER = new HiThreadFormatter();

    public JsonParser interfaceJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "HiLog";
    }

    public boolean enable() {
        return true;
    }

    // 是否包含线程信息
    public boolean includeThread() {
        return false;
    }

    // 堆栈深度
    public int stackTraceDepth() {
        return 5;
    }

    public HiLogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }
}
