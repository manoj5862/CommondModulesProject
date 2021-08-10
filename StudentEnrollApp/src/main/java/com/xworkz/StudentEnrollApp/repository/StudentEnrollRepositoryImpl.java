package com.xworkz.StudentEnrollApp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;
@Repository
public class StudentEnrollRepositoryImpl implements StudentEnrollRepository {
	
	@Autowired
	private SessionFactory factory;

   	public StudentEnrollRepositoryImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	@Override
	public boolean SaveToDb(StudentEnrollEntity enrollEntity) {
		System.out.println("Invoked Repository save method");
		Session session = factory.openSession();
		try {
			Transaction transaction= session.beginTransaction();
			session.save(enrollEntity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			Transaction transaction = session.getTransaction();
			transaction.rollback();
			return false;
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("Session closed");
			}else {
			System.out.println("session is not closed");
			}
		}
		
		
	}

}
