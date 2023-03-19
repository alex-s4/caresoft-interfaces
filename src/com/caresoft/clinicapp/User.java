package com.caresoft.clinicapp;

public class User {
	
	protected Integer id;
    protected int pin;

    
    public User(Integer id) {
		this.setId(id);
	}
    
    
    // Getters and Setters
    public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return this.pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
