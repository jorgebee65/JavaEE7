package com.eval.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.eval.bo.UserBO;
import com.eval.dao.UserDAOImpl;

@ManagedBean 
@ViewScoped
public class UserMB {
   
   private UserDAOImpl dao;
   
   public UserMB(){
      userBO = new UserBO();
      dao = new UserDAOImpl();
   }
   
   private UserBO userBO;
   private UserBO userSelected;
  
   
   public List<UserBO> allUsers(){
      return dao.obtenerTodos();
   }

   public void register(){
      UserBO resp = dao.save(userBO);
      if(resp!=null){
         String msg = "User Registered successfully";
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
         RequestContext.getCurrentInstance().execute("PF('registrationDlg').hide();"); 
      }
   }
   
   public void delete(){
      if(userSelected!=null){
      if(dao.delete(userSelected)){
         String msg = "User Deleted successfully";
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
      }}
   }
   
   public void update(){
      if(userSelected!=null){
      if(dao.update(userSelected)){
         String msg = "User Updated successfully";
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
      }}
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

}
