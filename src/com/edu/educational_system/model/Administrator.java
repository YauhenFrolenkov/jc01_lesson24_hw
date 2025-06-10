package com.edu.educational_system.model;

import java.util.Objects;

public class Administrator extends Person {
	private final String department;

    public Administrator(String name, String email, String department) {
        super(name, email);
        this.department = department;
    }

    @Override
    public void performRole() {
        ensureProcess();
    }

    private void ensureProcess() {
        System.out.println(getName() + " from " + department + " is organizing the classroom.");
    }
    
    @Override
    public String getRoleDescription() {
        return "Administrator of department: " + department;
    }

    public String getDepartment() { 
    	return department; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Administrator other = (Administrator) obj;
        return Objects.equals(department, other.department);
    }

	@Override
	public String toString() {
		return "Administrator [department=" + department + "]";
	}
	
    
}
