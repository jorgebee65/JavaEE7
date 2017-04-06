package com.eval.builder;

import com.eval.bo.UserBO;
import com.eval.po.EvUser;

public class UserBuilder {
   
   public static UserBO crearUsuarioBO(EvUser userPO){
      UserBO bo = new UserBO();
         bo.setId(userPO.getId());
         bo.setName(userPO.getName());
         bo.setCountry(userPO.getCountry());
         bo.setsCountry(userPO.getCountry()==1?"US":"UK");
      return bo;
   }

   public static EvUser crearUsuarioPO(UserBO userBO){
      EvUser po = new EvUser();
         po.setId(userBO.getId());
         po.setName(userBO.getName());
         po.setCountry(userBO.getCountry());
      return po;
   }
   
}
