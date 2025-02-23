package edu.wccnet.mguzman4.movieCheckout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.mguzman4.movieCheckout.entity.Checkout;
import edu.wccnet.mguzman4.movieCheckout.entity.Movie;
import edu.wccnet.mguzman4.movieCheckout.service.CheckoutService;
import edu.wccnet.mguzman4.movieCheckout.service.CustomerService;
import edu.wccnet.mguzman4.movieCheckout.service.MovieService;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
    private CheckoutService checkoutService;
	@Autowired
    private CustomerService customerService;
	@Autowired
    private MovieService movieService;

    // Endpoint to fetch checkout history by customerId
    @GetMapping("/customer/id/{customerId}")
    public List<Checkout> getCheckoutHistory(@PathVariable int customerId) {
        return checkoutService.getCheckoutHistoryByCustomerId(customerId);
    }
    
    // Endpoint to fetch movie information by movieId 
    @GetMapping("/movie/id/{movieId}")
    public Movie getMovieHistoryById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }
    
    @GetMapping("/movie/title/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title) {
        return movieService.searchMoviesByTitle(title);
    }

 
}
