package edu.wccnet.mguzman4.movieCheckout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wccnet.mguzman4.movieCheckout.entity.Customer;
import edu.wccnet.mguzman4.movieCheckout.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	
	public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null); 
        }
	
	public String getCustomerNameById(int customerId) {
        return customerRepository.findNameById(customerId); 
        }
}
