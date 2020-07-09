package com.github.lianjiatech.retrofit.spring.boot.config;


import com.github.lianjiatech.retrofit.spring.boot.core.BodyCallAdapterFactory;
import com.github.lianjiatech.retrofit.spring.boot.core.ResponseCallAdapterFactory;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseHttpExceptionMessageFormatter;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseLoggingInterceptor;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.DefaultHttpExceptionMessageFormatter;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.DefaultLoggingInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 陈添明
 */
@ConfigurationProperties(prefix = "retrofit")
public class RetrofitProperties {

    private static final String DEFAULT_POOL = "default";

    /**
     * 连接池配置
     */
    private Map<String, PoolConfig> pool = new LinkedHashMap<>();

    /**
     * 启用 #{@link BodyCallAdapterFactory} 调用适配器
     */
    private boolean enableBodyCallAdapter = true;

    /**
     * 启用 #{@link ResponseCallAdapterFactory} 调用适配器
     */
    private boolean enableResponseCallAdapter = true;

    /**
     * 启用日志打印
     */
    private boolean enableLog = true;

    /**
     * 日志打印拦截器
     */
    private Class<? extends BaseLoggingInterceptor> loggingInterceptorClass = DefaultLoggingInterceptor.class;

    /**
     * Http异常信息格式化器
     */
    private Class<? extends BaseHttpExceptionMessageFormatter> httpExceptionMessageFormatterClass = DefaultHttpExceptionMessageFormatter.class;

    public Class<? extends BaseHttpExceptionMessageFormatter> getHttpExceptionMessageFormatterClass() {
        return httpExceptionMessageFormatterClass;
    }

    public void setHttpExceptionMessageFormatterClass(Class<? extends BaseHttpExceptionMessageFormatter> httpExceptionMessageFormatterClass) {
        this.httpExceptionMessageFormatterClass = httpExceptionMessageFormatterClass;
    }

    /**
     * 禁用Void返回类型
     */
    private boolean disableVoidReturnType = false;


    public Class<? extends BaseLoggingInterceptor> getLoggingInterceptorClass() {
        return loggingInterceptorClass;
    }

    public void setLoggingInterceptorClass(Class<? extends BaseLoggingInterceptor> loggingInterceptorClass) {
        this.loggingInterceptorClass = loggingInterceptorClass;
    }

    public Map<String, PoolConfig> getPool() {
        if (!pool.isEmpty()) {
            return pool;
        }
        pool.put(DEFAULT_POOL, new PoolConfig(5, 300));
        return pool;
    }

    public void setPool(Map<String, PoolConfig> pool) {
        this.pool = pool;
    }

    public boolean isEnableBodyCallAdapter() {
        return enableBodyCallAdapter;
    }

    public void setEnableBodyCallAdapter(boolean enableBodyCallAdapter) {
        this.enableBodyCallAdapter = enableBodyCallAdapter;
    }

    public boolean isEnableResponseCallAdapter() {
        return enableResponseCallAdapter;
    }

    public void setEnableResponseCallAdapter(boolean enableResponseCallAdapter) {
        this.enableResponseCallAdapter = enableResponseCallAdapter;
    }

    public boolean isEnableLog() {
        return enableLog;
    }

    public void setEnableLog(boolean enableLog) {
        this.enableLog = enableLog;
    }

    public boolean isDisableVoidReturnType() {
        return disableVoidReturnType;
    }

    public void setDisableVoidReturnType(boolean disableVoidReturnType) {
        this.disableVoidReturnType = disableVoidReturnType;
    }
}
