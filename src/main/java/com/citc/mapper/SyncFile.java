package com.citc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SyncFile {

    public int push(HashMap<String, Object> data) {
        String fileName = "src/main/resources/static/test/map";
        serializeMapToFile(data, fileName);
        return 0;
    }


    // 将Map对象序列化到文件
    private static void serializeMapToFile(Map<String, Object> map, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(map);
            System.out.println("Map serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, Integer> pull() {
        System.out.println(this.getClass());
        String fileName = "src/main/resources/static/test/map";
        Map<String, Integer> map = deserializeMapFromFile(fileName);
        return map;
    }

    // 从文件中反序列化Map对象
    private static Map<String, Integer> deserializeMapFromFile(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            map = (Map<String, Integer>) inputStream.readObject();
            System.out.println("Map deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

}
