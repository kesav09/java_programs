package comparableAndComparator;

//http://www.journaldev.com/780/java-comparable-and-comparator-example-to-sort-objects
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements  Comparable<Employee>, Comparator<Employee> {
	int id;
	String name;

	public Employee() {
	}
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int compareTo(Employee employee) {
		// ascending
		return this.id - employee.id;

		// descending
		// return employee.id - this.id;
	}

	public int compare(Employee emp1, Employee emp2) {
		String x = emp1.name;
		String y = emp2.name;

		return x.compareTo(y);
	}
}

public class Client {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "abhinav"));
		list.add(new Employee(2, "sai"));
		list.add(new Employee(3, "harshal"));
		list.add(new Employee(4, "rupesh"));
		list.add(new Employee(5, "rohit"));

		System.out.println("\n SORT BY ID USING COMPARABLE: ");
		Collections.sort(list);
		
		for (Employee emp : list) {
			System.out.println("employee: " + emp.id);
			System.out.println("employee: " + emp.name);
		}
		
		
		System.out.println("\n SORT BY NAME USING COMPARATOR:  ");
		Collections.sort(list, new Employee());
		for (Employee emp : list) {
			System.out.println("employee: " + emp.name);
			System.out.println("employee: " + emp.id);
		}
	}
}