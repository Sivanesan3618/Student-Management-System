package DAO;

import java.util.List;

import DTO.Student;

public interface StudentDAO {
	void addStudent(Student student);
	List getAllStudents();
	Student getStudentById(int id);
	void updateStudent(Student student);
	void deleteStudent(int id);
	List searchByName(String name);
	List searchByAgeRange(int minAge,int maxAge);
	int countStudents();

}
