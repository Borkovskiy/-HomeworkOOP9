package com.gmail.gor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.gmail.gor.exceptions.NotEnoughSpaceException;

public class Main {

	public static void main(String[] args) {
		Student student1 = new Student("Андрей", "Захаров", Gender.MAN, 19, 123);
		Student student2 = new Student("Юрий", "Петров", Gender.MAN, 27, 1234);
		Student student3 = new Student("Сергей", "Иванов", Gender.MAN, 3, 12345);
		Student student4 = new Student("Наталия", "Коцюба", Gender.WOMAN, 4, 123456);
		Student student5 = new Student("Иван", "Арбузов", Gender.MAN, 19, 1234567);
		Student student6 = new Student("Иван", "Белов", Gender.MAN, 21, 12345678);
		Student student7 = new Student("Иван", "Козаков", Gender.MAN, 19, 123456689);
		Group group = new Group();
		group.setGroupName("курс 1");

		addStudent(student1, group);
		addStudent(student2, group);
		addStudent(student3, group);
		addStudent(student4, group);
		addStudent(student5, group);
		addStudent(student6, group);
		addStudent(student7, group);
		addStudent(student7, group);
		addStudent(student7, group);
		addStudent(student7, group);
		addStudent(student7, group);

		group.deleteStudent(123456689);

		searchStudent("Коцюба", group);
		searchStudent("sddsds", group);
		System.out.println("=====================================================================");
		System.out.println(group.toString());
		System.out.println("=====================================================================");
		for (Student reacruter : group.getReacruter()) {
			System.out.println(reacruter);
		}

		// Java OOP 8
		System.out.println("=====================================================================");
		System.out.println("Java OOP 8");
		File groupOfStudents = new File("groupOfStudents");
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("enter a word to:save-for save group, load- for load group, or exis- for exit");
			String text = "";
			text = sc.nextLine();
			if (text.equalsIgnoreCase("save")) {
				saveGroup(group);
			} else if (text.equalsIgnoreCase("load")) {
				Group groupLoad = null;
				groupLoad = loadGroup(groupOfStudents);
				System.out.println("downloaded group");
				System.out.println(groupLoad);
			} else if (text.equalsIgnoreCase("exit")) {
				break;
			}
		}

	}

	public static void saveGroup(Group group) {
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("groupOfStudents"))) {
			OOS.writeObject(group);
		} catch (IOException e) {
			System.out.println("ERROR saving");
		}

	}

	public static Group loadGroup(File file) {
		Group group = new Group();
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file))) {
			group = (Group) OIS.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load");
		}
		return group;

	}

	public static void addStudent(Student st, Group group) {
		try {
			group.addStudent(st);
		} catch (NotEnoughSpaceException e) {
			System.out.println("the group is full");
		}
	}

	public static void addStudent(Group group) {
		try {
			group.createStudent();
		} catch (NotEnoughSpaceException e) {
			System.out.println("the group is full");
		}
	}

	public static void searchStudent(String lastName, Group group) {
		if (group.searchStudent(lastName) != null) {
			System.out.println(group.searchStudent(lastName));
		} else {
			System.out.println("student is not in the group");
		}

	}
}
