package com.xworkz.vaccination.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.AddMemberEntity;

@Repository
public class EditMemberDAOImpl implements EditMemberDAO {

	@Autowired
	private SessionFactory factory;

	public EditMemberDAOImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public List<AddMemberEntity> getListOfMembers() {
		System.out.println("Invoked getListOfMembers");
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
	public void updateRecordByName(AddMemberEntity addMemberEntity) {
		System.out.println("Created "+this.getClass().getSimpleName());
		Session session = null;
		try {

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateAddMemberEntityByName")
			.setParameter("Aadhaar", addMemberEntity.getAadhar())
			.setParameter("Gender", addMemberEntity.getGender())
			.setParameter("vaccineType", addMemberEntity.getVaccineType())
			.setParameter("nm", addMemberEntity.getName()).executeUpdate();
			session.getTransaction().commit();
			System.out.println("Updated Successfully");

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
