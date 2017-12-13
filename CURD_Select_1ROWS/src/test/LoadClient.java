package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class LoadClient {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Object o = session.load(Student.class, 333);
		
		Student st = (Student)o;
		
		System.out.println(st.getId());
		System.out.println(st.getEmail());
		System.out.println(st.getName());
		
		session.close();
		sf.close();
		System.out.println("select operation success");
	}
}
