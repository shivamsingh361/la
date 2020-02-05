package com.cg.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.dto.CustomerDTO;
import com.cg.exception.DataNotFoundException;
import com.cg.exception.DeleteException;
public class CustomerDaoImpl implements CustomerDao{
	

	Scanner scanner = new Scanner(System.in);
	CustomerDTO customerObj = null;
	OracleConnection connectionObj;
	//private TreeMap< Long, CustomerDTO> custDB = null;
	Logger log;
	static Logger myLogger =  Logger.getLogger(CustomerDaoImpl.class.getName());
	private Connection conn;
	public CustomerDaoImpl(){
		//custDB = StaticDB.DB;
		PropertyConfigurator.configure("resources/customerlog.properties");
		log = Logger.getLogger("Logy");
		myLogger.setLevel((Level)Level.WARNING);
		myLogger.info("Constuctor created");
		connectionObj  = OracleConnection.getInstance();
		myLogger.log(Level.INFO, "CustomerDaoImplementation Constructor Executing!");
	}
	
	public void addNew(long id, String name, String email, String phone, String address){
/*		this.customerObj = new CustomerDTO(id, name, email, Long.parseLong(phone),  address);
		custDB.put(customerObj.getID(),customerObj);*/
		Connection conn;
		try{
			conn = connectionObj.getConnection();	
			conn.setAutoCommit(false);
			String query = new String("INSERT INTO customer values(?,?,?,?,?)");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ps.setString(2, name);
			ps.setString(3,email);
			ps.setLong(4, Long.parseLong(phone));
			//ps.setNull(5,java.sql.Types .DATE);
			ps.setString(5, address);
			System.out.println(">>>"+ps.execute()+ conn);
			conn.commit();
			System.out.println("Commited");
			
		}
		catch(SQLException e){
			System.out.println("**SQL--Exception**"+e);
			myLogger.log(Level.WARNING, "SQL Exception: in CustomerDaoImplementation ");
			
		}
		catch(IOException e){
			System.out.println("**IO---Exception**"+e);
			myLogger.log(Level.WARNING, "IO Exception: in CustomerDaoImplementation ");
		}
		finally{
			System.out.println("**Fianlly Over**");
			myLogger.log(Level.INFO, "In CustomerDaoImplementation and Returning");
		}
	}
	
	public void modifyDetails(String id, String name, String email, String phone, String address){
		try{
			conn = connectionObj.getConnection();	
			//conn.setAutoCommit(false);
			String query; 
			PreparedStatement ps;
			if( 0 != name.trim().compareToIgnoreCase("null")){
				query = new String("UPDATE customer SET name = ? WHERE id = ?");
				ps = conn.prepareStatement(query);
				ps.setString(1, name);	
				ps.setLong(2, Long.parseLong(id));
				ps.executeUpdate();
			}
			if(  0 != email.trim().compareToIgnoreCase("null")){
				query = new String("UPDATE customer SET email = ? WHERE id = ?");
				ps = conn.prepareStatement(query);
				ps.setString(1, email);
				ps.setLong(2, Long.parseLong(id));
				ps.executeUpdate();
			}	
			if(  0 != address.trim().compareToIgnoreCase("null")){
				query = new String("UPDATE customer SET address = ? WHERE id = ?");
				ps = conn.prepareStatement(query);
				ps.setString(1, address);	
				ps.setLong(2, Long.parseLong(id));
				ps.executeUpdate();
			}	
			if(  0 != phone.trim().compareToIgnoreCase("null")){
				query = new String("UPDATE customer SET phone = ? WHERE id = ?");
				ps = conn.prepareStatement(query);
				ps.setLong(1, Long.parseLong(phone));	
				ps.setLong(2, Long.parseLong(id));
				ps.executeUpdate();
			}	
		}catch(SQLException e){
			System.out.println("**SQLException**"+e);
			myLogger.log(Level.WARNING, "SQL Exception: in ModifyDetails ");
		}
		catch(IOException e1){
			System.out.println("**IOException**"+e1);
			myLogger.log(Level.WARNING, "IO Exception: in CustomerDaoImplementation");
		}

/*		for(CustomerDTO itr: custDB.values()){
			if(itr.getID() == Long.parseLong(id)){
				if(  0 != name.trim().compareTo(""))
					itr.setName(name.trim());
				if(  0 != email.trim().compareTo(""))
					itr.setEmail(email.trim());
				if(  0 != address.trim().compareTo(""))
					itr.setAddress(address.trim());
				if(  0 != phone.trim().compareTo(""))
					itr.setPhone(Long.parseLong(phone.trim()));
			}
		}
*/
	}
	public boolean deleteAll(){
		/*List<Long> a = new ArrayList<Long>(custDB.keySet());
		for(long itr: a)
			this.custDB.remove(itr);*/
		try{
			Connection conn = connectionObj.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery("DROP TABLE customer");
		}catch(IOException e){			
			myLogger.log(Level.WARNING, "IO Exception Handled: At deleteALL() Method");
		}catch(SQLException e){
			myLogger.log(Level.WARNING, "SQL Exception Handled: At deleteAll() Method");
		}
		return true;
	}
	
	public void delete(String id){
/*		Long temp = null;
		if(custDB.isEmpty())
			throw new DeleteException();
		for(long itr: custDB.keySet())
			if(custDB.get(itr).getID() == Long.parseLong(id))
				temp = itr;
			custDB.remove(temp);
		if(temp == null)
			throw new DataNotFoundException();*/
		//conn.setAutoCommit(false);
		String query; 
		PreparedStatement ps;
		try{
			conn = connectionObj.getConnection();	
			query = new String("DELETE FROM customer WHERE id = ?");
			ps = conn.prepareStatement(query);
			ps.setLong(1, Long.parseLong(id));
			ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("**SQLException**"+e);
			myLogger.log(Level.WARNING, "SQL Exception Handled: At delete() Method");
		}
		catch(IOException e){
			System.out.println("**IOException**"+e);
			myLogger.log(Level.WARNING, "IO Exception Handled: At delete() Method");
		}
	}
	
	public List<CustomerDTO> fetchAll() {
		List<CustomerDTO> obj = new ArrayList<CustomerDTO>();
		//List<CustomerDTO> obj = new ArrayList<CustomerDTO>;
		try{
			Connection conn = connectionObj.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from customer");
			while (rs.next()) {
				  String name = rs.getString("name");
				  String email = rs.getString("email");
				  String address = rs.getString("address");
				  long phone = rs.getLong("phone");
				  long id = rs.getLong("id");
				  obj.add(new CustomerDTO(id, name, email, phone, address));
				}
		}
		catch(SQLException e){
			System.out.println("**SQLException**"+e);
			myLogger.log(Level.WARNING, "SQL Exception Handled: At fetchALL() Method");
		}
		catch(IOException e){
			System.out.println("**IOException**"+e);
			myLogger.log(Level.WARNING, "IO Exception Handled: At fetchALL() Method");
		}
/*		for( CustomerDTO itr: custDB.values())
			abc.add(custDB.get(itr));*/
		return obj;
	}
	@Override
	public String fetchName(String name) {
		/*for(CustomerDTO itr: custDB.values())
			if(itr.getName() .equalsIgnoreCase(name))
				return itr.toString();
		return "Name Not Found";*/
		
		String query, result = ""; 
		PreparedStatement ps;
		try{
			conn = connectionObj.getConnection();	
			query = new String("SELECT * FROM customer WHERE name = ?");
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
		  while(rs.next()){
			  String email = rs.getString("email");
			  String address = rs.getString("address");
			  long phone = rs.getLong("phone");
			  long id = rs.getLong("id");
			  result += "[name:"+name+"][ID:"+id+"][Email:"+email+"][Phone:"+phone+"][Address:"+address+"]\n";
		  }
		}
		catch(SQLException e){
			System.out.println("**SQLException**"+e);
		}
		catch(IOException e){
			System.out.println("**IOException**"+e);
		}
		return result;
	}
	
/*	public void TestDBConncetion(){
		Connection conn;
		try{
			conn = connectionObj.getConnection();	
			conn.setAutoCommit(false);
			String query = new String("Insert into customer values(?,?,?,?,?)");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 33452);
			ps.setString(2, "Akash");
			ps.setString(3,"akash@cap.in");
			ps.setLong(4, Long.parseLong("8009496723"));
			//ps.setNull(5,java.sql.Types .DATE);
			ps.setString(5, "Pune MH IN");
			////System.out.println(">>>"+ps.execute()+ conn);
			System.out.println("Check");
			conn.commit();
			
		}
		catch(SQLException e){
			System.out.println("**SQL--Exception**"+e);
		}
		catch(IOException e){
			System.out.println("**IO---Exception**"+e);
		}
		finally{
			System.out.println("**Fianlly Over**");

		}
	}*/ 
}
