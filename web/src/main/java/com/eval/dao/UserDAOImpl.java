package com.eval.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

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
			super.entityManager.remove(userPO);
			super.entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			super.entityManager.getTransaction().rollback();
			entityManager.clear();
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(UserBO userBO) {
		EntityTransaction tr = entityManager.getTransaction();
		try {
			entityManager.clear();
			UserPO userPO = UserBuilder.crearUsuarioPO(userBO);
			tr.begin();
			entityManager.merge(userPO);
			tr.commit();
			return true;
		} catch (Exception ex) {
			tr.rollback();
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
			super.entityManager.persist(userPO);
			super.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			super.entityManager.getTransaction().rollback();
			ex.printStackTrace();
		}
		return UserBuilder.crearUsuarioBO(userPO);
	}

}
