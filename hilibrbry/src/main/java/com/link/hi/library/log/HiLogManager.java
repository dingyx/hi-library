package com.link.hi.library.log;

import androidx.annotation.NonNull;

/**
 * @author dingyx
 * @description: HiLogManager
 * @date: 2023/4/4
 */
public class HiLogManager {

    private HiLogConfig config;
    private static HiLogManager instance;

    private HiLogManager(HiLogConfig config) {
        this.config = config;
    }

    public static HiLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull HiLogConfig config) {
        instance = new HiLogManager(config);
    }

    public HiLogConfig getConfig() {
        return config;
    }
}
