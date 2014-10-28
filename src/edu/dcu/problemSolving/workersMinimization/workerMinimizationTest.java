package edu.dcu.problemSolving.workersMinimization;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class workerMinimizationTest {

	@Test
	public void test() {

	}

	public void testIfSort() {

	}

	@Test
	public void testgetLectureWithMoreSubjects(ArrayList<Lecture> lecture) {
		ArrayList<Subject> subjectsLecture1 = new ArrayList<Subject>();
		subjectsLecture1.add(Subject.HISTORY);
		subjectsLecture1.add(Subject.SPANISH);

		ArrayList<Subject> subjectsLecture2 = new ArrayList<Subject>();
		subjectsLecture2.add(Subject.PHYSICS);
		subjectsLecture2.add(Subject.MATHS);
		subjectsLecture2.add(Subject.SPANISH);

		ArrayList<Subject> subjectsLecture3 = new ArrayList<Subject>();
		subjectsLecture3.add(Subject.SPANISH);

		Lecture lecture1 = new Lecture("lecture1");
		lecture1.setSubjects(subjectsLecture1);

		Lecture lecture2 = new Lecture("lecture2");
		lecture2.setSubjects(subjectsLecture2);

		Lecture lecture3 = new Lecture("lecture3");
		lecture3.setSubjects(subjectsLecture3);

		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		lectures.add(lecture1);
		lectures.add(lecture2);
		lectures.add(lecture3);
		workerMinimization workerMinimization = new workerMinimization(lectures);
		/*workerMinimization.sort();*/

	/*	workerMinimization.getLectureWithMoreSubjects();

		assertEquals("lecture2",
				workerMinimization.getLectureWithMoreSubjects());
		
	*/	

	}
	
	

}
