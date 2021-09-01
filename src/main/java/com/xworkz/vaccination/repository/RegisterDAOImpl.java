package com.xworkz.vaccination.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.RegisterEntity;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory factory;

	public RegisterDAOImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean regsiterDao(RegisterEntity entity) {
		System.out.println("Invoked Register Dao method");
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			Transaction transaction = session.getTransaction();
			transaction.rollback();
			return false;
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	
}
