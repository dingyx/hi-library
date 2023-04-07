package com.link.hi.library.log;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author dingyx
 * @description:日志信息
 * @date: 2023/4/7
 */
public class HiLogMo {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);

    public long timeMills;
    public int level;
    public String tag;
    public String log;

    public HiLogMo(long timeMills, int level, String tag, String log) {
        this.timeMills = timeMills;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }

    public String flattenedLog() {
        return getFlattened() + "\n" + log;
    }


    public String getFlattened() {
        return format(timeMills) + '|' + level + '|' + tag + "|:";

    }

    public String format(long timeMills) {
        return sdf.format(timeMills);
    }
}
