package com.edu.educational_system.model;

import java.util.Objects;

public abstract class Person {
	private String name;
	private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void performRole();

    public String getName() { 
    	return name; 
    }
    
    public String getEmail() { 
    	return email; 
    }
    
    public abstract String getRoleDescription();

	@Override
	public int hashCode() {
		return Objects.hash(email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + "]";
	}
    
    

}
