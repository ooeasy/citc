package com.citc.mapper;


import com.citc.Template;
import freemarker.template.TemplateException;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.Map;

@Mapper
public interface GeneratorMapper {
    public  String generator(Map<String, Object> request) throws IOException, TemplateException;
}
