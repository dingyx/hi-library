package com.link.hi.library.log;

/**
 * @author dingyx
 * @description:堆栈信息格式化
 * @date: 2023/4/6
 */
public class HiStackTraceFormatter implements HiLogFormatter<StackTraceElement[]> {

    @Override
    public String format(StackTraceElement[] traceElements) {
        StringBuilder sb = new StringBuilder(128);
        if (traceElements == null || traceElements.length == 0) {
            return null;
        } else if (traceElements.length == 1) {
            return "\t-" + traceElements[0].toString();
        } else {
            for (int i = 0; i < traceElements.length; i++) {
                if (i == 0) {
                    sb.append("stackTrace:\n");
                }
                if (i != traceElements.length - 1) {
                    sb.append("\t|-");
                    sb.append(traceElements[i].toString());
                    sb.append("\n");
                } else {
                    sb.append("\t|-");
                    sb.append(traceElements[i].toString());
                }
            }
            return sb.toString();
        }
    }

}
