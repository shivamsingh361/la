package com.cg.dao;

import java.util.List;
import com.cg.dto.CustomerDTO;

public interface CustomerDao {
		public void addNew(long id, String name, String email, String phone, String address);
		public void modifyDetails(String id, String name, String email, String phone, String address);
		public boolean deleteAll();
		public void delete(String id);
		public List<CustomerDTO> fetchAll();
		public String fetchName(String name);

}
