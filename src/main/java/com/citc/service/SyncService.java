package com.citc.service;

import com.citc.mapper.SyncDatabase;
import com.citc.mapper.SyncFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SyncService {

    @Autowired
    SyncFile syncFile;
    @Autowired
    SyncDatabase syncDatabase;


    public int push(HashMap<String, Object> data) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(this.getClass());
        syncFile.push(data, time);
        syncDatabase.push(data, time);
        return 200;
    }

    public List pulllist() {
        System.out.println(this.getClass());
        List list = syncDatabase.pulllist();
        return list;
    }

    public Map pullbydata(LocalDateTime dateTime) {
        System.out.println(this.getClass());
        Map map = syncDatabase.pullbyData(dateTime);
        return map;
    }

    public Map pullbyfile(File file) {
        System.out.println(this.getClass());
        Map<String, Integer> map = syncFile.pull(file);
        return map;
    }

}
