package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.dto.CustomerDTO;

public interface CustomerService {
	public boolean addNew(long id, String name, String email, String phone, String address);
	public boolean modifyDetails(String id, String name, String email, String phone, String address);
	public boolean deleteAll();
	public boolean delete(String id);
	public List<CustomerDTO> fetchAll();
	public String fetchName(String name);
}
