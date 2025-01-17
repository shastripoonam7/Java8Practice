package EmployeeManagement;



public class Employee {
	
	private int id;
	private String name;
	private char gender;
	private String department;
	private int yearOfJoining;
	private int Salary;
	private int age;
	public Employee(int id, String name, char gender, String department, int yearOfJoining, int salary,int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.Salary = salary;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
				+ ", yearOfJoining=" + yearOfJoining + ", Salary=" + Salary + ", age=" + age + "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
	

}
