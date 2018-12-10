package com.nz.springbootlearning.hashmap1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class HashMapTheory {

    private static Map<String, String> map = new HashMap();

    public static void main(String[] args) {
        map.put("aa", "aa");
        map.put("bb", "bb");
        map.put("cc", "cc");
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
