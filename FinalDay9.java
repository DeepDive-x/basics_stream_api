import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FinalDay9 {
    public static void main(String[] args) {
        
        // The Upgraded Database
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Abhi", "IT", 20000.0));
        empList.add(new Employee("Vikram", "HR", 30000.0));
        empList.add(new Employee("Vishnu", "IT", 40000.0));
        empList.add(new Employee("Maruthi", "Finance", 50000.0));
        empList.add(new Employee("Sravan", "HR", 60000.0));

        System.out.println("--- 1. THE JOINING OPERATION ---");
 
        String itTeam = empList.stream()
                               .filter(e -> e.getDept().equals("IT"))
                               .map(Employee::getName)
                               .collect(Collectors.joining(", ", "IT Team: [", "]"));
        System.out.println(itTeam); 
 


        System.out.println("\n--- 2. THE GROUPING OPERATION ---");
        // Creates a Map where Key = Department, Value = List of Employees in that dept
        Map<String, List<Employee>> groupedByDept = empList.stream()
                               .collect(Collectors.groupingBy(Employee::getDept));
        
        System.out.println("HR Department: " + groupedByDept.get("HR"));
        System.out.println("Finance Department: " + groupedByDept.get("Finance"));


        System.out.println("\n--- 3. THE OPTIONAL PANIC BUTTON ---");
        // Goal: Search for an employee named "Zack". If not found, crash gracefully.
        System.out.println("Searching for Zack in the database...");
        
        Employee missingUser = empList.stream()
                                      .filter(e -> e.getName().equals("Zack"))
                                      .findFirst()
                                      // The moment of truth:
                                      .orElseThrow(() -> new RuntimeException("CRITICAL 404: User Zack does not exist in the system!"));
        
        // This line will NEVER print, because the line above stops the program!
        System.out.println(missingUser); 
    }
}

class Employee {
    private String name;
    private String dept;
    private double salary;
    
    public Employee(String nm, String dept, Double sl) {
        this.name = nm;
        this.dept = dept;
        this.salary = sl;
    }
    
    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getSal() { return salary; } 
    
    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }		
}