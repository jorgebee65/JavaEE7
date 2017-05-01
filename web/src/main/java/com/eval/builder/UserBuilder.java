package com.eval.builder;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;
import com.eval.po.PhonePO;
import com.eval.po.UserPO;

public class UserBuilder {
   
   public static UserBO crearUsuarioBO(UserPO userPO){
      UserBO bo = new UserBO();
         bo.setId(userPO.getId());
         bo.setName(userPO.getName());
         bo.setCountry(userPO.getCountry());
         bo.setsCountry(userPO.getCountry()==1?"US":"UK");
         for(PhonePO ph : userPO.getPhones()){
        	 bo.getPhones().add(PhoneBuilder.createPhoneBO(ph));
         }
         for(UserPO k : userPO.getKnowns()){
        	 bo.getKnowns().add(new UserBO(k.getId(),k.getName(),k.getCountry()));
         }
      return bo;
   }

   public static UserPO crearUsuarioPO(UserBO userBO){
      UserPO po = new UserPO();
         po.setId(userBO.getId());
         po.setName(userBO.getName());
         po.setCountry(userBO.getCountry());
         if(userBO.getPhones()!=null && !userBO.getPhones().isEmpty() )
         for(PhoneBO ph : userBO.getPhones()){
        	 po.addPhone(PhoneBuilder.createPhonePO(ph));
         }
         for(UserBO k : userBO.getKnowns()){
        	 po.getKnowns().add(new UserPO(k.getId(), k.getName(), k.getCountry()));
         }
      return po;
   }
   
}
