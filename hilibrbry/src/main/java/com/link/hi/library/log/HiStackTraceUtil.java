package com.link.hi.library.log;

/**
 * @author dingyx
 * @description: 堆栈信息工具类
 * @date: 2023/4/7
 */
public class HiStackTraceUtil {

    /**
     * 获取真实堆栈信息
     * @param stackTrace stackTrace
     * @param ignorePackage 包名
     * @param maxDepth 深度
     * @return 优化后堆栈信息
     */
    public static StackTraceElement[] getCroppedRealStackTrace(StackTraceElement[] stackTrace, String ignorePackage, int maxDepth) {
        return cropStackTrace(getRealStackTrace(stackTrace, ignorePackage), maxDepth);
    }


    /**
     * 忽略部分包名堆栈信息
     *
     * @param stackTrace    堆栈信息
     * @param ignorePackage 忽略包名
     * @return 堆栈信息
     */
    private static StackTraceElement[] getRealStackTrace(StackTraceElement[] stackTrace, String ignorePackage) {
        int ignoreDepth = 0;
        int allDepth = stackTrace.length;
        String className;
        for (int i = allDepth - 1; i >= 0; i--) {
            className = stackTrace[i].getClassName();
            if (ignorePackage != null && className.startsWith(ignorePackage)) {
                ignoreDepth = i + 1;
                break;
            }
        }
        int realDepth = allDepth - ignoreDepth;
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(stackTrace, 0, realStack, 0, realDepth);
        return realStack;
    }


    /**
     * 堆栈信息删减
     *
     * @param callStack 堆栈信息
     * @param maxDepth  深度
     * @return 删减后堆栈信息
     */
    private static StackTraceElement[] cropStackTrace(StackTraceElement[] callStack, int maxDepth) {
        int realDepth = callStack.length;
        if (maxDepth > 0) {
            realDepth = Math.min(maxDepth, realDepth);
        }
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(callStack, 0, realStack, 0, realDepth);
        return realStack;
    }


}
