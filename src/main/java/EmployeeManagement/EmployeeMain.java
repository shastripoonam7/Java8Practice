package EmployeeManagement;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList();
		
		employeeList.add(new Employee(1, "Mac", 'M', "IT", 2020, 20000,22));
		employeeList.add(new Employee(2, "Jecily", 'F', "Marketing", 2019, 200000,25));
		employeeList.add(new Employee(3, "Marry", 'F', "IT", 2020, 23440,23));
		employeeList.add(new Employee(4, "Kristen", 'M', "Product Development", 2020, 17000,45));
		employeeList.add(new Employee(5, "Harry", 'M', "IT", 2020, 45000,21));
		employeeList.add(new Employee(6, "Rohn", 'M', "Marketing", 2020, 21001,29));
		employeeList.add(new Employee(7, "Sezal", 'F', "Product Development", 2009, 17000,25));
		employeeList.add(new Employee(8, "Ryan", 'M', "Sales", 2020, 4000000,55));
		employeeList.add(new Employee(9, "Tammanna", 'F', "IT", 2009, 21001,21));
		employeeList.add(new Employee(10, "Shreyas", 'M', "Product Development", 2009, 17000,21));
		employeeList.add(new Employee(11, "Potter", 'M', "Sales", 2009, 17000,21));
		employeeList.add(new Employee(12, "Hermione", 'F', "Marketing", 2009, 17000,29));
		
		System.out.println("1. Total no of males and females in the organization:"+getMaleFemaleCount(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("2. Name of all departments in the organization:"+getDepartmentNames(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("3. Average age of male and female employees:"+getAvgAgeOfMaleFemale(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("4. Details of highest paid employee in the organization:"+getHighestPaidEmployee(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("5. Employees who have joined after 2015:"+getEmployeesJoinedAfter(2015,employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("6. Count no of employees in each department:"+getCountOfEmpByDepartment(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("7. Avg salary in each department"+getAvgSalaryByDepartment(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("8. Youngest male employee in the product development department:"+youngestEmpInProdDept(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("9. Most work experience in the organization:"+mostExperienceEmployee(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("10. Male and female Employee in Sales and Marketing Team:"+countMaleFemaleEmpInSalesAndMarketing(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("11. Avg salary of Male and Female Employee"+avgSalaryOfMaleAndFemaleEmp(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("12. Names of employees in each Department:"+listNameOfEmpByDepartment(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("13. Average Salary of Whole organization:"+avgSalaryOfWholeOrganization(employeeList));
		
		System.out.println("13. Total salary od whole organization:"+totalSalaryOfWholeOrganization(employeeList));
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("14. Separated List of Employee who are greater than 25 and employee less or equal to 25:");
		separateListAccordingToAge(25,employeeList);
		System.out.println("------*---------*-------*-----*------");
		
		System.out.println("15. oldest employee:-");
		 oldestEmployeeOfOrganization(employeeList);
		
	
	}

	

	private static void separateListAccordingToAge(int age, List<Employee> employeeList) {
		// TODO Auto-generated method stub
		List<List<Employee> > lists = new ArrayList<>(
				employeeList.stream()
	                .collect(Collectors.partitioningBy(
	                    s ->s.getAge()<=25))
	                .values());
		System.out.println("List of employees below and 25:");
		lists.get(0).forEach(System.out::println);
		System.out.println("List of employees above 25:");
		lists.get(1).forEach(System.out::println);
		
		
	}



	private static void oldestEmployeeOfOrganization(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		Employee employee = employeeList.stream().max((e1,e2)->e1.getAge()>e2.getAge()?1:-1).get();
		System.out.println("Name:"+employee.getName()+", Department:"+employee.getDepartment()+", Age:"+employee.getAge());
		
	}



	private static int totalSalaryOfWholeOrganization(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().mapToInt(e->e.getSalary()).sum();
	}



	private static double avgSalaryOfWholeOrganization(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().mapToInt(e1->e1.getSalary()).average().getAsDouble();
	}



	private static Map<String,List<String>> listNameOfEmpByDepartment(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
	}



	private static Map<Character,Double> avgSalaryOfMaleAndFemaleEmp(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(n->n.getSalary())));
	}



	private static Map<String,Long> countMaleFemaleEmpInSalesAndMarketing(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		List<Character> genderList = Arrays.asList('F','M');
		List<String> deptList = Arrays.asList("Sales","Marketing");
		return employeeList.stream().filter(e->genderList.contains(e.getGender()) && deptList.contains(e.getDepartment())).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	}



	private static Employee mostExperienceEmployee(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().max((e1,e2)->e1.getYearOfJoining()>e2.getYearOfJoining()?1:-1).get();
	}



	private static Employee youngestEmpInProdDept(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().filter(e->e.getGender()=='M' && e.getDepartment().equals("Product Development")).min((e1,e2)->e1.getAge()>e2.getAge()?1:-1).get();
	}



	private static Map<String,Double> getAvgSalaryByDepartment(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)));
	}
	
	private static Map<Character,Double> getAvgAgeOfMaleFemale(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
	}



	private static Map<String,Long> getCountOfEmpByDepartment(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	}



	private static List<Employee> getEmployeesJoinedAfter(int year, List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().filter(n->n.getYearOfJoining()>year).collect(Collectors.toList());
	}



	private static Employee getHighestPaidEmployee(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().max((a,b)->a.getSalary()>b.getSalary()?1:-1).get();
	}



	private static OptionalDouble getAverageAgeOfFemaleEmployee(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		
		return employeeList.stream().filter(n->n.getGender()=='F').map(n->n).mapToInt(n->n.getAge()).average();
		
	}



	private static OptionalDouble getAverageAgeOfMaleEmployee(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return  employeeList.stream().filter(n->n.getGender()=='M').map(n->n).mapToInt(n->n.getAge()).average();
		
	}



	private static List<String> getDepartmentNames(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return employeeList.stream().map(Employee::getDepartment).distinct().toList();
	}

	private static Map<Character,Long> getMaleFemaleCount(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		Map<Character,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		return map;
	}

}
