package briup.homework.jdk8.Lambda_test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-8:42
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*
* 利用Lambda遍历map集合*/
public class Test03_map {
    public static void main(String[] args) {
        Map<String, String> hmap = new HashMap<>();
        hmap.put("c", "00");
        hmap.put("a", "11");
        hmap.put("b", "22");
        hmap.put("f", "33");

        Lambda_map lambdaMap = () -> {
            for (Map.Entry<String, String> entry: hmap.entrySet()) {
                System.out.println(entry.getKey() + " "+entry.getValue());
            }
        };
        lambdaMap.getMapItem();
    }
}

interface Lambda_map {
    void getMapItem();
}