package com.citc.service;

import com.citc.mapper.MybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MybatisService {
    @Autowired
    MybatisMapper mybatisMapper;

    public ArrayList<String> getDatabaseList() {
        return Result(mybatisMapper.getDatabaseList(), "SCHEMA_NAME");
    }

    public ArrayList<String> getTableList(String TABLE_SCHEMA) {
        return Result(mybatisMapper.getTableList(TABLE_SCHEMA), "TABLE_NAME");
    }

    public ArrayList<String> getColumnList(String TABLE_SCHEMA, String TABLE_NAME) {
        return Result(mybatisMapper.getColumnList(TABLE_SCHEMA, TABLE_NAME), "COLUMN_NAME");
    }


    public static ArrayList<String> Result(List<Map> data, String key) {
        ArrayList<String> result = new ArrayList<>();
        for (Map map : data) {
            result.add((String) map.get(key));
        }
        return result;
    }
}
