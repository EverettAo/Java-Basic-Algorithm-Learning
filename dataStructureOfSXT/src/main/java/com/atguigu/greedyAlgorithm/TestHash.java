package com.atguigu.greedyAlgorithm;

import java.util.HashSet;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/10/2021 4:35 PM
 */
public class TestHash {
    public static void main(String[] args) {
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("广州");
/*        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("天津");
        allAreas.add("成都");*/

        HashSet<String> hs1 = new HashSet<>();
        hs1.add("北京");
        hs1.add("上海");
        hs1.add("天津");

        hs1.retainAll(allAreas);
        System.out.println(hs1);
    }
}
