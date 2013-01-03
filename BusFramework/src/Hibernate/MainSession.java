package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MainSession {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getFactory(){
		return sessionFactory;
	}
	public static void setUp() throws Exception {
		// A SessionFactory is set up once for an application
        sessionFactory = new Configuration()
                .configure("/Hibernate/hibernate.cfg.xml").buildSessionFactory(); // configures settings from hibernate.cfg.xml
                
	}


	public static void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
	public static void main(String[] args){
		MainSession session = new MainSession();
		try {
			session.setUp();
			session.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
