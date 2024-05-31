package com.citc.mapper;

import com.citc.Template;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import org.apache.ibatis.annotations.Mapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Mapper
public class GeneratorEcharts implements GeneratorMapper {

    @Override
    public String generator(Map<String, Object> request) throws IOException, TemplateException {
        //Map<String, String> map = new HashMap<String, String>();
//        map.put("host", "127.0.0.1");
//        map.put("port", "5000");
//        map.put("context", "testData");
//        map.put("typeSeries", "line");
//        map.put("theam", "dark");
//        map.put("width", "700");
//        map.put("height", "300");
        Map attr = (Map) request.get("Attr");
        Map data = (Map) attr.get("attr");
        //map.put("selectedSeriesTheme","dark");
        List<Map> Comp = (List<Map>) request.get("Comp");
        Map comp = Comp.get((int) attr.get("index"));
        data.put("width", comp.get("width"));
        data.put("height", comp.get("height"));
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPath = "src/main/resources/static/out/vue/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        freemarker.template.Template temp = cfg.getTemplate("Echarts.ftl");
        FileWriter fw = new FileWriter(toPath + "echarts" + attr.get("index") + ".vue");
        temp.process(data, fw);
        fw.close();
        JSONObject json = new JSONObject(data);
        return json.toString();
    }
}
