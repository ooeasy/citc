package com.citc.controller;

import com.citc.Util.Result;
import com.citc.service.GeneratorService;
import com.citc.service.Packager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GeneratorController {
    @Autowired
    GeneratorService generatorService;


    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody(required = false) HashMap<String, Object> request) {
        if (request == null) {
            Map result = new HashMap<String, String>();
            result.put("result", "null");
            return result;
        }
        generatorService.create(request);
        return request;
    }

    public String getFilePath(String json) {
        JSON2Object("Test");
        generatorService.getFilePath("Gen");
        Packager packager = new Packager();
        return packager.getPackageFIle("Gen");
    }

    public Object JSON2Object(String JSON) {
        return new Object();
    }
}
