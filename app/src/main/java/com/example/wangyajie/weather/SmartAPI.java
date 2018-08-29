package com.example.wangyajie.weather;

/**
 * Created by wangyajie on 2018/8/28.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyajie on 2018/8/28.
 */

import com.thoughtworks.xstream.core.util.Base64Encoder;

import org.json.JSONObject;

import java.io.IOException;

import javax.crypto.SecretKey;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public class SmartAPI {

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";
    private static final String APPID = "eaafbc8dff552a20";
    private static final String PRIVATE_KEY = "2017q1test_data";
    private static final String URL_HEADER = "http://webapi.weather.com.cn/data/?";

    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     *
     * @param encryptText
     *            被签名的字符串
     * @param encryptKey
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA1Encrypt1(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(ENCODING);
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        // 完成 Mac 操作
        return mac.doFinal(text);
    }

    /**
     * @description 公钥和私钥加密生成令牌(key)
     * @author linxiaofan
     * @param public_key
     *            公钥，为不包含key在内的全部URL，这里的appid为完整的appid
     * @param private_key
     *            私钥，仅用于生成令牌(key)
     * @return
     * @throws Exception
     */
    public static String getKey1(String public_key, String private_key) throws Exception {
        String key = "";
        byte[] key_bytes = HmacSHA1Encrypt1(public_key, private_key);
        Base64Encoder base64Encoder = new Base64Encoder();
        String temp = base64Encoder.encode(key_bytes);
        key = URLEncoder.encode(temp, ENCODING);
        return key;
    }

    public static String getWeather(String areaCode, String type) {
        JSONObject json = null;// 返回json对象
        String key = null;// 令牌
        String url = null;// 访问url
        String public_key = null;// 公钥

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String date = dateFormat.format(new Date());
        // 拼接公钥
        public_key = URL_HEADER + "areaid=" + areaCode + "&type=" + type + "&date=" + date + "&appid=" + APPID;
        // 公钥和私钥生成令牌key
        try {
            key = getKey1(public_key, PRIVATE_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        url = URL_HEADER + "areaid=" + areaCode + "&type=" + type + "&date=" + date + "&appid=" + APPID.substring(0, 6)
                + "&key=" + key;
        return url;
    }

    public static void main(String[] args) {
        String smartapiurl = getWeather("101010100", "forecast15d");
//        DefaultHttpClient httpclient = new DefaultHttpClient();
//        ResponseHandler<String> wlresponseHandler = new BasicResponseHandler();
//        try {
//            HttpGet smartapithttpget = new HttpGet(smartapiurl);
//            String smartapiresponseBody = "";
//            smartapiresponseBody = httpclient.execute(smartapithttpget, wlresponseHandler);
//            System.out.println(getEncoding(smartapiresponseBody));
//            if (!getEncoding(smartapiresponseBody).equalsIgnoreCase("UTF-8")) {
//                smartapiresponseBody = new String(smartapiresponseBody.getBytes(getEncoding(smartapiresponseBody)),
//                        "UTF-8");
//            }
//            System.out.println(smartapiresponseBody);
//
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }
}
