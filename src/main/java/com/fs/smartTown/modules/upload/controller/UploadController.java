package com.fs.smartTown.modules.upload.controller;

import com.fs.smartTown.modules.upload.services.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/30 7:53 上午
 *
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;
    /**
     * 视频文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value ="/uploadVideo",method= RequestMethod.POST)
    public Map<String, Object> uploadVideo(MultipartFile file, HttpServletRequest request) throws Exception{
        return uploadService.uploadVideo(file, request);
    }

    /**
     * 图片文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value ="/uploadImage",method=RequestMethod.POST)
    public Map<String, Object> uploadImage(MultipartFile file,HttpServletRequest request) throws Exception{
        return uploadService.uploadImage(file, request);
    }

}
