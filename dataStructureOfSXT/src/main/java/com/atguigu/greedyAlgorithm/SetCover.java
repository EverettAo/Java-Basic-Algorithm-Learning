package com.atguigu.greedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/9/2021 9:31 PM
 */
public class SetCover {
    public static void main(String[] args) {
        /**
         * 创建电台与集合，放入Map中进行管理
         */
        HashMap<String, HashSet<String>> broadCastHashMap = new HashMap<>();
        HashSet<String> hs1 = new HashSet<>();
        hs1.add("北京");
        hs1.add("上海");
        hs1.add("天津");

        HashSet<String> hs2 = new HashSet<>();
        hs2.add("北京");
        hs2.add("广州");
        hs2.add("深圳");

        HashSet<String> hs3 = new HashSet<>();
        hs3.add("成都");
        hs3.add("上海");
        hs3.add("杭州");

        HashSet<String> hs4 = new HashSet<>();
        hs4.add("上海");
        hs4.add("天津");

        HashSet<String> hs5 = new HashSet<>();
        hs5.add("杭州");
        hs5.add("大连");

        /**
         * 加入到Map
         */
        broadCastHashMap.put("k1", hs1);
        broadCastHashMap.put("k2", hs2);
        broadCastHashMap.put("k3", hs3);
        broadCastHashMap.put("k4", hs4);
        broadCastHashMap.put("k5", hs5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("天津");
        allAreas.add("成都");

        ArrayList<String> selects = new ArrayList<>();

        /**
         * 定义一个临时集合，存放遍历过程中已电台覆盖的地区和当前还没有覆盖地区的交集
         */
        HashSet<String> tempSet = new HashSet<>();
        /**
         * 保存在一次遍历过程中能够覆盖最多未覆盖地区的电台key
         */
        String maxKey;
        while (!allAreas.isEmpty()) {
            maxKey = null;
            /**
             * 如果不为空，就表示还没有覆盖到所有地区
             */
            for (String key : broadCastHashMap.keySet()) {
                tempSet.clear();
                /**
                 * 取出当前key能够覆盖的地区
                 */
                HashSet<String> areas = broadCastHashMap.get(key);
                tempSet.addAll(areas);
                /**
                 * 去除tempSet中不在allAreas的元素，就地操作
                 */
                tempSet.retainAll(allAreas);
                /**
                 * 此处体现了贪婪算法的特性
                 */
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCastHashMap.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                allAreas.removeAll(broadCastHashMap.get(maxKey));
                broadCastHashMap.remove(maxKey);
                selects.add(maxKey);
            }
        }
        System.out.println(selects);
    }

}
