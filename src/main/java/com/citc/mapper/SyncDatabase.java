package com.citc.mapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class SyncDatabase {

    @Autowired
    SyncMapper syncMapper;

    public int push(HashMap data, LocalDateTime time) {
        System.out.println(data);
//        List<HashMap<String, Object>> images = (List<HashMap<String, Object>>) data.get("Images");
//        syncMapper.insertIntoImage(images, time);
//        List<HashMap<String, Object>> Comp = (List<HashMap<String, Object>>) data.get("Comp");
//        syncMapper.insertIntoComp(Comp, time);
        ArrayList<HashMap<String, Object>> Attr = (ArrayList<HashMap<String, Object>>) data.get("Attr");
        //Attr.remove(0);
        System.out.println("获取到Attr为" + Attr);
        HashMap test = Attr.get(0);
        HashMap map = (HashMap) test.get("attr");
        System.out.println("attr的值为:" + map + "\n类型为：" + map.getClass());
        //JSONObject jsonObject = new JSONObject(map);
        String jsonObject = map.toString();
        System.out.println("处理后attr的值为:" + jsonObject + "\n类型为：" + jsonObject.getClass());
        test.put("attr", jsonObject);
        System.out.println("处理后Attr为" + Attr);
        System.out.println((Attr.get(0).get("attr")).getClass());

        HashMap a = Attr.get(0);
        System.out.println(a.get("index"));
        System.out.println(a.get("attr"));
        System.out.println(time);
        syncMapper.insertIntoAttr(Attr, time);


//        List<HashMap<String, Object>> Router = (List<HashMap<String, Object>>) data.get("Router");
//        syncMapper.insertIntoRouter(Router, time);
        List<String> firstRouter = (List<String>) data.get("firstRouters");
        List<List<String>> secondRouter = (List<List<String>>) data.get("secondRouters");

//        List<HashMap<String, Object>> firstRouterList = new ArrayList<HashMap<String, Object>>();
//        List<List<HashMap<String, Object>>> secondRouterList = new ArrayList<List<HashMap<String, Object>>>();
//        Integer index = 1;
//        for (String i : firstRouter) {
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("router_name", i);
//            map.put("router_type", 1);
//            map.put("router_index", index);
//            map.put("router_parent_index", 0);
//            firstRouterList.add(map);
//            List<String> secondItem = secondRouter.get(index - 1);
//            Integer index2 = 1;
//            List<HashMap<String, Object>> secondItemList = new ArrayList<HashMap<String, Object>>();
//            for (String j : secondItem) {
//                HashMap<String, Object> mapSecond = new HashMap<>();
//                mapSecond.put("router_name", j);
//                mapSecond.put("router_type", 2);
//                mapSecond.put("router_index", index2);
//                mapSecond.put("router_parent_index", index2++);
//                secondItemList.add(mapSecond);
//            }
//            secondRouterList.add(secondItemList);
//            index++;
//        }
//        System.out.println(firstRouter);
//        System.out.println(secondRouter);
//        System.out.println(firstRouterList);
//        System.out.println(secondRouterList);
//        syncMapper.insertIntoRouterList(firstRouterList, time);
//        for (List<HashMap<String, Object>> a : secondRouterList) {
//            syncMapper.insertIntoRouterList(a, time);
//        }
        return 0;
    }


    public List pulllist() {
        System.out.println(this.getClass());
        List list = syncMapper.selectAllVersion();
        return list;
    }

    public Map pullbyData(LocalDateTime dateTime) {
        System.out.println(this.getClass());
        Map map = new HashMap();
        List Attr = syncMapper.selectAttrbydata(dateTime);
        for (Object attr : Attr) {
            Map map1 = (Map) attr;
            System.out.println(map1.get("attr").getClass());
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject((String) map1.get("attr"));
                Map<String, String> map2 = new HashMap<>();
                Iterator it = jsonObject.keys();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    map2.put(key, jsonObject.getString(key));
                }
                map1.put("attr", map2);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        map.put("Attr", Attr);
        return map;
    }

}
