package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(3, "Nam"));
		students.add(new Student(5, "Minh"));
		students.add(new Student(2, "Hoang"));
		students.add(new Student(4, "Hien"));
		
		Collections.sort(students, new StudentComparator());
		students.forEach(student ->{
			System.out.println(student.getId()+" "+student.getName());
		});
		
		
		System.out.println("--------------");
		
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		students.forEach(student ->{
			System.out.println(student.getId()+" "+student.getName());
		});
		
		
		System.out.println("--------------");
		
		Collections.sort(students);
		students.forEach(student ->{
			System.out.println(student.getId()+" "+student.getName());
		});
		
	}
}
