/* Returning Collections (Lists & Sets) */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

class Application
{
	public static void main (String args[])
	{
		ArrayList<Integer> Emp = new ArrayList<>();
		Emp.add(101);
		Emp.add(102);
		Emp.add(103);
		Emp.add(104);
		Emp.add(105);
		Emp.add(105);
		Emp.add(102);
		Emp.add(103);
		
		List<Integer> listOfEmp= Emp.stream()
									.collect(Collectors.toList());
									
		Set<Integer> UniEmp = Emp.stream()
								 .collect(Collectors.toSet());
								 
		System.out.println("List of Employees: "+listOfEmp);
		System.out.println("Set of  Employees: "+UniEmp);
		
	}
}