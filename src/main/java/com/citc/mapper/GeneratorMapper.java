package com.citc.mapper;


import com.citc.Template;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GeneratorMapper {
    public Template getTemplate(Integer i);

    public String generateCode(Object json);
}
