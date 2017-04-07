package com.eval.bo;

public class PhoneBO {
	private Integer id;
	private String number;
	private UserBO user;
	
	public PhoneBO(UserBO usr) {
		this.user = usr;
	}
	
	public PhoneBO() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
		PhoneBO other = (PhoneBO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public UserBO getUser() {
		return user;
	}


	public void setUser(UserBO user) {
		this.user = user;
	}
	
	
}
