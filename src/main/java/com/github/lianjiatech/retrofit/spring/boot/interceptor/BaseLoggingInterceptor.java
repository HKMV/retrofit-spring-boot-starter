package com.github.lianjiatech.retrofit.spring.boot.interceptor;

import okhttp3.Interceptor;
import org.slf4j.event.Level;

/**
 * @author 陈添明
 */
public abstract class BaseLoggingInterceptor implements Interceptor {

    /**
     * 日志打印级别
     */
    protected final Level logLevel;

    /**
     * 日志打印策略
     */
    protected final LogStrategy logStrategy;


    public enum LogStrategy {

        /**
         * No logs.
         */
        NONE,

        /**
         * Logs request and response lines.
         */
        BASIC,

        /**
         * Logs request and response lines and their respective headers.
         */
        HEADERS,

        /**
         * Logs request and response lines and their respective headers and bodies (if present).
         */
        BODY
    }


    public BaseLoggingInterceptor(Level logLevel, LogStrategy logStrategy) {
        this.logLevel = logLevel;
        this.logStrategy = logStrategy;
    }
}
