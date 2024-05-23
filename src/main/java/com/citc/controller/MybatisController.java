package com.citc.controller;

import com.citc.mapper.MybatisMapper;
import com.citc.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin
@RestController
public class MybatisController {
    @Autowired
    MybatisService mybatisService;

    @Resource(name = "my1")
    MybatisService my;

    @GetMapping("/getDatabaseList")
    public ArrayList<String> getDatabaseList() {
        return mybatisService.getDatabaseList();
    }

    @GetMapping("/getTableList")
    public ArrayList<String> getTableList(@RequestParam String TABLE_SCHEMA) {
        return mybatisService.getTableList(TABLE_SCHEMA);
    }


    @GetMapping("/getColumnList")
    public ArrayList<String> getColumnList(@RequestParam String TABLE_SCHEMA,
                                           @RequestParam String TABLE_NAME) {
        return my.getColumnList(TABLE_SCHEMA, TABLE_NAME);
    }
}
