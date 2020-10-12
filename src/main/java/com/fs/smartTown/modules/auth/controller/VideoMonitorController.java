package com.fs.smartTown.modules.auth.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "获取萤石云监控播放列表")
@RestController
public class VideoMonitorController {

    private static final String url = "https://open.ys7.com/api/lapp/token/get?appKey=b623a1c07c654c1babda79ca183563ab&appSecret=f40d43bc0980e64a360af555c8f1b135";
    private static final String listUrl  = "https://open.ys7.com/api/lapp/camera/list";

    @ApiOperation(value = "监控列表", tags = "监控列表")
    @GetMapping("/videos")
    public Map<String, Object> videoList(@RequestParam String pageStart, @RequestParam String pageSize){

        if(pageStart == null){
            pageStart = "0";
        }
        if(pageSize == null){
            pageSize = "8";
        }
        Map<String, Object> result = new HashMap<>();
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS,true);
        String accessToken = getAccessToken(url);
        String vedioListUrl = listUrl + "?accessToken="+accessToken+"&pageStart="+ pageStart + "&pageSize="+pageSize;
        HttpPost httpPost = getPostMethod(vedioListUrl);
        try {
            try {

                HttpResponse response = client.execute(httpPost);
                String responseStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject jsonStr = JSONObject.parseObject(responseStr);
                String code = String.valueOf(jsonStr.get("code"));
                if (code.equals("200")){
                    result.put("data", jsonStr);
                    result.put("status", 200);
                    result.put("accessToken", accessToken);
                } else if (code.equals("10002")){
                    result.put("data", null);
                    result.put("status", 500);
                    result.put("msg", "accessToken过期");
                } else if (code.equals("10005")){
                    result.put("data", null);
                    result.put("status", 500);
                    result.put("msg", "appKey被冻结");
                } else {
                    result.put("data", jsonStr);
                    result.put("status", 200);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", 500);
            result.put("msg", "获取萤石云监控列表失败！");
        } finally {
            if(!httpPost.isAborted()){
                httpPost.abort();
            }
            client.getConnectionManager().shutdown();
        }
        System.out.println("result:"+ result.toString());
        return result;
    }

    /**
     * 获取萤石云监控的accessToken
     * @param url
     * @return
     */
    public static String getAccessToken(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS,true);
        HttpPost httpPost = getPostMethod(url);
        String accessToken = "";
        try {
            try {

                HttpResponse response = client.execute(httpPost);
                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject jsStr = JSONObject.parseObject(jsonStr);
                String code = String.valueOf(jsStr.get("code"));
                if(code.equals("200")){
                    String data = jsStr.getString("data");
                    JSONObject dataJson = JSONObject.parseObject(data);
                    accessToken = dataJson.getString("accessToken");
                    return accessToken;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(!httpPost.isAborted()){
                httpPost.abort();
            }
            client.getConnectionManager().shutdown();
        }
        return accessToken;
    }

    /**
     * 设置请求头信息
     * @param url
     * @return
     */
    public static HttpPost getPostMethod(String url) {
        HttpPost pernod = new HttpPost(url); // 设置响应头信息
        pernod.addHeader("Connection", "keep-alive");
        pernod.addHeader("Accept", "*/*");
        pernod.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        pernod.addHeader("Host", "open.ys7.com");
        pernod.addHeader("X-Requested-With", "XMLHttpRequest");
        pernod.addHeader("Cache-Control", "max-age=0");
        pernod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        return pernod;
    }
}
