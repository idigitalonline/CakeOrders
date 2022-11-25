package com.example.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;
	@Column(name="Name")
     private String Name;
	@Column(name="emailid")
     private String emailid;
     public Admin()
     {
    	 
     }
	public Admin(long id, String name, String emailid) {
		super();
		this.id = id;
		this.Name = name;
		this.emailid = emailid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAdminEmail() {
		// TODO Auto-generated method stub
		return getAdminEmail();
	}
	public String getAdminPassword() {
		// TODO Auto-generated method stub
		return getAdminPassword();
	}
     
     
     
}
