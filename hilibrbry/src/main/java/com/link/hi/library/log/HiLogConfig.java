package com.link.hi.library.log;

/**
 * @author dingyx
 * @description: HiLog 配置
 * @date: 2023/4/4
 */
public abstract class HiLogConfig {

    public String getGlobalTag() {
        return "HiLog";
    }

    public boolean enable() {
        return true;
    }

}
