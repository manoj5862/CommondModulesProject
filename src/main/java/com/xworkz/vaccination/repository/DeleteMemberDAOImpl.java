package com.xworkz.vaccination.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteMemberDAOImpl implements DeleteMemberDAO {

	@Autowired
	private SessionFactory factory;
	
	public DeleteMemberDAOImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	@Override
	public boolean deleteMemberByName(String name) {
		System.out.println("Invoked deleteMemberByName");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("deleteMemberByName").setParameter("nm", name).executeUpdate();
			session.getTransaction().commit();
			System.out.println("Updated Successfully");
            return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("You have an exception " + e.getMessage());
			return false;
		} finally {
			if (session != null) {
				session.close();
			}

		}
		
	}

}
