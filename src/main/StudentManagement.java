package main;

import java.util.List;
import java.util.Scanner;

import DAO.CourseDAOImpl;
import DAO.StudentDAOImpl;
import DTO.Course;
import DTO.Student;

public class StudentManagement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDAOImpl c=new CourseDAOImpl();
		StudentDAOImpl s=new StudentDAOImpl();
		
		int choice;
		do {
			System.out.println("========================================STUDENT MANAGEMENT SYSTEM========================================\nSTUDENT\n1. Add Student \n2. View All Students \n3. Find Student \n4. Update Student \n5. Delete Student \n6. Search Student by Name \n7. Search Student by Age \nCOURSE \n8. Add Course \n9. View All Courses \n10. Find Course \n11. Update Course \n12. Delete Course \n13. Search Course by Name \n14. Search Course by Fee \nREPORT \n15. Count Students \n16. Count Courses \n0. Exit\n========================================");
			System.out.println("ENTER YOUR CHOICE: ");
			choice=sc.nextInt();
			try {
				switch(choice) {
				 case 1:
					 System.out.println("Enter Student Id: ");
					 int id=sc.nextInt();
					 System.out.println("Enter Student Name: ");
					 String name=sc.next();
					 System.out.println("Enter Email: ");
					 String email=sc.next();
					 System.out.println("Enter Phone: ");
					 String phone=sc.next();
					 System.out.println("Enter Age: ");
					 int age=sc.nextInt();
					 s.addStudent(new Student(id,name,email,phone,age));
				      break;
				 case 2:
					List <Student> l1= s.getAllStudents();
					for(Student s1:l1) {
						System.out.println(s1);
					}
				      break;
				 case 3:
					 System.out.println("Enter Student Id: ");
					 int id1=sc.nextInt();
					 Student s2=s.getStudentById(id1);
					 System.out.println(s2);
				      break;
				 case 4:
					 System.out.println("Enter Student Id to Update: ");
					 int id2=sc.nextInt();
					 System.out.println("Enter New Name: ");
					 String name2=sc.next();
					 System.out.println("Enter New Email: ");
					 String email2=sc.next();
					 System.out.println("Enter New Phone: ");
					 String phone2=sc.next();
					 System.out.println("Enter New Age: ");
					 int age2=sc.nextInt();
					s.updateStudent(new Student(id2,name2,email2,phone2,age2));
				      break;
				 case 5:
					 System.out.println("Enter Student Id: ");
					 int id3=sc.nextInt();
					 s.deleteStudent(id3);
				      break;
				 case 6:
					 System.out.println("Enter Student Name: ");
					 String name4=sc.next();
					 List <Student> l2=s.searchByName(name4);
					 for(Student s1:l2) {
							System.out.println(s1);
						}
				      break;
				 case 7:
					 System.out.println("Enter Starting Age Range.");
					 int min=sc.nextInt();
					 System.out.println("Enter Ending Age Range.");
					 int max=sc.nextInt();
					 List <Student> l3=s.searchByAgeRange(min, max);
					 for(Student s1:l3) {
							System.out.println(s1);
						}
				      break;
				 case 8:
					 System.out.println("Enter Course Id: ");
					 int id5=sc.nextInt();
					 System.out.println("Enter Course Name: ");
					 String name5=sc.next();
					 System.out.println("Enter Course duration: ");
					 sc.nextLine();
					 String duration=sc.nextLine();
					 System.out.println("Enter Fees Amount: ");
					 double fees=sc.nextDouble();			 
					 c.addCourse(new Course(id5,name5,duration,fees));
				      break;
				 case 9:
					 List<Course> c1=c.getAllCourses();
					 for(Course l:c1) {
						 System.out.println(l);
					 }
				      break;
				 case 10:
					 System.out.println("Enter Course Id: ");
					 int id11=sc.nextInt();
					 Course c5=c.getCourseById(id11);
					 System.out.println(c5);
				      break;
				 case 11:
					 System.out.println("Enter Course Id to Update: ");
					 int id22=sc.nextInt();
					 System.out.println("Enter New Course Name: ");
					 String name22=sc.next();
					 System.out.println("Enter New Duration: ");
					 sc.nextLine();
					 String duration22=sc.nextLine();
					 System.out.println("Enter New Fees Amount: ");
					 double fees22=sc.nextDouble();
					 c.updateCourse(new Course(id22,name22,duration22,fees22));
				      break;
				 case 12:
					 System.out.println("Enter Course Id: ");
					 int id33=sc.nextInt();
					 c.deleteCourse(id33);
				      break;
				 case 13:
					 System.out.println("Enter Course Name: ");
					 String name44=sc.next();
					 List<Course> c2=c.searchByName(name44);
					 for(Course l:c2) {
						 System.out.println(l);
					 }
				      break;
				 case 14:
					 System.out.println("Enter Starting Fees Range.");
					 double min1=sc.nextDouble();
					 System.out.println("Enter Ending Fees Range.");
					 double max1=sc.nextDouble();
					List<Course>c8= c.searchByFeeRange(min1, max1);
					 for(Course l:c8) {
						 System.out.println(l);
					 }
				      break;
				 case 15:
					int c4= s.countStudents();
					System.out.println("Total Students Count: "+c4);
				      break;
				 case 16:
					 int c9=c.countCources();
					 System.out.println("Total Course Count: "+c9);
				      break;
				 case 0:
					 System.out.println("THANK YOU FOR USING STUDENT MANAGEMENT SYSTEM.");
				     break;
				  default:
					  System.out.println("Invalid Choice.");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(choice!=0) {
				System.out.println("Operation Completed");
				}
			}
			
			
		}
		while(choice!=0);
		sc.close();
	}

}
