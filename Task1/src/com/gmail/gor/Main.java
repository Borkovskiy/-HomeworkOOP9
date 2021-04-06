package com.gmail.gor;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list1.add(i);
		}
		list1.remove(0);
		list1.remove(0);
		list1.remove(list1.size() - 1);
		System.out.println(list1);

	}

}
