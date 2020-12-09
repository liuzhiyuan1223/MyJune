package com.june.frame_okhttp;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.june.R;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetUtilActivity extends AppCompatActivity {

    private static final String TAG = "NetUtilActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_util);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handleNet();
    }

    private void handleNet(){
        //创建路径
        String responeJsonPath = "";
        try {
            File sdCardDir = Environment.getExternalStorageDirectory();
            responeJsonPath = sdCardDir.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String url = "https://www.baidu.com";
        String url = "https://www.baidu.com/users/{username}/login";

//        OkHttpClient client = new OkHttpClient();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MockDataIntercepter(responeJsonPath))
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
                //如果手机连接了代理，会执行到这里报错
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }
}