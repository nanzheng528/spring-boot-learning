package com.nz.springbootlearning.array;

import com.nz.springbootlearning.classlearn.A;

public class Array {
	private int[] data;
	private int size;

	public Array(int capacity){
		data = new int[capacity];
		size = 0;
	}

	/**
	 * 默认的构造函数
	 */
	public Array(){
		this(10);
	}

	public Array(int[] data){
		this.data = data;
	}

	public int getSize(){
		return size;
	}

	public int getCapacity(){
		return data.length;
	}

	public boolean isEmpty(){
		return size == 0;
	}
}
