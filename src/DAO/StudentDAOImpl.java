package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import DTO.Student;

public class StudentDAOImpl implements StudentDAO {

	ArrayList arr=null;
	Connection con=ConnectionFactory.getConnection();
	PreparedStatement pstmt=null;
	ResultSet res=null;
	@Override
	public void addStudent(Student student) {
		try {
			
			String q="insert into student (student_id,name,email,phone,age)values(?,?,?,?,?)";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1, student.getStudent_id());
			pstmt.setString(2, student.getName());
			pstmt.setString(3,student.getEmail() );
			
			pstmt.setString(4, student.getPhone());
			pstmt.setInt(5, student.getAge());
			pstmt.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAllStudents() {
		try {
			arr=new  <Student> ArrayList();
	
			CallableStatement pst=con.prepareCall("{CALL getStu}");
			res=pst.executeQuery();
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				String phone=res.getString(4);
				int age=res.getInt(5);
				arr.add(new Student(id,name,email,phone,age));
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return arr;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student s1=null;
		try {
			String q="select * from student where student_id=?";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				
				int id1=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				String phone=res.getString(4);
				int age=res.getInt(5);
				s1=new Student(id1,name,email,phone,age);
			}
			else {
				System.out.println("Record not Found");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		return s1;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			String q="update student set name=?,email=?,phone=?,age=? where student_id=?";
			pstmt=con.prepareStatement(q);
			
			pstmt.setInt(5,student.getStudent_id());
			pstmt.setString(1,student.getName());
			pstmt.setString(2,student.getEmail());
			pstmt.setString(3,student.getPhone());
			pstmt.setInt(4, student.getAge());
			pstmt.execute();
			
		}
		catch(Exception p) {
			p.printStackTrace();
		}
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		try {
			String q="delete from student where student_id=?";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1, id);
			pstmt.execute();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List searchByName(String name) {
		arr=new <Student> ArrayList();
		// TODO Auto-generated method stub
		try {
			String q="select * from student where name like ?";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1, (name)+"%");
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt(1);
				String name1=res.getString(2);
				String email=res.getString(3);
				String phone=res.getString(4);
				int age=res.getInt(5);
				arr.add(new Student(id,name1,email,phone,age));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return arr;
	}

	@Override
	public List searchByAgeRange(int minAge, int maxAge) {
		arr=new <Student> ArrayList();
		// TODO Auto-generated method stub
		try {
			String q="select * from student where age between ? and ?";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1, minAge);
			pstmt.setInt(2, maxAge);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt(1);
				String name1=res.getString(2);
				String email=res.getString(3);
				String phone=res.getString(4);
				int age=res.getInt(5);
				arr.add(new Student(id,name1,email,phone,age));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return arr;
	}

	@Override
	public int countStudents() {
		int count=0;
		try {
			Statement stmt=con.createStatement();
			String q="select count(*) from student";
			res=stmt.executeQuery(q);
			if(res.next()) {
				count=res.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return count;
	}
	

}
