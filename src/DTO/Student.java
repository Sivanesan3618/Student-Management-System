package DTO;

public class Student {
	private int studentId;
	private String name;
	private String email;
	private String phone;
	private int age;
	
	public Student() {
		super();
		
	}
	
	public Student(int student_id, String name, String email, String phone, int age) {
		super();
		this.studentId = student_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}
	public int getStudent_id() {
		return studentId;
	}
	public void setStudent_id(int student_id) {
		this.studentId = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "student Id:" + studentId + "\n  Name:" + name + "\n  Email:" + email + "\n  Phone:" + phone+ "\n  Age:" + age;
	}
	

}
