package org.hibernate;

import java.io.Serializable;
/**
 * 
 * @author chamini
 *
 */
public class Employee implements Serializable{
    /**
	 * 
	 */
	private int id;
    private String name;
    private int mobile;
    private String email;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
}

