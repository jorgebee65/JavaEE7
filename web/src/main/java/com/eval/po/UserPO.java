package com.eval.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@OneToMany(mappedBy="owner", cascade = {CascadeType.PERSIST, CascadeType.REMOVE })
	private List<PhonePO> phones;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name="EV_KNOWN",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="KNOWN_ID")})
	private Set<UserPO> knowns = new HashSet<UserPO>();

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

	public Set<UserPO> getKnowns() {
		return knowns;
	}

	public void setKnowns(Set<UserPO> knowns) {
		this.knowns = knowns;
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
		UserPO other = (UserPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
