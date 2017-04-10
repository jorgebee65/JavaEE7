package com.eval.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;
import com.eval.dao.UserDAOImpl;

@ManagedBean
@ViewScoped
public class RegisterMB {
	
	private UserBO userBO;
	private List<UserBO> lstUsers;
	private UserDAOImpl dao;
	
	public RegisterMB() {
		userBO = new UserBO();
		dao = new UserDAOImpl();
		init();
	}
	
	private void init(){
		lstUsers = dao.obtenerTodos();
	}
	
	public void register() {
		UserBO resp = dao.save(userBO);
		if (resp != null) {
			RequestContext.getCurrentInstance().execute("registerSuccess();");
		}
	}
	

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public void addNewPhone(){
		userBO.getPhones().add(new PhoneBO());
	}
	
	public void deletePhone(PhoneBO item) {
		this.userBO.getPhones().remove(item);
	}

	public List<UserBO> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(List<UserBO> lstUsers) {
		this.lstUsers = lstUsers;
	}
}
