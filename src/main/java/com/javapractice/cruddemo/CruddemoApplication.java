package com.javapractice.cruddemo;

import com.javapractice.cruddemo.dao.BookDao;
import com.javapractice.cruddemo.dao.SportDao;
import com.javapractice.cruddemo.dao.StudentDao;
import com.javapractice.cruddemo.dao.StudentDaoImpl;
import com.javapractice.cruddemo.entity.Book;
import com.javapractice.cruddemo.entity.Sport;
import com.javapractice.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao, SportDao sportDao, BookDao bookDao)
	{
		return runner-> {

			/* Student Operations*/
			createStudent(studentDao);
//			readAllStudent(studentDao);
//			readStudentByName(studentDao);
//			removeAllStudents(studentDao);

			/* Book Operations*/

			createBook(bookDao);
//			readBook(bookDao);
//			readAllBook(bookDao);
//			readBookByName(bookDao);
//			updateBookNames(bookDao);
//			removeBook(bookDao);

			/* Sport Operations*/
			createSport(sportDao);
//			readAllSport(sportDao);
//			readSportByName(sportDao);
//			removeSport(sportDao);
		};
	}

	private void removeAllStudents(StudentDao studentDao) {
		System.out.println("Removing All Students...");

		int s=studentDao.removeAllStudents();
		System.out.println("Total Students Removed:- "+s);
	}

	private void removeSport(SportDao sportDao) {
		int id=3;

		System.out.println("Removing Sport from the list...");
		sportDao.deleteSport(id);

		System.out.println("Removed!! Updated Sport List:- ");
		List<Sport> sport= sportDao.findAllSports();
		for(Sport sport1:sport)
		{
			System.out.println(sport1);
		}
	}

	private void removeBook(BookDao bookDao) {

		int id=3;
		System.out.println("Removing Book from the list...");
		bookDao.delete(id);
		List<Book> bk=bookDao.findAll();
		System.out.println("Removed.. Updated Book List: -");
		for(Book bk1:bk)
		{
			System.out.println(bk1);
		}

	}

	private void updateBookNames(BookDao bookDao) {

		int booknumber=5;
		System.out.println("Getting Student by ID...");
		Book book=bookDao.findbyID(booknumber);

		System.out.println("Updating Student having Id  "+book.getBnumber() + "...." );
		book.setBname("Natsamrat");

		bookDao.updateBookName(book);

		System.out.println("Updated!! New Book Details : -  "+book);


	}

	private void readStudentByName(StudentDao studentDao) {

		List<Student> st=studentDao.findStudentByName("Rohit");
		System.out.println("Retrieving Student Details...");
		for (Student st1:st)
		{
			System.out.println(st1);
		}

		System.out.println("Retrieving Student Details...");
	}

	private void readSportByName(SportDao sportDao) {

		List<Sport> sports=sportDao.findSportbyName("National");
		System.out.println("Retrieving Sport Details by Name...");
		for (Sport sprt:sports)
		{
			System.out.println(sprt);
		}

		System.out.println("Retrieved Sport Details!!");
	}

	private void readBookByName(BookDao bookDao) {

		List<Book> bk=bookDao.findByName("Mrytunjay");
		System.out.println("Retrieving book details by Name...");
		for (Book bk1:bk)
		{
			System.out.println(bk1);
		}

		System.out.println("Retrieved Book Details Successfully!!");

	}

	private void readAllSport(SportDao sportDao) {

		List<Sport> sports=sportDao.findAllSports();
		System.out.println("Retrieving all the Sports Info...");
		for(Sport sports1:sports)
		{
			System.out.println(sports1);
		}
		System.out.println("Retrieved All the Sports Data Successfully!!!");
	}

	private void readAllStudent(StudentDao studentDao) {
		List<Student> st=studentDao.findAll();

		System.out.println("Retrieving all the Students...");
		for (Student st1:st)
		{
			System.out.println(st1);

		}
		System.out.println("All Students Retrieved Successfully!!");
	}

	private void readAllBook(BookDao bookDao) {

		List<Book> bk=bookDao.findAll();
		for (Book bk1:bk)
		{
			System.out.println(bk1);
		}
	}


	private void readBook(BookDao bookDao){

		Book bk=new Book("5 Points Someone","Chetan Bhagat");
		//Saving the Book Object
		bookDao.save(bk);
		System.out.println("Saved Book Successfully!!");


		System.out.println("Retrieving book by ID" +bk.getBnumber());

		//Finding Book By ID
		Book bk1=bookDao.findbyID(bk.getBnumber());

		System.out.println("Book Found " + bk1);


	}

	private void createBook(BookDao bookDao) {

		Book book=new Book("Mrytunjay","Shivaji Sawant");
		Book book1=new Book("Anubandh","Shanta Shelke");
		Book book2=new Book("You can win","Shiv Khera");

		bookDao.save(book);
		bookDao.save(book1);
		bookDao.save(book2);
		System.out.println("Saved Book Data!! ");



	}

	private void createSport(SportDao sportDao) {
		Sport sport=new Sport("National","Football","test@msi.com");
		Sport sport1=new Sport("State","Badminton","test@msi.com");
		Sport sport2=new Sport("International","Music","test@msi.com");
		Sport sport3=new Sport("School","Kabaddi","test@msi.com");
		Sport sport4=new Sport("International","Hockey","test@msi.com");
		Sport sport5=new Sport("InterSchool","Chess","test@msi.com");
		sportDao.save(sport);
		sportDao.save(sport1);
		sportDao.save(sport2);
		sportDao.save(sport3);
		sportDao.save(sport4);
		sportDao.save(sport5);
		System.out.println("Saved All Sports Data!!");
	}



	private void createStudent(StudentDao studentDao) {

		//creating the Student Object
		Student st=new Student("Nitin","Marale","Nitin@Marale.com");
		Student st1=new Student("Vinay","Abitkar","Vinay@Abitkar.com");
		Student st2=new Student("Atharva","Gadgil","Atharva@Gadgil.com");
		Student st3=new Student("Rohit","Mali","Rohit@Mali.com");
		//Saving DB object
		studentDao.save(st);
		studentDao.save(st1);
		studentDao.save(st2);
		studentDao.save(st3);
		//Get Student Data
		System.out.println("Student ID :- \t"+st.getId() + "Student Name :- \t"+st.getFirstname());

	}
}
