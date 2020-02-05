package com.cg.presentation;
import java.util.Scanner;

import com.cg.dto.CustomerDTO;
import com.cg.service.CustomerServiceImpl;

public class CustomerUI {

	public static void main(String[] args) {
		CustomerServiceImpl customerServiceObj = new CustomerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		while(true){
				System.out.println("-------------------------------------------------------");
				System.out.println("Choose from following:\n1.Add Customer\n2.Fetch All\n3.Modify Customer Details\n"
						+ "4.Delete All Customer\n5.Fetch Customer (Based on Name)\n6.Delete (by ID)");
				int choice = scanner.nextInt();
				switch(choice){
				case 1:
					System.out.println("Add New Customer--->>");
					System.out.print("ID: ");
					long id = scanner.nextLong();	
					scanner.nextLine();
					System.out.print("Name: ");
					String name = scanner.nextLine();
					System.out.println("Email: ");
					String email = scanner.next();
					System.out.println("Phone: ");
					String phone = scanner.next();
					scanner.nextLine();
					System.out.println("Address:");
					String address = scanner.nextLine();
					customerServiceObj.addNew(id, name, email, phone, address);
					break;
				case 2:
					System.out.println("All Customer Details---->>");
					customerServiceObj.fetchAll().stream().forEach(System.out::println);
					break;
				case 3:
					System.out.println("Modify Detail of ?---->>");
					System.out.println("\n**Type 'null'or 'NULL' to not modify and leave previous data!)");
					String id1 = scanner.next();
					scanner.nextLine();
					System.out.print("New Name: ");
					String name1 = scanner.nextLine();
					System.out.println("New Email: ");
					String email1 = scanner.next();
					System.out.println("New Phone: ");
					String phone1 = scanner.next();
					scanner.nextLine();
					System.out.println("New Address:");
					String address1 = scanner.nextLine();
					customerServiceObj.modifyDetails(id1, name1, email1, phone1, address1);
					break;
				case 4:
					System.out.println("Delete All Customer--->>");
					customerServiceObj.deleteAll();
					break;
				case 5:
					System.out.println("Enter Name to get customer Details--->>");
					String custName = scanner.next();
					System.out.println(customerServiceObj.fetchName(custName));
					break;
				case 6:
					System.out.println("Enter ID to Delete ---->>");
					CustomerDTO obj = null;
					String ID;
					ID = scanner.next();
					customerServiceObj.delete(ID);
					break;
				case 7:
					System.exit(1);
				default:
					System.out.println("Invalid Input!");
			}	
		}
	}

}
