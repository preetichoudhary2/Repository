package src.main.java.com.learning.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import src.main.java.com.learning.bean.Student;
import src.main.java.com.learning.bean.Subject;
import src.main.java.com.learning.bean.Teacher;
import src.main.java.com.learning.bean.User;
import src.main.java.com.learning.bean.Class;

public class DBConnect{

	private DataSource dataSource;

	public DBConnect(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM users";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
			

				// create new student object
				User tempUser = new User(id, username, password);

				// add it to the list of students
				users.add(tempUser);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return users;

	}
	
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<Student>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM students";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");
				int aclass = myRs.getInt("class");

				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, age, aclass);

				// add it to the list of students
				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<Teacher>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM teachers";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");

				// create new student object
				Teacher temp = new Teacher(id, firstName, lastName, age);

				// add it to the list of students
				teachers.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return teachers;

	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<Subject>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM subjects";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String shortcut = myRs.getString("shortcut");

				// create new student object
				Subject temp = new Subject(id, name,shortcut);

				// add it to the list of students
				subjects.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return subjects;

	}

	public List<Class> getClasses() {

		List<Class> classes = new ArrayList<Class>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM classes";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				int section = myRs.getInt("section");
				int subject = myRs.getInt("subject");
				int teacher = myRs.getInt("teacher");
				String time = myRs.getString("session");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();

				// create new student object
				Class temp = new Class(id, section, teacher_name, tempSubject.getName(), time);

				// add it to the list of students
				classes.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return classes;

	}

	public Teacher loadTeacher(int teacherId) {

		Teacher theTeacher = null;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM teachers WHERE id = " + teacherId;
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String fname = myRs.getString("fname");
				String lname = myRs.getString("lname");
				int age = myRs.getInt("age");
				theTeacher = new Teacher(id, fname, lname, age);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return theTeacher;

	}

	public Subject loadSubject(int subjectId) {

		Subject theSubject = null;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String shortcut = myRs.getString("shortcut");

				theSubject = new Subject(id, name,shortcut);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return theSubject;

	}

	public Class loadClass(int classId) {

		Class theClass = null;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM clasess WHERE id = " + classId;
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				int section = myRs.getInt("section");
				int subject = myRs.getInt("subject");
				int teacher = myRs.getInt("teacher");
				String time = myRs.getString("session");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return theClass;

	}

	public List<Student> loadClassStudents(int classId) {

		List<Student> students = new ArrayList<Student>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// get a connection
			myConn = dataSource.getConnection();

			// create sql stmt
			String sql = "SELECT * FROM students WHERE class = " + classId;
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");
				int aclass = myRs.getInt("class");

				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, age, aclass);
				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return students;

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}