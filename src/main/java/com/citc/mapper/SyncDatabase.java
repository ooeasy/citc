package com.citc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class SyncDatabase {
    @Autowired
    SyncMapper syncMapper;

    public int push(HashMap data, LocalDateTime time) {
        List<HashMap<String, Object>> images = (List<HashMap<String, Object>>) data.get("Images");
        for (HashMap<String, Object> i : images) {
            i.put("time", time);
        }
        syncMapper.insertIntoImageList(images);
        //syncMapper.selectall();
        return 0;
    }

}
