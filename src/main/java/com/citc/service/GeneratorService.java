package com.citc.service;

import com.citc.controller.Gen;
import com.citc.mapper.GeneratorMapper;
import com.citc.thread;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class GeneratorService {
    @Autowired
    GeneratorMapper generatorMapper1;

    public void create(Map data) {
        List<Map<String, Object>> Attr = (List<Map<String, Object>>) data.get("Attr");
        List<Map<String, Integer>> Images = (List<Map<String, Integer>>) data.get("Images");

        // 对列表进行排序
        Collections.sort(Attr, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                // 比较索引值
                return Integer.compare((int) o1.get("index"), (int) o2.get("index"));
            }
        });


//        for (Map img : Images) {
//            Integer index = (Integer) img.get("index");
//            Map<String, Object> attr = Attr.get(index);
//            System.out.println("--------Img:" + img.get("index"));
//            try {
//                Thread thread = new Shengcheng(attr, (Integer) img.get("type"), data);
//                thread.join();
//                thread.start();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//            }
//        }
        try {
            Gen.OutRouter((List<Map<String, Object>>) data.get("Router"),
                    (List<Map<String, Object>>) data.get("Images"),
                    (List<Object>) data.get("firstRouters"),
                    (List<List>) data.get("secondRouters"));
            System.out.println("--------------------------------------------");
            Gen.OutVue((List<Map<String, Object>>) data.get("Comp"),
                    (List<Map<String, Object>>) data.get("Router"),
                    (List<Map<String, Object>>) data.get("Images"),
                    (List<String>) data.get("firstRouters"),
                    (List<List<String>>) data.get("secondRouters"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilePath(Object o) {
        generatorMapper1.getTemplate(1);
        generatorMapper1.generateCode(new Object());
        return "Gen";
    }
}

class Shengcheng extends Thread {
    Map request;
    Map attr;
    Integer type;

    @Override
    public void run() {
        try {
            if (type == 0) {
                System.out.println("-------ShengCheng0：" + attr.toString());
                Gen.Out(attr, request);
            } else if (type == 2) {
                System.out.println("-------ShengCheng2：" + attr.toString());
                Gen.Out3(attr);
            } else if (type == 3) {
                System.out.println("-------ShengCheng3：" + attr.toString());
                Gen.Out4(attr);
            }
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public Shengcheng(Map attr, Integer type, Map request) {
        this.attr = attr;
        this.type = type;
        this.request = request;
    }

}