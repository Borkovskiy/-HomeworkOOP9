package com.gmail.gor;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {
	public int compare(Student o1, Student o2) {
		Student student1 = (Student) o1;
		Student student2 = (Student) o2;

		return student1.getLastName().compareTo(student2.getLastName());
	}
}
