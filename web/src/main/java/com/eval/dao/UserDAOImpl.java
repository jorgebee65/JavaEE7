package com.eval.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.eval.bo.UserBO;
import com.eval.builder.UserBuilder;
import com.eval.po.PhonePO;
import com.eval.po.UserPO;

public class UserDAOImpl extends BaseDAOImpl {

	@SuppressWarnings("unchecked")
	public List<UserBO> obtenerTodos() {
		List<UserPO> allUsers = null;
		List<UserBO> allUsersBO = null;
		try {
			super.entityManager.clear();
			super.entityManager.getTransaction();
			allUsers = (List<UserPO>) super.entityManager.createQuery("FROM UserPO").getResultList();
			if (allUsers != null) {
				allUsersBO = new ArrayList<UserBO>();
				for (UserPO po : allUsers) {
					allUsersBO.add(UserBuilder.crearUsuarioBO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsersBO;
	}

	public boolean delete(UserBO userBO) {
		try {
			super.entityManager.clear();
			UserPO userPO = entityManager.find(UserPO.class, userBO.getId());
			super.entityManager.getTransaction().begin();
			userPO.getKnowns().clear();
			super.entityManager.merge(userPO);
			super.entityManager.remove(userPO);
			super.entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			entityManager.clear();
			ex.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean update(UserBO userBO) {
		try {
			entityManager.clear();
			entityManager.getTransaction().begin();
			UserPO userPO = UserBuilder.crearUsuarioPO(userBO);
			//Phones
			List<PhonePO> oldPhones = null ;
			if(userPO.getPhones()!=null && !userPO.getPhones().isEmpty()){
			oldPhones = (List<PhonePO>)entityManager.createQuery("FROM PhonePO where owner = :user")
					.setParameter("user", userPO)
					.getResultList();
			for(PhonePO newP : userPO.getPhones()){
				if(oldPhones.contains(newP)){
					entityManager.merge(newP);
				}else{
					entityManager.persist(newP);
				}	
			}
			}
			//Known People
			if(userPO.getKnowns()!=null && !userPO.getKnowns().isEmpty()){
			List<Integer> ids = new ArrayList<Integer>();
			for(UserPO k : userPO.getKnowns()){
				ids.add(k.getId());
			}
			@SuppressWarnings("unchecked")
			List<UserPO> peopleBD = (List<UserPO>)entityManager.createQuery("FROM UserPO where id IN (:people)")
					.setParameter("people", ids)
					.getResultList();
			userPO.getKnowns().clear();
			userPO.getKnowns().addAll(peopleBD);
			}
			entityManager.merge(userPO);
			//RemoveOld
			if(oldPhones!=null){
				for(PhonePO oldP : oldPhones){
					if(!userPO.getPhones().contains(oldP)){
						entityManager.remove(oldP);
					}	
				}
			}
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			entityManager.clear();
			ex.printStackTrace();
		}
		return false;
	}

	public UserBO save(UserBO userBO) {
		UserPO userPO = UserBuilder.crearUsuarioPO(userBO);
		try {
			super.entityManager.clear();
			super.entityManager.getTransaction().begin();
			//Known People
			if(userPO.getKnowns()!=null && !userPO.getKnowns().isEmpty()){
			List<Integer> ids = new ArrayList<Integer>();
			for(UserPO k : userPO.getKnowns()){
				ids.add(k.getId());
			}
			@SuppressWarnings("unchecked")
			List<UserPO> peopleBD = (List<UserPO>)entityManager.createQuery("FROM UserPO where id IN (:people)")
					.setParameter("people", ids)
					.getResultList();
			userPO.getKnowns().clear();
			super.entityManager.persist(userPO);
			userPO.getKnowns().addAll(peopleBD);
			super.entityManager.merge(userPO);
			}else{
			super.entityManager.persist(userPO);
			}
			super.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			super.entityManager.getTransaction().rollback();
			ex.printStackTrace();
		}
		return UserBuilder.crearUsuarioBO(userPO);
	}

}
