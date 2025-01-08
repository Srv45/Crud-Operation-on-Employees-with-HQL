package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = ("insert into Employee(name,salary,Domain,address)values(:name, :salary, :domain, :address)");
		Query<Employee> query = ss.createNativeQuery(hqlQuery);
		query.setParameter("name", "Ayra");
		query.setParameter("salary", 40000);
		query.setParameter("domain", "FrontEnd Devloper");
		query.setParameter("address", "Motihari");
		query.executeUpdate();
		tr.commit();

		System.out.println("Data Inserted Successufully...");
		ss.close();
	}

}
