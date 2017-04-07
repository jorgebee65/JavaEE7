package com.eval.bo;

import java.util.ArrayList;
import java.util.List;

public class UserBO {
	private Integer id;
	private String name;
	private Integer country;
	private String sCountry;
	private List<PhoneBO> phones;
	
	public UserBO(){}

	public UserBO(Integer id, String name, Integer country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public List<PhoneBO> getPhones() {
		if(phones==null){
			phones = new ArrayList<PhoneBO>();
		}
		return phones;
	}

	public void setPhones(List<PhoneBO> phones) {
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getsCountry() {
		return sCountry;
	}

	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}
}
