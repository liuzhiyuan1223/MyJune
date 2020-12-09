package com.june.frame_okhttp;

import android.os.Build;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 设置请求Header
 *
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("-Header", creatHeader())
                .addHeader("user-agent", "公司名称/应用名称")
                .build();
        Request newRequest = builder.build();

        return chain.proceed(newRequest);
    }

    /**
     * Request Header
     * <p> 由于sign 与 URL 关联因此，它可理解为动态的参数，而不能理解为固定参数</p>
     *
     * @return
     */
    public String creatHeader() {
        StringBuffer header = new StringBuffer();
        header.append("platform").append("=").append("android").append(";")
                .append("os").append("=").append(Build.VERSION.SDK_INT).append(";")
                .append("appid").append("=").append("com.xxx.xxx").append(";")
                .append("version").append("=").append("2320").append(";")
                .append("mid").append("=").append(Build.MODEL.replaceAll(" ", "_")).append(";")
                .append("channel").append("=").append("ceshi");// 使用gradle 语法进行获取不同的渠道配置
        return header.toString();
    }

}
