package com.caresoft.clinicapp;

import java.util.*;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	private String role;
	private ArrayList<String> securityIncidents;
	
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.setRole(role);
		this.setSecurityIncidents(new ArrayList<String>());
	}

	@Override
	public boolean assignPin(int pin) {
		int lengthOfPin = String.valueOf(pin).length();
		if(lengthOfPin==6) {
			super.setPin(pin);
			return true;
		} else { return false; }
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		Integer adminID = super.getId();
		if(adminID.equals(confirmedAuthID)) {
			return true;
		}else {
			this.authIncident();
			return false;
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.getSecurityIncidents();
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
	// Setters & Getters

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
}
