package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class DeleteData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "delete from Employee where empID =: id";
		Query<Employee> query = ss.createQuery(hqlQuery);  // ss.createMutationQuery()
		query.setParameter("id", 3);
		query.executeUpdate();
		tr.commit();

		System.out.println("Data is deleted successfully...");

		ss.close();
	}

}
