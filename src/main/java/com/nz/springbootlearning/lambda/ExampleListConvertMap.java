package com.nz.springbootlearning.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleListConvertMap {
	private static List<String> StringList = Lists.newArrayList();

	static {
		StringList.add("1");
		StringList.add("2");
	}

	public static void main(String[] args) {
		Map<Integer, String> map_ = StringList.stream().collect(Collectors.toMap((key->key.hashCode()), (value->value)));
		map_.forEach((key, value) -> System.out.println(key+":"+value));
	}
	List<String> proNames = Arrays.asList("NAN","ZHENG");

}
