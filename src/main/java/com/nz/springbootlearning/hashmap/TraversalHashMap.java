package com.nz.springbootlearning.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class TraversalHashMap {

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put(1, "A");
        objectObjectHashMap.put(2, "B");
        objectObjectHashMap.put("3", "c");
        Iterator<Map.Entry<Object, Object>> iterator =
                objectObjectHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println(key.toString());
            System.out.println(value.toString());
        }
		objectObjectHashMap.entrySet().forEach(objectObjectEntry -> System.out.println(objectObjectEntry.getKey().toString() + objectObjectEntry.getValue()));

        objectObjectHashMap.forEach((k, v) -> System.out.println(k.toString() + v));
    }
}
