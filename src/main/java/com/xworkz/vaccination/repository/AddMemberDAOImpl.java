package com.xworkz.vaccination.repository;

import java.util.List;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.AddMemberEntity;
@Repository
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory factory;
	
	public AddMemberDAOImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@Override
	public boolean AddMemberDTOSave(AddMemberEntity addMemberEntity) {
		System.out.println("Invoked AddMemberDTOSave");
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(addMemberEntity);
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

	@Override
	public List<AddMemberEntity> FetchAllEntities() {
		System.out.println("Invoked FetchAllEntities");
		List<AddMemberEntity> listOfEnrollEntities = null;
		Session session = null;
		try {
			session = this.factory.openSession();
			String hql = "from AddMemberEntity";
			Query<AddMemberEntity> query = session.createQuery(hql);
			listOfEnrollEntities = query.list();
			return listOfEnrollEntities;
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
	public int CheckAddMemberCountByMail(String emailId) {
		System.out.println("Invoked CheckAddMemberCountByMail");
		Session session = null;
		try {
			session = factory.openSession();
			Query<Object> query = session.getNamedQuery("getNoOfCheckAddmembersByMail");
			query.setParameter("em", emailId);
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
		return 0;

	}

	@Override
	public void updateAddMemberCountByEmailId(int addMemberCount,  String emailId) {
		System.out.println("Invoked updateAddMemberCountByEmailId");
		Session session = null;
		try {

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateAddMemberCountByEmail").setParameter("addMemberCount", addMemberCount)
					.setParameter("emailId", emailId).executeUpdate();
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
		
}
