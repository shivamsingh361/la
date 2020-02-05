package com.cg.service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.cg.dao.CustomerDaoImpl;
import com.cg.dto.CustomerDTO;
import com.cg.exception.CustomException;

public class CustomerServiceImpl implements CustomerService{
	static Logger myLogger =  Logger.getLogger(CustomerDaoImpl.class.getName());
	CustomerDaoImpl obj = new CustomerDaoImpl();
	Logger log;
	public CustomerServiceImpl(){
		PropertyConfigurator.configure("resources/customerlog.properties");
		//log = Logger.getLogger("Logy");
		myLogger.setLevel((Level)Level.WARNING);
		myLogger.info("Constuctor created");
	}
	
	public boolean addNew(long id, String name, String email, String phone, String address) {
		try{
			new ValidateID(id);
			new ValidateName(name);
			new ValidateEmail(email);
			new ValidatePhone(Long.parseLong(phone));
			obj.addNew(id, name, email, phone, address);
		}
		catch(CustomException e){
			myLogger.log(Level.WARNING, "Custom Exception Handled: Invalid Details inputed by User");
			System.out.println(e);
		}
		return true;
	}

	public boolean modifyDetails(String id, String name, String email, String phone, String address) {
		try{ 
		
			new ValidateID(Long.parseLong(id));
			if(!name.equalsIgnoreCase("null"))
				new ValidateName(name);
			if(!email.equalsIgnoreCase("null"))
				new ValidateEmail(email);
			if(!phone.equalsIgnoreCase("null"))
				new ValidatePhone(Long.parseLong(phone));
			obj.modifyDetails(id, name, email, phone, address);
			System.out.println("Returning ");
		}
		catch(CustomException e){
			myLogger.log(Level.WARNING, "Custom Exception Handled: Invalid Details inputed by User");
			System.out.println("In ServiceImpl>> "+e);
		}
		return true;
	}

	public boolean deleteAll() {
		return obj.deleteAll();
	}

	public boolean delete(String id) {
		 obj.delete(id);
		 return true;
	}

	public List<CustomerDTO> fetchAll() {
/*		String all = null;
		for(CustomerDTO itr:obj.fetchAll() )
			all += (itr +"\n");
		obj.fetchAll().forEach((custStr)-> all+=custStr);*/
		return obj.fetchAll();
	}
	
	public String fetchName(String name) {
		return obj.fetchName(name);
	}
	
}
