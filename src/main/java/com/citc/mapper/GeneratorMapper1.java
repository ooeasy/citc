package com.citc.mapper;

import com.citc.Template;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class GeneratorMapper1 implements GeneratorMapper {
    @Override
    public Template getTemplate(Integer i) {
        return null;
    }

    @Override
    public String generateCode(Object json) {
        return null;
    }
}
