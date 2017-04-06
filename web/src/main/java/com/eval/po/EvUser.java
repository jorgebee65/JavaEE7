package com.eval.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EV_USER")
public class EvUser implements Serializable{
   
   /**
    * 
    */
   private static final long serialVersionUID = 6089292949709732441L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="ID")
   private Integer id;
   
   @Column(name="NAME")
   private String name;
   
   @Column(name="COUNTRY_ID")
   private Integer country;

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

}
