package com.eval.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EV_USER")
public class UserPO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6089292949709732441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COUNTRY_ID")
	private Integer country;

	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL)
	private List<PhonePO> phones;

	public List<PhonePO> getPhones() {
		if(phones==null){
			phones = new ArrayList<PhonePO>();
		}
		return phones;
	}

	public void setPhones(List<PhonePO> phones) {
		this.phones = phones;
	}

	public UserPO() {
		super();
	}

	public UserPO(Integer id, String name, Integer country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void addPhone(PhonePO phone){
		if(phones==null){
			phones = new ArrayList<PhonePO>();
		}
		if(phone.getOwner()==null || !phone.getOwner().equals(this)){
			phone.setOwner(this);
		}
		phones.add(phone);
	}
	
}
