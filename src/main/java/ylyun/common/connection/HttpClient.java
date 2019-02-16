package ylyun.common.connection;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

public class HttpClient {

    private final static String USER_AGENT = "Mozilla/5.0";
    private static int SC_OK = 200; 
    private static int CONN_TIMEOUT = 5000;
    private static int REQ_TIMEOUT = 5000;
    private static int SOCKET_TIMEOUT = 5000;
    private static Logger LOG = LoggerFactory.getLogger(HttpClient.class);

    public static void main(String[] args) throws Exception {

        //HttpClient http = new HttpClient();

        String url = "https://howtodo.yilan.tv/video/v2/head?channel_id=100&app=howto_i&udid=UhJotgFG6BJJVPM8QiXckTLc412byv1lN1OP9SQI&timestamp=1548403706";

        System.out.println("Testing 1 - Send Http GET request");
        JSONObject jsonResult = httpPost(url, null);
        System.out.println(jsonResult.getJSONArray("contents"));
        
        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();

    }
   

    /**
     * 发送GET请求
     * @param url 路径
     * @return JSONObject
     */
    public static JSONObject httpGet(String url) {
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            //发送get请求
            HttpGet httpGet = new HttpGet(url);
            //超时设置
            RequestConfig requestConfig = RequestConfig.custom()
            		.setConnectTimeout(CONN_TIMEOUT)
                    .setConnectionRequestTimeout(REQ_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();
            httpGet.setConfig(requestConfig);
            //添加请求头
            httpGet.addHeader("User-Agent", USER_AGENT);
            httpGet.addHeader("Content-Type", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == SC_OK) {
                //读取服务器返回过来的json字符串数据
                String strResult = EntityUtils.toString(response.getEntity());
                //把json字符串转换成json对象
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                LOG.error("http get request fail:" + url);
            }
        } catch (IOException e) {
            LOG.error("http get request fail:" + url, e);
        }
        return jsonResult;
    }

    /**
     * 发送post请求
     * @param url  url地址
     * @param jsonParam 参数
     * @return JSONObject
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam){
    	JSONObject jsonResult = null;
        try {
        	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            //超时设置
            RequestConfig requestConfig = RequestConfig.custom()
            		.setConnectTimeout(CONN_TIMEOUT)
                    .setConnectionRequestTimeout(REQ_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();
            httpPost.setConfig(requestConfig);
        	//增加支持json的http头信息
        	httpPost.setHeader("User-Agent", USER_AGENT);
            httpPost.addHeader("Content-Type", "application/json");
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(httpPost);
            url = URLDecoder.decode(url, "UTF-8");
            //请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == SC_OK) {
                String str = "";
                try {
                    //读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity());
                    //把json字符串转换成json对象
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    LOG.error("http post request fail:" + url, e);
                }
            }
        } catch (IOException e) {
            LOG.error("http post request fail:" + url, e);
        }
        return jsonResult;
    }
}
