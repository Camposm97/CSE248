package p1;

import java.util.Arrays;

public class StudentBag {
	private static final int SIZE = 2000;
	private Student[] arr;
	private int nElems;
	
	public StudentBag() {
		this.arr = new Student[SIZE];
		this.nElems = 0;
	}
	
	public void insert(Student s) {
		arr[nElems++] = s;
		Arrays.sort(arr);
	}
	
	public double getAverageGpa() {
		double averageGpa = 0;
		int i;
		for (i = 0; i < nElems; i++) {
			averageGpa = arr[i].getGpa();
		}
		averageGpa /= i;
		return  averageGpa;
	}
}
