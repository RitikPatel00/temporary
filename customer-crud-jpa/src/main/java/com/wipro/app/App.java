package com.wipro.app;

import com.wipro.entity.Customer;
import com.wipro.service.CustomerService;
import com.wipro.service.CustomerServiceImpl;

public class App {
	
	private static CustomerService service  = new CustomerServiceImpl();
	
	
	public static void main(String[] args) {
//		service.addCustomer(new Customer(null,"charu","ch@gmail.com",7906796900l));
//		service.addCustomer(new Customer(null,"deep","dee@gmail.com",8907896910l));
		
		Customer customer1 = service.getCustomerById(1);
		System.out.println(customer1);
		
		Customer customer2 = service.getCustomerById(2);
		System.out.println(customer2);

	}

}
