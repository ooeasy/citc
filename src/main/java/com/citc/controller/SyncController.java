package com.citc.controller;


import com.citc.service.SyncService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class SyncController {

    @Resource
    SyncService syncService;

    @PostMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile() throws IOException {
        // 创建一个字节数组输出流，用于写入文件内容
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 创建一个 ZipOutputStream，用于将文件写入到输出流中
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            // 创建一个新的文件条目
            zipOutputStream.putNextEntry(new ZipEntry("src/main/resources/static/test/map2024-05-24T11:11:24.300004`"));
            // 将文本内容写入到 ZipOutputStream 中
            zipOutputStream.write("Hello, World!".getBytes(StandardCharsets.UTF_8));
            zipOutputStream.closeEntry();
        }

        // 将输出流中的内容转换为字节数组
        byte[] data = outputStream.toByteArray();
        // 创建一个 ByteArrayResource 对象，用于包装字节数组
        ByteArrayResource resource = new ByteArrayResource(data);

        // 设置响应头，告诉浏览器文件的类型和名字
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "example.zip");

        // 创建 ResponseEntity 并返回
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentLength(data.length)
                .body(resource);
    }

    @PostMapping("/push")
    public Map<String, Object> push(@RequestBody(required = false) HashMap<String, Object> request) {
        System.out.println(this.getClass());
        if (request == null) {
            return new HashMap<>();
        }
        syncService.push(request);
        return request;
    }


    @GetMapping("/pulllist")
    public List pulllist() {
        System.out.println(this.getClass());
        List list = syncService.pulllist();
        return list;
    }

    @GetMapping("/pullbydate")
    public Map<String, Object> pullbydata(@RequestParam LocalDateTime dateTime) {
        System.out.println(this.getClass());
        Map map = syncService.pullbydata(dateTime);
        return map;
    }

    @PostMapping("/pullbyfile")
    public Map<String, Object> pullbyfile(@RequestParam("file")MultipartFile mfile) {
        System.out.println(this.getClass());
        if (mfile.isEmpty()) {
            Map result = new HashMap();
            result.put("Error", "File None");
            return result;
        }
        try {
            byte[] bytes = mfile.getBytes();
//            Path path = Paths.get("src/main/resources/static/test/" + file.getOriginalFilename());
//            Files.write(path, bytes);
            File file = convertMultipartFileToFile(mfile);
            Map responseData = syncService.pullbyfile(file);
            return responseData;

        } catch (IOException e) {
            e.printStackTrace();
        }
        //syncService.pullbyfile((File) mfile);
        return new HashMap<>();
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        System.out.println("????" + multipartFile.getOriginalFilename());
        File file = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }
}
