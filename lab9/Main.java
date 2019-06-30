package lab9;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		System.out.println("racer -> " + isPalindrome("racer"));
		System.out.println("racecar -> " + isPalindrome("racecar"));
		System.out.println("----------------------------------------------------");
		countChars("111122sssseq");
		System.out.println("----------------------------------------------------");
		Queue queue = new Queue();
		for(int i = 0 ; i < 11 ; i++)
			queue.addToQueue(i);
		queue.printElements();
		System.out.println("Get the current first elemnt in the queue -> " + queue.getElement());
		System.out.println("Peek at the current first elemnt in the queue -> " + queue.peek());
		queue.addToQueue(10);
		queue.printElements();
		System.out.println("----------------------------------------------------");
		HashSet<Employee> employees = new HashSet<>();
		initEmployees(employees);
		for(Employee e : getEmpByHighestSalary(employees))
			System.out.println(e);
		System.out.println();
		for(Employee e : getEmpByLowestSalary(employees))
			System.out.println(e);
	}

	//STACK
	private static boolean isPalindrome(String str) {
		boolean toReturn = true;
		Stack<Character> stack = new Stack<>();
		for(Character c : str.toCharArray())
			stack.push(c);
		for(int i = 0 ; i < str.length() ; i++)
			if(str.charAt(i) != stack.pop())
				toReturn = false;
		return toReturn;
	}
	
	//HASHMAP
	private static void countChars(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character c : str.toCharArray())
		{
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}
		for(Character c : map.keySet())
			System.out.println("Character -> " + c + " | count = " + map.get(c));
	}
	
	private static TreeSet<Employee> getEmpByHighestSalary(HashSet<Employee> employees) {
		TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary() < o2.getSalary())
					return 1;
				else if(o1.getSalary() > o2.getSalary())
					return -1;
				return 0;
			}});
		set.addAll(employees);
		return set;
	}
	
	private static TreeSet<Employee> getEmpByLowestSalary(HashSet<Employee> employees) {
		TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary() > o2.getSalary())
					return 1;
				else if(o1.getSalary() < o2.getSalary())
					return -1;
				return 0;
			}});
		set.addAll(employees);
		return set;
	}
	
	private static void initEmployees(HashSet<Employee> employees) {
		employees.add(new Employee("Harold", 7000));
		employees.add(new Employee("Natalie", 12000));
		employees.add(new Employee("Rick", 9000));
		employees.add(new Employee("Rick", 9000));
	}
}
