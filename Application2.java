/* count(),anyMatch(),findFirst() */
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;
class Application2
{
		public static void main(String[] args)
		{
				ArrayList<Employee> Emp = new  ArrayList<>();
				Emp.add(new Employee("Abhi",20000.0));
				Emp.add(new Employee("Vikram",30000.0));
				Emp.add(new Employee("Vishnu",40000.0));
				Emp.add(new Employee("Maruthi",50000.0));
				Emp.add(new Employee("Sravan",60000.0));
				Emp.add(new Employee("Goutham",80000.0));
				Emp.add(new Employee("Balu",70000.0));
				
				
				double totalSalary = Emp.stream()
														 .mapToDouble(Employee :: grtSal)
														 .sum();
				System.out.println("Total Amount :  "+ totalSalary);	
				
				
				long nOfEmp= Emp.stream()
									          .count();
				 System.out.println("Number of emp's  :  "+ nOfEmp);
				 
				 
				double avgEmp= Emp.stream()
													.mapToDouble(Employee :: grtSal)
													.average()
													.orElse(0.0);										
				System.out.println("Average of emp's  :  "+ avgEmp);	


				Optional<Employee> highestEarner = Emp.stream()
                                            .max(Comparator.comparing(Employee :: grtSal));
				System.out.println("Highest Earnings  :  "+ highestEarner.orElse(null));
				
				
				Employee lowEarner = Emp.stream()
                                            .min(Comparator.comparing(Employee :: grtSal))
											.orElse(null);
				System.out.println("Lowest Earnings  :  "+ lowEarner);
				
				
				List<Employee> sortedEmps = Emp.stream()
                                     .sorted(Comparator.comparing(Employee::grtSal))
									 .peek(x -> System.out.println(x.getName()))
                                     .collect(Collectors.toList());
			  // System.out.println("\nsorted list  :  "+ sortedEmps);						 
									 
									 
				List<Employee> sortedEmpsRev = Emp.stream()
                                     .sorted(Comparator.comparing(Employee::grtSal).reversed())
                                     .collect(Collectors.toList());
			   System.out.println("Sorted reverse order  :  "+ sortedEmpsRev);
			   
			   
			   // Skips the first 1results, and grabs the next position(1)
				List<Employee> pageThree = Emp.stream()
									.sorted(Comparator.comparing(Employee::grtSal).reversed())
                                    .skip(1)
									.limit(1)
                                    .collect(Collectors.toList());
				 System.out.println("Second highestEarner :  "+ pageThree.get(0).getName());	


			/*	List<Employee> sortedEmpRev = Emp.stream()
                                     .sorted(Comparator.comparing(Employee::grtSal).reversed())
									 .peek(x -> System.out.println(x))
                                     .collect(Collectors.toList());
									 */
									 
									 
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
