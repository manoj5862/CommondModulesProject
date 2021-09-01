package com.xworkz.vaccination.repository;

import java.util.Objects;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;

@Repository
public class VaccinationLoginDAOImpl implements VaccinationLoginDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public RegisterEntity getEmailByEntity(String email) {

		RegisterEntity enrollEntity = null;
		Object session = null;
		try {
			session = this.factory.openSession();
			Query<RegisterEntity> query = ((QueryProducer) session).createNamedQuery("GetRecordByMail");
			query.setParameter("em", email);
			enrollEntity = query.uniqueResult();
			return enrollEntity;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception " + e.getMessage());
			return null;
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void updateAttempt(int noOfUnsuccesfulLoginAttemps, String email) {
		Session session = null;
		try {

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateNoOfLoginAttempByEmail").setParameter("login", noOfUnsuccesfulLoginAttemps)
					.setParameter("emailId", email).executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("You have an exception " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@Override
	public Integer getNoOFLoginAttemptsByEmailId(String mail) {
		System.out.println("Invoked getNoOFLoginAttemptsByEmailId");
		Session session = null;
		try {
			session = factory.openSession();
			Query<Object> query = session.getNamedQuery("getNoOfLoginAttemptsByMail");
			query.setParameter("em", mail);
			Object object = query.uniqueResult();
			if (object != null) {
				Integer noOfLoginAttempts = (Integer) object;
				return noOfLoginAttempts;
			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;

	}

}
