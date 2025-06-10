package com.edu.educational_system.model;

import java.util.Objects;

public class Teacher extends Person {
    private final String subject;

    public Teacher(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    @Override
    public void performRole() {
        teach();
    }

    private void teach() {
        System.out.println(getName() + " is explaining " + subject + ".");
    }
    
    @Override
    public String getRoleDescription() {
        return "Teacher of subject: " + subject;
    }

    public String getSubject() { 
    	return subject; 
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(subject);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + "]";
	}
    
    

}
