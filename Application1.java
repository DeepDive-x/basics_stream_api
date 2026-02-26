/*Returning a Dictionary (Map / HashMap)
 we have a list of Employee objects, and we want to instantly turn them into a HashMap where the Key is their ID, and the Value is their Name. */
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;
class Application1
{
	public static void main(String[] args)
	{
		ArrayList<Employee> Emp = new ArrayList<>();
		Emp.add(new Employee("Abhi",20000.0));
		Emp.add(new Employee("Vikram",30000.0));
		Emp.add(new Employee("Vishnu",40000.0));
		Emp.add(new Employee("Maruthi",50000.0));
		Emp.add(new Employee("Sravan",60000.0));
		Emp.add(new Employee("Goutham",80000.0));
		Emp.add(new Employee("Balu",70000.0));
		
		System.out.println("Before maping: "+ Emp);
		
		Map<String, Double>map = Emp.stream()
									 .filter(n -> n.grtSal()>30000)
									 .collect(Collectors.toMap(emp -> emp.getName(), emp -> emp.grtSal()));
		
        System.out.println("After Filtering : "+ map);		
									 
	}
}

class Employee
{
	private String name;
	private double salary;
	
	public Employee(String nm, Double sl)
	{
		this.salary=sl;
		this.name=nm;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double grtSal()
	{
		return salary;
	}
	
	public String toString()
	{
		return "\n"+name+" : "+salary;
	}		
}