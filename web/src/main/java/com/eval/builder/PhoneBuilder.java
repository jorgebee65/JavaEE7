package com.eval.builder;

import com.eval.bo.PhoneBO;
import com.eval.bo.UserBO;
import com.eval.po.UserPO;
import com.eval.po.PhonePO;

public class PhoneBuilder {
	
	public static PhoneBO createPhoneBO(PhonePO po){
		PhoneBO bo = new PhoneBO();
			bo.setId(po.getId());
			bo.setNumber(po.getPhoneNumber());
			if(po.getOwner()!=null){
			bo.setUser(new UserBO(po.getOwner().getId(), po.getOwner().getName(), po.getOwner().getCountry()));
			}
			return bo;
	}
	
	
	public static PhonePO createPhonePO(PhoneBO bo){
		PhonePO po = new PhonePO();
			po.setId(bo.getId());
			po.setPhoneNumber(bo.getNumber());
			if(bo.getUser()!=null){
				po.setOwner(new UserPO(bo.getUser().getId(), bo.getUser().getName(), bo.getUser().getCountry()));
			}
		return po;
	}
	
}
