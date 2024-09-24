package com.hibernateOperation.CrudOperation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Operation {
Scanner sc=new Scanner(System.in);	
	Session getSession() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session sess=factory.openSession();
//		System.out.println(factory.isClosed());
		return sess;
		
	}
	
	void Insert() {
		Session session=getSession();
		System.out.println("Enter id of student");
		int sid=sc.nextInt();
		System.out.println("Enter name of student");
		String sname=sc.next();
		System.out.println("Enter city of student");
		String scity=sc.next();
		
		Transaction ts=session.beginTransaction();
		Student s1=new Student();
		s1.setSid(sid);
		s1.setSname(sname);
		s1.setScity(scity);
//		Student s1=new Student(105,"Savita","Bhosari");
		session.save(s1);
		ts.commit();
		System.out.println("Inserted");
		
	}
	void update() {
		System.out.println("Enter the id which you want to update");
		int sid=sc.nextInt();
		System.out.println("Enter new  name of student");
		String sname=sc.next();
		System.out.println("Enter new city of student");
		String scity=sc.next();
		
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Student s2=session.load(Student.class,sid);
		s2.setSname(sname);
		s2.setScity(scity);
		ts.commit();
		System.out.println("Updated");
		
	}
	void delete() {
		
		System.out.println("Enter id which you want to delete");
		int sid=sc.nextInt();
		
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Student s3=session.load(Student.class,sid);
		session.delete(s3);
		ts.commit();
		System.out.println("Deleted");
	}
	void show()
	{
		System.out.println("Enter id which you want to show data");
		int sid=sc.nextInt();
		Session session=getSession();
		Student s4=session.load(Student.class,sid);
		System.out.println(s4);
		}
	void search() {
		// for finf the particular data use critria
		System.out.println("Enter the city");
		String city=sc.next();
		Session session=getSession();
		Criteria crc=session.createCriteria(Student.class);
		crc.add(Restrictions.eq("scity", city));
		List<Student> sl =crc.list();
		for(Student s:sl)
			System.out.println(s);
	}
	
	void showName() {
//		use PRojection and criteria
		Session session=getSession();
		Criteria crc=session.createCriteria(Student.class);
		Projection pro=Projections.property("sname");
		crc.setProjection(pro);
		List<String> stu_name=crc.list();
		for(String n:stu_name) {
			System.out.println(n);
		}
		
	}
	void showCity()
	{
		
		Session session=getSession();
		Criteria crc=session.createCriteria(Student.class);
		Projection pro=Projections.property("scity");
		crc.setProjection(pro);
		List<String> stu_city= crc.list();
		for(String c:stu_city)
			System.out.println(c);
		
	}
	void showInfoStud()
	{
		System.out.println("Enter the name of student that you want to see info");
		String name=sc.next();
		Session session=getSession();
		Criteria crc=session.createCriteria(Student.class);
		crc.add(Restrictions.eq("sname",name));
		List<Student> sinfo=crc.list();
		for(Student si:sinfo) {
			System.out.println(si);
		}

	}
	void showGreater() {
		System.out.println("Enter the id ");
		int id=sc.nextInt();
		Session session=getSession();
		Criteria crc=session.createCriteria(Student.class);
		crc.add(Restrictions.gt("sid", id));
		List<Student> GreaterID=crc.list();
		for(Student gid:GreaterID)
			System.out.println(gid);
	}
	void showAllData()
	{	Session session =getSession();
		Criteria crc=session.createCriteria(Student.class);
		List<Student> all=crc.list();
		for(Student all_data:all)
			System.out.println(all_data);
		
	}
	
}



