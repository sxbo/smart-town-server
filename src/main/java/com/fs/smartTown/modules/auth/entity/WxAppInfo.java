package com.fs.smartTown.modules.auth.entity;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/10/30 1:36 下午
 */
public class WxAppInfo {

    private String appId;
    private String appSecret;
    private String appYsKey;
    private String appYsSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppYsKey() {
        return appYsKey;
    }

    public void setAppYsKey(String appYsKey) {
        this.appYsKey = appYsKey;
    }

    public String getAppYsSecret() {
        return appYsSecret;
    }

    public void setAppYsSecret(String appYsSecret) {
        this.appYsSecret = appYsSecret;
    }
}
