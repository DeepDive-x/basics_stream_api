import java.util.ArrayList;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Stream_questions
{
	public static void main(String [] args)
	{
		ArrayList<Employee> Emp = new ArrayList<>();
		Emp.add(new Employee("Abhi",2020,1,30000.0,"male","It"));
		Emp.add(new Employee("Bala",2022,2,40000.0,"female","It"));
		Emp.add(new Employee("Cherry",2020,3,50000.0,"male","Finance"));
		Emp.add(new Employee("Goutham",2019,4,60000.0,"male","Analytics"));
		Emp.add(new Employee("Esha",2023,5,30000.0,"female","Hr"));
		Emp.add(new Employee("Pranaya",2025,6,50000.0,"female","Finance"));
		Emp.add(new Employee("Maruthi",2020,7,30000.0,"male","Hr"));
		
		 //Print the names of all employees who joined the company after the year 2020.
		 List<Employee> Emp2020 = Emp.stream()
									.filter(x->x.getYear() >2020)
									.peek(x -> System.out.println(x))
									.collect(Collectors.toList());
		
		
		//.Find out exactly how many male and female employees are in the organization.
		Map<String, Long> genderCount = Emp.stream()
											.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
											
		System.out.println("=============Genders================");
		genderCount.forEach((key, value) -> System.out.println(key+"  ==>  "+value));
		
		
		//Print out a list of all the unique department names in the company (no duplicates).
		Set<String> departments = Emp.stream()
								.map(Employee::getDept)
								.collect(Collectors.toSet());
		System.out.println("=============Departments================");						
		departments.forEach((e) -> System.out.println(e));
	}
}
class Employee
{
	private String name;
	private int year;
	private int id;
	private double salary;
	private String gender; 
	private String Department;
	
	public Employee(String n, int y, int id, double sl, String gen,String Dept)
	{
		this.name=n;
		this.year=y;
		this.id=id;
		this.salary=sl;
		this.gender=gen;
		this.Department=Dept;
	}
	public int getYear(){return year;}
	public String getGender(){return gender;}
	public String getDept(){ return Department; }
	public String toString()
	{
		return "Name: "+name+"   empId: "+id+"    year: "+year+"    salary: "+salary;
	}
}