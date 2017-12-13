package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class GetClient {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		//you will get nullpointerException if you want to get the record which is not there in table
		Object o = session.get(Student.class,444);
		Student st = (Student)o;

		System.out.println(st.getEmail());
		System.out.println(st.getId());
		System.out.println(st.getName());
		
		session.close();
		sf.close();
		System.out.println("select operation success");
	}
}
