package com.fs.smartTown.httpService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/4 5:37 下午
 */
@Service
public class HttpClient {

    /**
     * Get 请求
     *
     * @param url
     * @param params
     * @return
     */
    public String httpGet(String url, MultiValueMap<String, String> params) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity(url, String.class, params);
        return responseEntity.getBody();
    }

}
