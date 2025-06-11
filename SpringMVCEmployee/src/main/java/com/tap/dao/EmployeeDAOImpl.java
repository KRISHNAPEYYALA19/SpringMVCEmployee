package com.tap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.Entity.Employee;
@Component
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;//object type variable so use @autowired
	@Override
	public void addEmployee(Employee e){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(e);
		transaction.commit();
		
	}

}
