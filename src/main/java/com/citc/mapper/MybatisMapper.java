package com.citc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface MybatisMapper {
    @Select("SELECT SCHEMA_NAME FROM information_schema.SCHEMATA")
    List<Map> getDatabaseList();

    @Select(value = "SELECT TABLE_NAME FROM information_schema.TABLES " +
            "WHERE TABLE_SCHEMA = #{TABLE_SCHEMA}")
    List<Map> getTableList(String TABLE_SCHEMA);

    @Transactional(readOnly = true)
    @Select("SELECT COLUMN_NAME FROM information_schema.COLUMNS" +
            " WHERE TABLE_SCHEMA=#{TABLE_SCHEMA} and TABLE_NAME=#{TABLE_NAME}")
    List<Map> getColumnList(String TABLE_SCHEMA, String TABLE_NAME);
}
