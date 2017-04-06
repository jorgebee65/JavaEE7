package com.eval.bo;

public class UserBO {
   private Integer id;
   private String name;
   private Integer country;
   private String sCountry;
   
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
