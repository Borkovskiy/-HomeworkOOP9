package com.gmail.gor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		File file = new File("text.txt");
		String string1 = loadFromFile(file);
		string1 = string1.toLowerCase().replaceAll("\\W", "");
		char[] arr = string1.toCharArray();
		List<Character> chars = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			chars.add(arr[i]);
		}
		sortList(chars);

	}

	public static void sortList(List<Character> chars) {
		Map<Character, Integer> stat = new HashMap<>();

		for (char charTake : chars) {
			int count = 1;
			if (stat.containsKey(charTake)) {
				count = stat.get(charTake) + 1;
			}
			stat.put(charTake, count);
		}

		List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(stat.entrySet());

		sortedList.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});

		System.out.println(sortedList);

	}

	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());

			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return sb.toString();
	}
}
