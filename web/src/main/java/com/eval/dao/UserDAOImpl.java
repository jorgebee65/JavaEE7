package com.eval.dao;

import java.util.ArrayList;
import java.util.List;

import com.eval.bo.UserBO;
import com.eval.builder.UserBuilder;
import com.eval.po.EvUser;

public class UserDAOImpl extends BaseDAOImpl {

   @SuppressWarnings("unchecked")
   public List<UserBO> obtenerTodos(){
      List<EvUser> allUsers = null;
      List<UserBO> allUsersBO = null;
      try{
      super.entityManager.getTransaction();
       allUsers = (List<EvUser>)super.entityManager.createQuery("FROM EvUser").getResultList();
       if(allUsers!=null){
          allUsersBO = new ArrayList<UserBO>();
          for(EvUser po : allUsers){
             allUsersBO.add(UserBuilder.crearUsuarioBO(po));
          }
       }
      }catch(Exception e){
         e.printStackTrace();    
     }
      return allUsersBO;
   }
   
   public boolean delete(UserBO userBO){
      try{
      super.entityManager.clear();
      EvUser userPO = entityManager.find(EvUser.class,userBO.getId());
      super.entityManager.getTransaction().begin();
      super.entityManager.remove(userPO);
      super.entityManager.getTransaction().commit();
      return true;
      }catch(Exception ex){
         entityManager.clear();
         ex.printStackTrace();
      }
      return false;
   }
   
   public boolean update(UserBO userBO){
      try{
      super.entityManager.clear();
      EvUser userPO = UserBuilder.crearUsuarioPO(userBO);
      super.entityManager.getTransaction().begin();
      super.entityManager.merge(userPO);
      super.entityManager.getTransaction().commit();
      return true;
      }catch(Exception ex){
         entityManager.clear();
         ex.printStackTrace();
      }
      return false;
   }
   
   public UserBO save(UserBO userBO){
      EvUser userPO = UserBuilder.crearUsuarioPO(userBO);
      try{
      super.entityManager.clear();
      super.entityManager.getTransaction().begin();
      super.entityManager.persist(userPO);
      super.entityManager.getTransaction().commit();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      return UserBuilder.crearUsuarioBO(userPO);
   }
   
}
