package com.gmail.gor;

import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) {
		ArrayDeque<String> queueTBBT = new ArrayDeque<>();
		queueTBBT.addFirst("Penny");
		queueTBBT.addFirst("Koothrappali");
		queueTBBT.addFirst("Wolowitz");
		queueTBBT.addFirst("Leonard");
		queueTBBT.addFirst("Sheldon");
		System.out.println(queueTBBT);
		drinkColla(2, queueTBBT);
	}

	public static void drinkColla(int a, ArrayDeque<String> queueTBBT) {
		for (int i = 1; i <= a; i++) {
			String first = queueTBBT.pollFirst();
			queueTBBT.addLast(first);
			queueTBBT.addLast(first);

		}
		System.out.println(queueTBBT);
	}

}
