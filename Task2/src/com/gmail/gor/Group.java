package com.gmail.gor;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.gmail.gor.exceptions.NotEnoughSpaceException;

public class Group implements Voencom, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students = new ArrayList<>(10);
	private String groupName;

	public Group(List<Student> students, String groupName) {
		super();
		this.students = students;
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudens(List<Student> students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void deleteStudent(long id) {
		Iterator<Student> itr = students.iterator();
		for (; itr.hasNext();) {
			Student student = itr.next();
			if (student.getId() == id) {
				itr.remove();
			}
		}
	}

	public Student searchStudent(String lastName) {
		for (Student student : students) {
			if (student.getLastName().equalsIgnoreCase(lastName)) {
				return student;

			}
		}
		return null;
	}

	public void addStudent(Student st) throws NotEnoughSpaceException {

		if (students.size() < 10) {
			students.add(st);
			students.get(students.size() - 1).setGroup(groupName);
		} else if (students.size() == 10) {
			throw new NotEnoughSpaceException();
		}
	}

	public void createStudent() throws NotEnoughSpaceException {

		try {
			String name = JOptionPane.showInputDialog("Input name");
			String lastName = JOptionPane.showInputDialog("Input lastName");
			Gender gender = createGender();
			int age = createAge();
			long id = createId();
			Student student = new Student(name, lastName, gender, age, id);
			this.addStudent(student);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cancel");
		}
	}

	public Gender createGender() {
		Gender gender;
		for (;;) {
			try {
				gender = Gender.valueOf(JOptionPane.showInputDialog("Input gender"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return gender;
	}

	public int createAge() {
		int age;
		for (;;) {
			try {
				age = Integer.valueOf(JOptionPane.showInputDialog("Input age"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return age;

	}

	public long createId() {
		long id;
		for (;;) {
			try {
				id = Long.valueOf(JOptionPane.showInputDialog("Input id"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return id;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		Collections.sort(students, new StudentLastNameComparator());

		String string = "Group- " + groupName + System.lineSeparator();
		for (Student student : students) {
			string += student + System.lineSeparator();
		}

		return string;
	}

	@Override
	public List<Student> getReacruter() {
		List<Student> reacruter = new ArrayList<>();
		for (Student student : students) {
			if (student.getAge() > 18 && student.getGender() == Gender.MAN) {
				reacruter.add(student);
			}
		}
		return reacruter;
	}
}
