package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.httpService.HttpClient;
import com.fs.smartTown.modules.auth.entity.WxAppInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;


@Api(tags = "微信授权")
@RestController
public class WxAuthController {


    @Autowired
    private HttpClient httpClient;

    /**
     * 获取openID
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appid", value = "appid"),
            @ApiImplicitParam(name = "secret", value = "secret"),
            @ApiImplicitParam(name = "js_code", value = "js_code")
    })
    @ApiOperation("获取openID")
    @PostMapping("/sys/wxAuth")
    public Map<String, Object> wxAuth(@RequestParam("appid") String appid,
                                      @RequestParam("secret") String secret,
                                      @RequestParam("js_code") String js_code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret +
                "&js_code=" + js_code + "&grant_type=authorization_code";
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        String jsonStr = httpClient.httpGet(url, multiValueMap);
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("data", jsonStr);
        return result;
    }

    /**
     * 获取AccessToken
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appid", value = "appid"),
            @ApiImplicitParam(name = "secret", value = "secret")
    })
    @ApiOperation("获取AccessToken")
    @GetMapping("/sys/getAccessToken")
    public Map<String, Object> getAccessToken(@RequestParam("appid") String appid,
                                              @RequestParam("secret") String secret) {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + appid + "&secret=" + secret;
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        String jsonStr = httpClient.httpGet(url, multiValueMap);
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("data", jsonStr);
        return result;
    }


    /**
     * 获取微信AppId、AppSecret
     */
    @ApiOperation("获取getWxAppInfo")
    @GetMapping("/sys/getWxAppInfo")
    public Map<String, Object> getWxAppInfo() {
        WxAppInfo wxAppInfo = new WxAppInfo();
        wxAppInfo.setAppId("wx86a3fe0373f614fd");
        wxAppInfo.setAppSecret("3ba1ac7e501cc497e23314b44cc7deff");
        wxAppInfo.setAppYsKey("b623a1c07c654c1babda79ca183563ab");
        wxAppInfo.setAppYsSecret("f40d43bc0980e64a360af555c8f1b135");
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("data", wxAppInfo);
        return result;
    }

}
