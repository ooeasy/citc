package com.citc.controller;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Gen {

    @GetMapping("/test/index")
    public String test() {
        return "/Gen/index.html"; // 返回视图名称
    }

    @GetMapping("/test/echarts")
    @ResponseBody
    public static String Out(Map<String, Object> attr, Map<String, Object> request) throws IOException, TemplateException {
        //Map<String, String> map = new HashMap<String, String>();
//        map.put("host", "127.0.0.1");
//        map.put("port", "5000");
//        map.put("context", "testData");
//        map.put("typeSeries", "line");
//        map.put("theam", "dark");
//        map.put("width", "700");
//        map.put("height", "300");
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
        Template temp = cfg.getTemplate("Echarts.ftl");
        FileWriter fw = new FileWriter(toPath + "echarts" + attr.get("index") + ".vue");
        temp.process(data, fw);
        fw.close();
        JSONObject json = new JSONObject(data);
        return json.toString();
    }

    @GetMapping("/test/Input")
    @ResponseBody
    public static String Out3(Map<String, Object> attr) throws IOException, TemplateException {
        Map<String, Object> map = (Map<String, Object>) attr.get("attr");
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPath = "src/main/resources/static/out/vue/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("Input.ftl");
        FileWriter fw = new FileWriter(toPath + "Input" + attr.get("index") + ".vue");
        temp.process(map, fw);
        fw.close();
        JSONObject json = new JSONObject(map);
        return json.toString();
    }

    @GetMapping("/test/paragraph")
    @ResponseBody
    public static String Out4(Map<String, Object> attr) throws IOException, TemplateException {

        //Integer type = 2;
        Map<String, Object> map = (Map<String, Object>) attr.get("attr");
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPath = "src/main/resources/static/out/vue/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("paragraph.ftl");
        //Map<String, String> map = new HashMap<String, String>();
        System.out.println(map.get("selectedpType").getClass());
        //switch (Integer.parseInt((String) map.get("selectedpType"))) {
        switch ((int) map.get("selectedpType")) {
            default:
            case 0:
                map.put("start", "<span>");
                map.put("end", "</span>");
                break;
            case 1:
                map.put("start", "<h1>");
                map.put("end", "</h1>");
                break;
            case 2:
                map.put("start", "<h2>");
                map.put("end", "</h2>");
                break;
            case 3:
                map.put("start", "<h3>");
                map.put("end", "</h3>");
                break;
            case 6:
                map.put("start", "<h6>");
                map.put("end", "</h6>");
                break;
        }
        FileWriter fw = new FileWriter(toPath + "paragraph" + attr.get("index") + ".vue");
        temp.process(map, fw);
        fw.close();
        JSONObject json = new JSONObject(map);
        return json.toString();
    }

    @GetMapping("/test/router")
    @ResponseBody
    public static String OutRouter(List<Map<String, Object>> Router,
                                   List<Map<String, Object>> Image,
                                   List<Object> first,
                                   List<List> second) throws IOException, TemplateException {

        Map map = new HashMap<String, Object>();
        map.put("firstRouter", first);
        map.put("secondRouter", second);
        System.out.println(first.toString());
        System.out.println(second.toString());
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPath = "src/main/resources/static/out/routers/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("router.ftl");
        FileWriter fw = new FileWriter(toPath + "router.ts");
        System.out.println(map);
        temp.process(map, fw);
        fw.close();
        JSONObject json = new JSONObject(map);
        return json.toString();
    }

    @GetMapping("/test/vue")
    @ResponseBody
    public static String OutVue(List<Map<String, Object>> Comp,
                                List<Map<String, Object>> Router,
                                List<Map<String, Object>> Image,
                                List<String> firstRouterList,
                                List<List<String>> secondRouterList) throws IOException, TemplateException {
        Map mapForApp = new HashMap();
        mapForApp.put("firstRouterList", firstRouterList);
        mapForApp.put("secondRouterList", secondRouterList);
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPathApp = "src/main/resources/static/out/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("App.ftl");
        FileWriter fw = new FileWriter(toPathApp + "App.vue");
        temp.process(mapForApp, fw);
        fw.close();
        for (String firstrouter : firstRouterList) {
            for (String secondrouter : secondRouterList.get(firstRouterList.indexOf(firstrouter))) {
                System.out.println("整合:" + firstrouter + " " + secondrouter);
                Map map = new HashMap<String, Object>();
                List indexList = new ArrayList();
                List widthList = new ArrayList();
                List heightList = new ArrayList();
                List typeList = new ArrayList();
                List xList = new ArrayList();
                List yList = new ArrayList();
                for (Map router : Router) {
                    if (router.get("firstRouter").equals(firstrouter)) {
                        if (router.get("secondRouter").equals(secondrouter)) {
                            int index = (int) router.get("index");
                            //map.put("index", index);
                            indexList.add(index);
                            Map image = Image.get(index);
                            Map comp = Comp.get(index);
                            //map.put("width", comp.get("width"));
                            widthList.add(comp.get("width"));
                            // map.put("height", comp.get("height"));
                            heightList.add(comp.get("height"));
                            xList.add(comp.get("offsetX"));
                            yList.add(comp.get("offsetY"));
                            int type = (int) image.get("type");
                            switch (type) {
                                case 0:
                                    typeList.add("echarts");
                                    break;
                                case 2:
                                    typeList.add("Input");
                                    break;
                                case 3:
                                    typeList.add("paragraph");
                                    break;
                            }
                        }
                    }
                    map.put("indexList", indexList);
                    map.put("widthList", widthList);
                    map.put("heightList", heightList);
                    map.put("typeList", typeList);
                    map.put("xList", xList);
                    map.put("yList", yList);
                    System.out.println(map);
                }

                /*模板所在位置*/
                //String ftlPath = "src/main/resources/templates/";
                /*自动生成类所在位置*/
                String toPath = "src/main/resources/static/out/pages/";
                //Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
                cfg.setDirectoryForTemplateLoading(new File(ftlPath));
                cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
                temp = cfg.getTemplate("page.ftl");
                fw = new FileWriter(toPath + firstrouter + secondrouter + ".vue");
                temp.process(map, fw);
                fw.close();
            }

            Map mapForFirstRouter = new HashMap();
            mapForFirstRouter.put("firstrouter", firstrouter);
            int index = firstRouterList.indexOf(firstrouter);
//            System.out.println("这是第" + index + "个一级导航选项");
//            System.out.println(secondRouterList.get(index));
//            mapForFirstRouter.put("secondRouter", secondRouterList.get(firstRouterList.indexOf(firstrouter)));
            /*模板所在位置*/
            ftlPath = "src/main/resources/templates/";
            /*自动生成类所在位置*/
            String toPath = "src/main/resources/static/out/pages/";
            cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File(ftlPath));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
            temp = cfg.getTemplate("firstpage.ftl");
            fw = new FileWriter(toPath + firstrouter + ".vue");
            temp.process(mapForFirstRouter, fw);
            fw.close();
        }

        return "json.toString()";
    }


    @GetMapping("/test/controller")
    @ResponseBody
    public static String OutController(List<Map<String, Object>> Comp,
                                List<Map<String, Object>> Router,
                                List<Map<String, Object>> Image,
                                List<String> firstRouterList,
                                List<List<String>> secondRouterList) throws IOException, TemplateException {
        Map mapForApp = new HashMap();
        mapForApp.put("firstRouterList", firstRouterList);
        mapForApp.put("secondRouterList", secondRouterList);
        /*模板所在位置*/
        String ftlPath = "src/main/resources/templates/";
        /*自动生成类所在位置*/
        String toPathApp = "src/main/resources/static/out/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("App.ftl");
        FileWriter fw = new FileWriter(toPathApp + "App.vue");
        temp.process(mapForApp, fw);
        fw.close();


        return "json.toString()";
    }


}
