package com.citc.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface SyncMapper {
    public void inserIntoImageList(List<HashMap<String, Object>> imageList);

//    public int insertIntoComp(HashMap<String, Object> data);
//
//    public int insertIntoAttr(HashMap<String, Object> data);
//
//    public int insertIntoImages(HashMap<String, Object> data);
//
//    public int insertIntoRouter(HashMap<String, Object> data);


}
