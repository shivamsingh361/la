package com.cg.dto;

public class CustomerDTO implements Comparable<CustomerDTO> {

	private String name;
	private long ID, phone;
	private String email;
	private String address;
	public CustomerDTO(long id, String name, String email, long phone, String address){
		this.ID = id;
		this.name = name;
		this.address=address;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String toString(){
		return "[name:"+this.name+"][ID:"+this.ID+"][Email:"+this.email+"][Phone:"+this.phone+"][Address:"+this.address+"]";
	}
	@Override
	public int compareTo(CustomerDTO emp){
		if(this.getID() < emp.getID())
			return -1;
		else
		if(this.getID() > emp.getID())
			return 1;
		else
			return 0;
	}
	

}
