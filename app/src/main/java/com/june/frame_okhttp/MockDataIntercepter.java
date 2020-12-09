package com.june.frame_okhttp;

import java.io.File;
import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MockDataIntercepter implements Interceptor {
    private final String responeJsonPath;

    public MockDataIntercepter(String responeJsonPath) {
        this.responeJsonPath = responeJsonPath;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        String responseString = createResponseBody(chain);
        //Response 配置
        Response response = new Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
        return response;
    }


    /**
     * 该方法是为动态的配置各个接口数据，为此，需要对各个接口的注解，进行
     * 拦截处理，以实现加载不同的json数据
     * @param chain
     * @return
     */
    private String createResponseBody(Chain chain) {
        String responseString = null;
        HttpUrl httpUrl = chain.request().url();
        String urlPath = httpUrl.url().toString();

        //url 匹配形式进行数据返回
              if (urlPath.matches("^(/users/)+[^/]+(/login)$")) {//匹配/users/{username}/login
                    responseString = getResponseString("users_login.json");
                } else if (urlPath.matches("^(/users/)+[^/]*+$")) {//匹配/users/{username}
                    responseString = getResponseString("test.json");
                }

              //测试代码 好好复习一下正则表达式
              else {
                  responseString = getResponseString("users_login.json");
              }

        // 直接使用文件进行数据返回，不提倡。没有针对性
//        return FileUtils.testCase;
        return responseString;
    }

    private String getResponseString(String fileName) {
        return FileUtils.readFile(responeJsonPath + File.separator + fileName,"UTF-8");
    }
}
