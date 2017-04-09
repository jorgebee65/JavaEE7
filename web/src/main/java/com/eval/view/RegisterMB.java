package com.eval.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;

@ManagedBean
@ViewScoped
public class RegisterMB {
	
	private UserBO userBO;
	
	public RegisterMB() {
		userBO = new UserBO();
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
}
