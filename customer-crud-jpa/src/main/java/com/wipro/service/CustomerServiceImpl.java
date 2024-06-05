package com.wipro.service;

import java.util.List;

import com.wipro.dao.CustomerDAO;
import com.wipro.dao.CustomerDaoImpl;
import com.wipro.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO = new CustomerDaoImpl();
	
	
	@Override
	public Customer getCustomerById(Integer customerid) {
		return customerDAO.getCustomerById(customerid);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCustomer(Customer customer) {
		
		return customerDAO.addCustomer(customer);
	}

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(Integer customerid) {
		// TODO Auto-generated method stub
		return null;
	}

}
