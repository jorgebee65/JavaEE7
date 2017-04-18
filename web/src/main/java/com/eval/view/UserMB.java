package com.eval.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;
import com.eval.dao.UserDAOImpl;

@ManagedBean
@SessionScoped
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




	public void delete() {
		if (userSelected != null) {
			if (dao.delete(userSelected)) {
				this.lstUsers = dao.obtenerTodos();
				RequestContext.getCurrentInstance().execute("swal('Deleted!','The Person was deleted succesfully.','success');");
				RequestContext.getCurrentInstance().update("allUsers");
			}else{
				RequestContext.getCurrentInstance().execute("swal('Error!','The Person cant be deleted because has a relation with other people','error');");
			}
		}
	}

	public void update() {
		if (userSelected != null) {
			if (dao.update(userSelected)) {
					RequestContext.getCurrentInstance().execute("registerSuccess();");
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
	
	public void sampleAlert(){
		RequestContext.getCurrentInstance().execute("swal('Good job!','You clicked the button!','success')");
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
	
	public String goUpdate(UserBO userSelected){
		this.userSelected = userSelected;
		return "update";
	}

}
