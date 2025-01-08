package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Employee;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = ("update Employee set Domain =: dom, salary =: sal where empID =: id");
		MutationQuery mtQuery = ss.createMutationQuery(hqlQuery);
		mtQuery.setParameter("dom", "FullStack Devloper");
		mtQuery.setParameter("sal", 60000);
		mtQuery.setParameter("id", 1);
		mtQuery.executeUpdate();
		tr.commit();

		System.out.println("Data is updated successufully...");
		ss.close();

	}

}
