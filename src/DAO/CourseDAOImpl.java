package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import DTO.Course;
import DTO.Student;

public class CourseDAOImpl implements CourseDAO {

	ArrayList arr=null;
	Connection con=ConnectionFactory.getConnection();
	PreparedStatement pstmt=null;
	ResultSet res=null;
	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
       try {
			
			String q="insert into course (course_id,course_name,duration,fees)values(?,?,?,?)";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1,course.getCourseId() );
			pstmt.setString(2,course.getCourseName() );
			pstmt.setString(3,course.getDuration() );
			pstmt.setDouble(4, course.getFees());
			pstmt.execute();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List getAllCourses() {
		try {
			arr=new  <Course> ArrayList();
		
			Statement stmt=con.createStatement();
			String q="select * from course";
			res=stmt.executeQuery(q);
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				String duration=res.getString(3);
				Double fees=res.getDouble(4);
				
				arr.add(new Course(id,name,duration,fees));
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return arr;
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		Course s1=null;
		try {
			String q="select * from course where course_id=?";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				
				int id1=res.getInt(1);
				String name=res.getString(2);
				String duration=res.getString(3);
				double fees=res.getDouble(4);
				
				s1=new Course(id1,name,duration,fees);
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
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			String q="update course set course_name=?,duration=?,fees=? where course_id=?";
			pstmt=con.prepareStatement(q);
			
			pstmt.setInt(4,course.getCourseId());
			pstmt.setString(1,course.getCourseName());
			pstmt.setString(2,course.getDuration());
			pstmt.setDouble(3,course.getFees());
			pstmt.execute();
			
		}
		catch(Exception p) {
			p.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		try {
			String q="delete from course where course_id=?";
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
		// TODO Auto-generated method stub
		arr=new <Course> ArrayList();
		try {
			String q="select * from course where course_name like ?";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1, (name)+"%");
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt(1);
				String name1=res.getString(2);
				String duration=res.getString(3);
				double fees=res.getDouble(4);
				arr.add(new Course(id,name1,duration,fees));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return arr;
	}

	@Override
	public List searchByDuration(String duration) {
		// TODO Auto-generated method stub
		arr=new <Course> ArrayList();
		try {
			String q="select * from course where duration like ?";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1, (duration)+"%");
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt(1);
				String name=res.getString(2);
				String duration1=res.getString(3);
				double fees=res.getDouble(4);
				arr.add(new Course(id,name,duration1,fees));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return arr;
	}

	@Override
	public List searchByFeeRange(double min, double max) {
		// TODO Auto-generated method stub
		arr=new <Course> ArrayList();
		try {
			String q="select * from course where fees between ? and ?";
			pstmt=con.prepareStatement(q);
			pstmt.setDouble(1, min);
			pstmt.setDouble(2, max);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt(1);
				String name1=res.getString(2);
				String duration=res.getString(3);
				Double fees=res.getDouble(4);
				
				arr.add(new Course(id,name1,duration,fees));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return arr;
	}

	@Override
	public int countCources() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Statement stmt=con.createStatement();
			String q="select count(*) from course";
			res=stmt.executeQuery(q);
			if(res.next()) {
				count=res.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
