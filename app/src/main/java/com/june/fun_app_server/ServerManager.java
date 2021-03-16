package com.june.fun_app_server;

import android.content.Context;
import android.util.Log;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class ServerManager {

    private final Server mServer;
    private static final String TAG = "ServerManager";

    /**
     * Create server.
     */
    public ServerManager(Context context) {
        InetAddress inetAddress = null;
        try {
            //这里的ip地址是手机的ip地址，可通过手机设置>系统->关于手机查看
            inetAddress = InetAddress.getByName("192.168.1.11");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        mServer = AndServer.serverBuilder(context)
                .inetAddress(inetAddress)
                .port(8080)
                .timeout(10, TimeUnit.SECONDS)
                .listener(new Server.ServerListener() {
                    @Override
                    public void onStarted() {
                        Log.d(TAG, "onStarted: 服务器启动");
                    }

                    @Override
                    public void onStopped() {
                        Log.d(TAG, "onStopped: 服务器关闭");
                    }

                    @Override
                    public void onException(Exception e) {
                        Log.d(TAG, "onException: 服务器出现异常"+e.getMessage());
                    }
                })
                .build();
    }

    /**
     * Start server.
     */
    public void startServer() {
        if (mServer.isRunning()) {
            // TODO The server is already up.
        } else {
            mServer.startup();
        }
    }

    /**
     * Stop server.
     */
    public void stopServer() {
        if (mServer.isRunning()) {
            mServer.shutdown();
        } else {
            Log.w("AndServer", "The server has not started yet.");
        }
    }
}

