package exercise;

public class Student implements Comparable{
	private int rollno;
	private String name;
	private String stream;
	
	
	public Student(int rollno, String name, String stream) {
		this.rollno = rollno;
		this.name = name;
		this.stream = stream;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	@Override
	public int compareTo(Object o) {
		Student s=(Student)o;
		String name1=s.getName();
		String name2=this.getName();
		
		return name2.compareTo(name1);
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", stream="
				+ stream + "]\n";
	}
	
	

}
