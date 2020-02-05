package com.cg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.cg.dto.CustomerDTO;

public class StaticDB {
	static TreeMap<Long,CustomerDTO> DB = null;
	static{
		DB = new TreeMap<Long, CustomerDTO>();
		DB.put((long) 123456789, new CustomerDTO(Long.parseLong("123456789"), "Shivam", "shivam1@gmail.com", Long.parseLong("123456789"), "pune"));
		DB.put((long) 123456790, new CustomerDTO(Long.parseLong("123456790"), "Shivam", "shivam1@gmail.com", Long.parseLong("123456789"), "pune"));
		DB.put((long) 123456791, new CustomerDTO(Long.parseLong("123456791"), "Shivam", "shivam1@gmail.com", Long.parseLong("123456789"), "pune"));
	}
	public static TreeMap<Long, CustomerDTO> getCustomerList(){
		return DB;
	}	
}
