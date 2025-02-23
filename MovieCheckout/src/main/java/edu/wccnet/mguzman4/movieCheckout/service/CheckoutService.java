package edu.wccnet.mguzman4.movieCheckout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wccnet.mguzman4.movieCheckout.entity.Checkout;
import edu.wccnet.mguzman4.movieCheckout.repository.CheckoutRepository;


@Service
public class CheckoutService {
	 	@Autowired
	    private CheckoutRepository checkoutRepository;

	    //Method to fetch checkout history by customerId
	    public List<Checkout> getCheckoutHistoryByCustomerId(int customerId) {
	        return checkoutRepository.findByCustomerId(customerId);
	    }
	    
	    public List<Checkout> findByCustomerId(int customerId){
	    	return checkoutRepository.findByCustomerId(customerId);
	    }
	    // Get Checkout by ID
	    public Checkout getCheckoutById(int checkoutId) {
	        return checkoutRepository.findById(checkoutId).orElse(null);
	    }

	    // Save Checkout (update returned date)
	    public void saveCheckout(Checkout checkout) {
	        checkoutRepository.save(checkout);
	    }

}
