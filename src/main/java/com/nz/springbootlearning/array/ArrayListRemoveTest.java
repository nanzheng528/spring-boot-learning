package com.nz.springbootlearning.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListRemoveTest {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1	.add("1");
		list1.add("2");
//		for (String s : list1) {
//			if ("2".equals(s)){
//				list1.remove(s);
//			}
//		}
//		System.out.println(list1.toString());

		Iterator<String> iterator = list1.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if ("2".equals(next)) {
				iterator.remove();
			}
		}
		System.out.println(list1.toString());
	}
}
