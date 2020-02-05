package com.cg.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerServiceImplTest {
	static CustomerServiceImpl obj;
	@Before
	public void Start(){
		obj = new CustomerServiceImpl();
	}
	@Test
	public void testCustomerServiceImpl() {
	}

	@Test
	public void testAddNew() {
		assertEquals(true,obj.addNew(1234543456, "Shivam", "shivam@cap.c", "122322343", "IND"));
	}

	@Test
	public void testModifyDetails() {
		assertEquals(true,obj.modifyDetails("1234543456", "Shivam", "shivam@cap.c", "122322343", "IND"));
	}

/*	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchName() {
		fail("Not yet implemented");
	}*/

}
