package com.citc.controller;

import com.citc.Util.Result;
import com.citc.service.SyncService;
import org.apache.ibatis.ognl.OgnlContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@RestController
public class SyncController {

    @Resource
    SyncService syncService;

    @PostMapping("/push")
    public Map<String, Object> push(@RequestBody(required = false) HashMap<String, Object> request) {
        System.out.println(this.getClass());
        if (request == null) {
            return new HashMap<>();
        }
        syncService.push(request);
        return request;
    }


    @PostMapping("/pull")
    public Map<String, Object> pull() {
        System.out.println(this.getClass());
        syncService.pull();
        return new HashMap<>();
    }

}
