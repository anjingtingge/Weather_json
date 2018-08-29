package com.example.wangyajie.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import okhttp3.Call;

//天气的获取（测试版），网络数据获取，json解析
//复杂json,现生成javabean,再获取所需的字符
public class MainActivity extends AppCompatActivity {

    SmartAPI smart=new SmartAPI();
    private EditText wea;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wea= (EditText) findViewById(R.id.weather);
        url= smart.getWeather("EDDT_01", "forecast1d");
//        wea.setText(url);


        OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {}

            @Override
            public void onResponse(String response) {
                //gradle添加gson依赖

                // 1 获取或创建JSON数据
//                String json = "{\n" +
//                        "\t\"id\":2, \"name\":\"金鱼\", \n" +
//                        "\t\"price\":12.3, \n" +
//                        "\t\"imagePath\":\"http://blog.csdn.net/qq_29269233/L05_Server/images/f1.jpg\"\n" +
//                        "}\n";
//                String json = "[\n" +
//                        "    {\n" +
//                        "        \"id\": 1,\n" +
//                        "        \"imagePath\": \"http://blog.csdn.net/qq_29269233/f1.jpg\",\n" +
//                        "        \"name\": \"金鱼1\",\n" +
//                        "        \"price\": 12.3\n" +
//                        "    },\n" +
//                        "    {\n" +
//                        "        \"id\": 2,\n" +
//                        "        \"imagePath\": \"http://blog.csdn.net/qq_29269233/f2.jpg\",\n" +
//                        "        \"name\": \"金鱼2\",\n" +
//                        "        \"price\": 12.5\n" +
//                        "    }\n" +
//                        "]";
//
//                // 2 解析JSON数据
//                Gson gson = new Gson();
//
////                JavaBean shopInfo = gson.fromJson(json, JavaBean.class);
//                List<JavaBean> shops = gson.fromJson(json, new TypeToken<List<JavaBean>>() {}.getType());
//
//                // 3 展示数据
//                wea.setText(shops.toString());




                Gson gson = new Gson();
//                JsonRootBean status = gson.fromJson(response, JsonRootBean.class);
                JavaBean status = gson.fromJson(response, JavaBean.class);

                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

                Log.d("kwwl",response);

                //解析想要的某个字符
                String cc=status.getC().getC5();
               // 想要获取的字符在toString()中自己设定；
                String str=status.getF().getF1().toString();
                //去掉最后一个字符]
                str=str.substring(0,str.length()-1);
                //去掉第一个字符[
                str=str.substring(1,str.length());

                //分隔字符串，变成数组
                String[] qw=str.split(",");
                //取fb的值
                wea.setText(qw[1]);
            }
        });
    }
}
