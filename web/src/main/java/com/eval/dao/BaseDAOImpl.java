package com.eval.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eval.entityManager.EntityManagerHelper;



public abstract class BaseDAOImpl {

   @PersistenceContext
   protected EntityManager entityManager;
  

   public void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }

   /**
    * @param pcClase
    */
   public BaseDAOImpl() {
    
      entityManager = EntityManagerHelper.getEntityManager();
   }

   
}
