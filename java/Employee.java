package exercise;

public class Employee implements Comparable {

	private int id;
	private String name;
	private String designation;
	public Employee(int id, String name, String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}
//	@Override
//	public int compareTo(Object o) {
//		Employee e=(Employee)o;
//		String Designation1=e.getDesignation();
//		String Designation2=this.getDesignation();
//		
//		return Designation2.compareTo(Designation1);
//	}
	
	@Override
	public int compareTo(Object o)
	{
		Employee e=(Employee)o;
		int Id1=e.id;
		int Id2=id;
		return Id2-Id1;
	}
}
