package com.eval.view;

import java.util.ArrayList;
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
public class UserMB {

	private UserDAOImpl dao;
	private List<UserBO> lstUsers;

	public UserMB() {
		userBO = new UserBO();
		dao = new UserDAOImpl();
		init();
	}

	private void init(){
		lstUsers = dao.obtenerTodos();
	}
	
	private UserBO userBO;
	private UserBO userSelected;



	public void register() {
		UserBO resp = dao.save(userBO);
		if (resp != null) {
			this.userBO = new UserBO();
			this.lstUsers = dao.obtenerTodos();
			String msg = "User Registered successfully";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			RequestContext.getCurrentInstance().execute("PF('registrationDlg').hide();");
		}
	}

	public void delete() {
		if (userSelected != null) {
			if (dao.delete(userSelected)) {
				this.lstUsers = dao.obtenerTodos();
				String msg = "User Deleted successfully";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			}else{
				String msg = "Delete Error";
				String msgDtl = "The user can't be deleted because have one or more references with other users.";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, msg,msgDtl ));
			}
		}
	}

	public void update() {
		if (userSelected != null) {
			if (dao.update(userSelected)) {
				this.lstUsers = dao.obtenerTodos();
				String msg = "User Updated successfully";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
				RequestContext.getCurrentInstance().execute("PF('updateDlg').hide();");
			}
		}
	}
	
	public List<UserBO> usersForMe(){
		List<UserBO> usersForMe = new ArrayList<UserBO>();
		for(UserBO us : lstUsers){
			if(!us.equals(userSelected)){
				usersForMe.add(us);
			}
		}
		return usersForMe;
	}
	
	public void addPhone(){
		userSelected.getPhones().add(new PhoneBO(userSelected));
	}
	
	public void addPeople(){
		userSelected.getKnowns().add(lstUsers.get(0));
	}
	
	public void addNewPhone(){
		userBO.getPhones().add(new PhoneBO(userSelected));
	}
	
	public void addNewPeople(){
		userBO.getKnowns().add(lstUsers.get(0));
	}

	public void deletePhone(PhoneBO item) {
		this.userSelected.getPhones().remove(item);
	}
	
	public void deletePeople(UserBO usr) {
		this.userSelected.getKnowns().remove(usr);
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
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
