package com.xworkz.vaccination.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.RegisterEntity;

@Repository
public class VaccinationOTPDAOImpl implements VaccinationOTPDao {

	@Autowired
	private SessionFactory factory;

	public VaccinationOTPDAOImpl() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@Override
	public RegisterEntity verifyEmailFromDBByEmail(String email) {
		try {
			Session session = this.factory.openSession();
			org.hibernate.Query<RegisterEntity> query = session.createNamedQuery("GetRecordByMail");
			query.setParameter("em", email);
			RegisterEntity entity = query.uniqueResult();
			return entity;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception "+e.getMessage());
			return null; 
		}

		
	}

}
