package com.mrprk.oops.hierarchical;

public class Main {

	public static void main(String[] args) {
		Student s = new Student();
		Teacher t = new Teacher();
		String schoolName = s.checkSchoolName();
		s.studentName = "Atim";
		s.checkStudent();
		t.teacherName = "Swagatam";
		t.checkTeache();

		System.out.println(schoolName + " " + s.studentName);
		System.out.println(schoolName + " " + t.teacherName);

	}

}
