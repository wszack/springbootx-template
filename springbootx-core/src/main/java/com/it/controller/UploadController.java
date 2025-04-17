package com.it.controller;

import com.it.common.Result;
import com.it.util.MinioUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("springbootx")
@Api(tags = "文件上传接口")
public class UploadController {

    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        String fileUrl = minioUtil.uploadFile(file);
        return Result.success(fileUrl);
    }
}
