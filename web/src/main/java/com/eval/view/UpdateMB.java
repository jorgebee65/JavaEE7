package com.eval.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;
import com.eval.dao.UserDAOImpl;

@ManagedBean
@ViewScoped
public class UpdateMB {
	private UserDAOImpl dao;
	private List<UserBO> lstUsers;
	
	public UpdateMB() {
		dao = new UserDAOImpl();
		init();
	}
	
	private void init(){
		lstUsers = dao.obtenerTodos();
	}

	private UserBO userSelected;
	
	public void addPhone(){
		userSelected.getPhones().add(new PhoneBO(userSelected));
	}

	public UserBO getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(UserBO userSelected) {
		this.userSelected = userSelected;
	}

	public List<UserBO> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(List<UserBO> lstUsers) {
		this.lstUsers = lstUsers;
	}
}
