package edu.dcu.problemSolving.workersMinimization;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class workerMinimization {

	ArrayList<Lecture> lectures;

	workerMinimization(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}

	// Sort
	public ArrayList<Lecture> sort(ArrayList<Lecture> lecture) {
		Lecture temp;
		int i;
		int j;

		for (i = 0; i < lectures.size(); i++) {

			int max = i;

			for (j = i + 1; j < lectures.size() - 1; j++) {

				if (lectures.get(i).getSubjects().size() < lectures.get(j)
						.getSubjects().size()) {

					max = j;
				}

				temp = lectures.get(i);
				lectures.set(i, lectures.get(max));
				lectures.set(max, temp);

			}

		}

		for (int k = 0; k < lectures.size(); k++) {

			System.out.println(lectures.get(k).getSubjects());
			System.out.println(lectures.get(k).getName());

		}
		return lectures;

	}

	// return the name of the lecture with More Subjects
	public Lecture getSubjectsLectureWithMoreSubjects(
			ArrayList<Lecture> sortLecture) {

		return lectures.get(0);
	}

	// enum to array
	public ArrayList<String> getAllSubjectsNames() {
		Subject[] subjects = Subject.values();
		ArrayList<String> subjectsName = new ArrayList<String>();

		for (int i = 0; i < subjects.length; i++) {
			subjectsName.add(subjects[i].name());

		}

		return subjectsName;

	}

	// compare if a subject is containing in the array of all the contains
	// elements.
	public ArrayList<String> findTheBestOption(
			ArrayList<Subject> originalListSubjects) {

		ArrayList<String> bestLecturesOptions = new ArrayList<String>();
		ArrayList<Lecture> sortLecture;

		sortLecture = sort(lectures);

		do {

			Lecture lectureWithMoreSubjects = getSubjectsLectureWithMoreSubjects(sortLecture);

			System.out.println("Original list subjects" + originalListSubjects);

			System.out.println("Current lecture "
					+ lectureWithMoreSubjects.getName());

			System.out.println("Current Subjects:"
					+ lectureWithMoreSubjects.getSubjects());

			for (int i = 0; i < lectureWithMoreSubjects.getSubjects().size(); i++) {

				if (originalListSubjects.contains(lectureWithMoreSubjects
						.getSubjects().get(i))) {
					System.out.println("contains");
					originalListSubjects.remove(lectureWithMoreSubjects
							.getSubjects().get(i));

					System.out.println("new original list subjects:"
							+ originalListSubjects);

					if(!bestLecturesOptions.contains(lectureWithMoreSubjects.getName()))
					bestLecturesOptions.add(lectureWithMoreSubjects.getName());

				}

				// System.out.println("new lectures" + lectures);

			}
			lectures.remove(0);
			// System.out.println("new list lectures" + lectures.);

		} while (!originalListSubjects.isEmpty());

		return bestLecturesOptions;

		/*
		 * ArrayList<Subject> lectureWithSubjects, ArrayList<String>
		 * originalListSubjects) {
		 * 
		 * ArrayList<String> bestLectureOption = new ArrayList<String>();
		 * 
		 * int i = 0;
		 * 
		 * do { System.out.println(" Subjects for the current lecture " +
		 * subjectsLectureWithMoreSubjects);
		 * System.out.println("Original List of subjects" +
		 * originalListSubjects);
		 * 
		 * if (originalListSubjects.contains(subjectsLectureWithMoreSubjects
		 * .get(i).name())) { System.out.println("contains");
		 * 
		 * originalListSubjects.remove(subjectsLectureWithMoreSubjects
		 * .get(i).name());
		 * 
		 * // add new lecture with more subjects
		 * bestLectureOption.add(subjectsLectureWithMoreSubjects.get(i)
		 * .name()); System.out.println("add lecture: " +
		 * subjectsLectureWithMoreSubjects.get(i).name()); }
		 * 
		 * System.out.println("print new subjects" + originalListSubjects); i++;
		 * } while (!originalListSubjects.isEmpty());
		 * 
		 * return bestLectureOption;
		 */

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		ArrayList<String> originalListSubjects = workerMinimization
				.getAllSubjectsNames();

		ArrayList<Subject> subjects = new ArrayList<Subject>();
		subjects.add(Subject.HISTORY);
		subjects.add(Subject.MATHS);
		subjects.add(Subject.PHYSICS);
		subjects.add(Subject.SPANISH);

		ArrayList<String> bestOptions = workerMinimization.findTheBestOption(subjects);
		
		for(int i = 0; i < bestOptions.size(); i++){
			
			System.out.println(bestOptions.get(i));
			
		}
	}

} // ArrayList<Lecture> sortLectureList = workerMinimization.sort();

/*
 * ArrayList<String> allSubjects = workerMinimization.getNames();
 * 
 * System.out.println(allSubjects);
 */
// workerMinimization.compareLectureWithSubjects(workerMinimization.getSubjectsByLectureWithMoreSubjects(i),
// originalListSubjects);

