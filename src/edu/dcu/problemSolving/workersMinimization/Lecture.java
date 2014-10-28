package edu.dcu.problemSolving.workersMinimization;

import java.util.ArrayList;

public class Lecture {

	ArrayList<Subject> subjects = new ArrayList<Subject>();

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	public Lecture(String name) {
		this.name = name;

	}

}
