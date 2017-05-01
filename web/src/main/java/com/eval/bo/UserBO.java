package com.eval.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBO {
	private Integer id;
	private String name;
	private Integer country;
	private String sCountry;
	private List<PhoneBO> phones;
	private Set<UserBO> knowns;
	
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

	public Set<UserBO> getKnowns() {
		if(knowns==null){
			knowns = new HashSet<UserBO>();
		}
		return knowns;
	}

	public void setKnowns(Set<UserBO> knowns) {
		this.knowns = knowns;
	}
	

	@Override
	public String toString() {
		return "UserBO [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBO other = (UserBO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
