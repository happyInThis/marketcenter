package com.zhao.marketcenter.common.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Log4j2
public class HttpUtil {

    private static CloseableHttpClient httpClient;
    private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000).setConnectionRequestTimeout(15000).setRedirectsEnabled(true).build();

    /**
     * 发送 post请求
     *
     * @param httpUrl 地址
     * @param params  参数(格式:key1=value1&key2=value2)
     */
    public static String sendHttpPostWithXML(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        try {
            //设置参数
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttp(httpPost);
    }

    /**
     * 发送Get请求
     *
     * @param requestBase
     * @return
     */
    private static String sendHttp(HttpRequestBase requestBase) {
        CloseableHttpClient client = getHttpClient();
        CloseableHttpResponse response = null;
        HttpEntity entity;
        String responseContent = null;
        try {
            requestBase.setConfig(requestConfig);
            // 执行请求
            response = client.execute(requestBase);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            log.info("init CloseableHttpClient...");
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }

    /**
     * 发送 post请求
     *
     * @param httpUrl 地址
     * @param maps    参数
     */
    public static String sendHttpPost(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = new HttpPost(httpUrl);
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttp(httpPost);
    }

    /**
     * 对接快手专用!!!
     *
     * @param url
     * @param params
     * @return
     */
    public static String postWithApiSign(String url, Map params, String ksPwd) {
        params = fillApiSign(params, ksPwd);
        Map maps = new HashMap<>();
        maps.put("orderMeta", JsonUtil.toJson(params));
        String postEntity = JsonUtil.toJson(maps);
        String body = null;
        try {
            // Post请求
            HttpPost httppost = new HttpPost(url);
            // 设置参数
            StringEntity stringEntity = new StringEntity(postEntity, "UTF-8");
            stringEntity.setContentType("application/json");
            httppost.setEntity(stringEntity);
            // 发送请求
            HttpResponse httpresponse = getHttpClient().execute(httppost);
            // 获取返回数据
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    private static Map<String, Object> fillApiSign(Map<String, Object> signMap, String ksPwd) {
        if (signMap == null) {
            return null;
        }
        //升序
        Map<String, Object> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(signMap);

        StringBuilder paramSb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortMap.entrySet()) {
            paramSb.append(entry.getKey());
            paramSb.append("=");
            paramSb.append(entry.getValue());
            paramSb.append("&");
        }
        paramSb.deleteCharAt(paramSb.length() - 1);
        String signStr = ksPwd + paramSb.toString() + ksPwd;
        System.out.println(signStr);
        String sign = DigestUtils.md5Hex(signStr);
        signMap.put("apiSign", sign);

        return signMap;
    }

    /**
     * 发送 get请求
     *
     * @param httpUrl
     */
    public static String sendHttpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return sendHttp(httpGet);
    }

    static class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

}
