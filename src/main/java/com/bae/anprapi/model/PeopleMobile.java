package com.bae.anprapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PeopleMobile {

	@Id
	private String phoneNumber;

	private String forenames;

	private String surname;

	private String address;

	private Date dateOfBirth;

	private String network;

	@OneToMany(mappedBy = "callerMsisdn")
	private List<MobileCallRecords> callRecords;

	public PeopleMobile() {

	}

	public PeopleMobile(String phoneNumber, String forenames, String surname, Date dateOfBirth, String network,
			List<MobileCallRecords> callRecords) {
		this.phoneNumber = phoneNumber;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.network = network;
		this.callRecords = callRecords;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
}