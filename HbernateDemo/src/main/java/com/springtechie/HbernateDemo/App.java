package com.springtechie.HbernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
	static  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main( String[] args )
    {
      
     //  saveObject();
    //   getObject();
      //updateObject();
//       deleteObject() ;
       
       getAllObject();
    }
    
    public static void saveObject() {
    	Session openSession = sessionFactory.openSession();
    	Transaction beginTransaction = openSession.beginTransaction();
    	Student s= new Student();
    	s.setName("raja");
    	s.setMarks(2);
    	openSession.save(s);
    	beginTransaction.commit();
    	openSession.close();
    	
    	
    	
    }
    public static void getObject() {
    	Session openSession = sessionFactory.openSession();
    
    	Student student = openSession.get(Student.class, 3);
    	Student student1 = openSession.get(Student.class, 3);
    	System.out.println(student);
    
    }
    public static void getAllObjectByName() {
    	Session openSession = sessionFactory.openSession();
    
     Query<Student> query = openSession.createQuery("from Student where name=:name",Student.class);
     Query<Student> sstudent = query.setParameter("name", "arun");
     Student uniqueResult = sstudent.uniqueResult();
     
    	System.out.println(uniqueResult);
    
    }
    
    public static void getAllObject() {
    	Session openSession = sessionFactory.openSession();
    
     List<Student> students = openSession.createQuery("from Student",Student.class).list();
   
    	System.out.println(students);
    
    }
    
    
    public static void updateObject() {
    	Session openSession = sessionFactory.openSession();
    	Transaction beginTransaction = openSession.beginTransaction();
    	Student student = openSession.get(Student.class, 1);
    	student.setMarks(34);
    	openSession.saveOrUpdate(student);
    	beginTransaction.commit();
    	openSession.close();
    	
    }
    public static void deleteObject() {
    	System.out.println(System.currentTimeMillis());
    	Session openSession = sessionFactory.openSession();
    	Transaction beginTransaction = openSession.beginTransaction();
    	Student student = openSession.get(Student.class, 1);
    
    	openSession.delete(student);
    	beginTransaction.commit();
    	openSession.close();
    	System.out.println(System.currentTimeMillis());
    	
  	
    }
}
