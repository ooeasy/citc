package com.citc.mapper;

import jdk.jshell.execution.LoaderDelegate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SyncFile {

    public int push(HashMap<String, Object> data, LocalDateTime time) {
        String fileName = "src/main/resources/static/test/map" + time;
        serializeMapToFile(data, fileName);
        return 0;
    }


    // 将Map对象序列化到文件
    private static void serializeMapToFile(Map<String, Object> map, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(map);
            System.out.println("Map serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, Integer> pull(File file) {
        System.out.println(this.getClass());
        Map<String, Integer> map = deserializeMapFromFile(file);
        return map;
    }

    // 从文件中反序列化Map对象
    private static Map<String, Integer> deserializeMapFromFile(File file) {
        Map<String, Integer> map = new HashMap<>();
        try {
            System.out.println(file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            map = (Map<String, Integer>) inputStream.readObject();
            System.out.println("Map deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}
