package com.example.lenovo.chenk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "3ZuGGMmSCwQ7GoBLV1CmaWzc";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "5cte2o5XU0ub3jmpkAG17xY1YdQAAurm";
        return getAuth(clientId, clientSecret);
    }

    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    public void check(View view) throws IOException {


        final EditText ediText = (EditText) findViewById(R.id.et);
        final TextView textview = (TextView) findViewById(R.id.tv);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    String access_token = getAuth();
                    System.out.println(access_token);
                    String url = "https://aip.baidubce.com/rpc/2.0/nlp/v1/ecnet";
                    String A = "?charset=UTF-8&";

                    URL Url = new URL(url + A + access_token);
                    HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.connect();

                    DataOutputStream data = new DataOutputStream(connection.getOutputStream());
                    data.writeBytes("text=" + ediText.getText().toString());
                    data.flush();
                    data.close();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = in.readLine();
                    while (line != null) {
                        textview.setText(line);
                    }
                } catch (Exception e) {
                }
            }
        };
        thread.start();
    }

}
