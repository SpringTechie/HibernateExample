package com.springtechie.HbernateDemo;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	
	private static  SessionFactory sessionfactory= null;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionfactory == null) {
			
			Configuration con = new Configuration();
			Properties props = new Properties();
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/student_db");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "root@1");
			props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			props.put(Environment.SHOW_SQL, true);
			props.put(Environment.HBM2DDL_AUTO, "update");
			con.setProperties(props);
			con.addAnnotatedClass(Student.class);
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
			sessionfactory = con.buildSessionFactory(standardServiceRegistry);
		}
		
		return sessionfactory;
	}

}
