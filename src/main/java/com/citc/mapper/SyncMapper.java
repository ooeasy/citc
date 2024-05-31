package com.citc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SyncMapper {

    public void insertIntoImage(List<HashMap<String, Object>> ImageList, LocalDateTime time);

    public int insertIntoComp(List<HashMap<String, Object>> CompList, LocalDateTime time);

    public int insertIntoAttr(List<HashMap<String, Object>> AttrList, LocalDateTime time);

    public int insertIntoRouter(List<HashMap<String, Object>> RouterList, LocalDateTime time);

    public int insertIntoRouterList(List<HashMap<String, Object>> routerlist, LocalDateTime time);
    //
//    public int insertIntoRouter(HashMap<String, Object> data);

    public List<LocalDateTime> selectAllVersion();


    public List<HashMap<?, ?>> selectAttrbydate(LocalDateTime dateTime);

    public List<HashMap<?, ?>> selectCompbydate(LocalDateTime dateTime);

    public List<HashMap<?, ?>> selectImagesbydate(LocalDateTime dateTime);

    public List<HashMap<?, ?>> selectRouterbydate(LocalDateTime dateTime);
}
