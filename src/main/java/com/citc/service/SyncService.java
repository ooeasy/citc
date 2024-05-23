package com.citc.service;

import com.citc.mapper.SyncDatabase;
import com.citc.mapper.SyncFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class SyncService {

    @Autowired
    SyncFile syncFile;
    @Autowired
    SyncDatabase syncDatabase;

    public int push(HashMap<String, Object> data) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(this.getClass());
        //syncFile.push(data);
        syncDatabase.push(data, time);
        return 200;
    }

    public int pull() {

        HashMap map = (HashMap) syncFile.pull();
        System.out.println(map.toString());
        return 200;
    }

}
