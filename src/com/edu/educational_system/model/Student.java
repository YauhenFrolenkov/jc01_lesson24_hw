package com.edu.educational_system.model;

import java.util.Objects;

public class Student extends Person {
	private final String group;
	private final double averageGrade;

	public Student(String name, String email, String group, double averageGrade) {
		super(name, email);
		this.group = group;
		this.averageGrade = averageGrade;
	}

	@Override
	public void performRole() {
		study();
	}

	private void study() {
		System.out.println(getName() + " is attending the class.");
	}

	@Override
	public String getRoleDescription() {
		return "Student from group " + group + " with average grade: " + averageGrade;
	}

	public String getGroup() {
		return group;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(averageGrade, group);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(averageGrade) == Double.doubleToLongBits(other.averageGrade)
				&& Objects.equals(group, other.group);
	}

	@Override
	public String toString() {
		return "Student [group=" + group + ", averageGrade=" + averageGrade + "]";
	}
	
	

}
