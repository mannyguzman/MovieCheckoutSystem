package edu.wccnet.mguzman4.movieCheckout.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.mguzman4.movieCheckout.entity.Checkout;
import edu.wccnet.mguzman4.movieCheckout.entity.Customer;
import edu.wccnet.mguzman4.movieCheckout.entity.Movie;
import edu.wccnet.mguzman4.movieCheckout.service.CheckoutService;
import edu.wccnet.mguzman4.movieCheckout.service.CustomerService;
import edu.wccnet.mguzman4.movieCheckout.service.MovieService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MovieService movieService;
    
    @Autowired
    private CheckoutService checkoutService;
    
    @Autowired
    private CustomerService customerService;

   
    @GetMapping("/movieList")
    public String getMovieList(Model model) {
        // Fetch the list of all movies
        List<Movie> movieList = movieService.getAllMovies();
        model.addAttribute("movies", movieList);
        return "movie-list";  
    }
    
    @GetMapping("/movieDetails/{movieId}")
    public String getMovieDetails(@PathVariable int movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId); 
        model.addAttribute("movie", movie);
        return "movie-details"; 
    }

    
    @GetMapping("/addMovie")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie"; 
    }


    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movieList";
    }
    
    @GetMapping("/customer/{customerId}")
    public String getCheckoutHistory(@PathVariable int customerId, Model model) { 
    	String customerName = customerService.getCustomerNameById(customerId);
    	
    	model.addAttribute("customerName", customerName); //Add customer Name to the model
    	model.addAttribute("customerId", customerId); // Add customerId to the model
        
        List<Checkout> checkoutHistory = checkoutService.getCheckoutHistoryByCustomerId(customerId);
        model.addAttribute("isSearching", false); // Not searching, just fetching checkout history
        model.addAttribute("checkoutHistory", checkoutHistory);
        return "customer";
    }


    
    @GetMapping("/searchMovie")
    public String searchMovies(@RequestParam String query, @RequestParam String searchType, 
                               @RequestParam int customerId, Model model) {
    	String customerName = customerService.getCustomerNameById(customerId);
    	
        List<Movie> movies;
        if (searchType.equals("title")) {
            movies = movieService.searchMoviesByTitle(query);
        } else {
            movies = movieService.searchMoviesBySynopsis(query);
        }

        model.addAttribute("isSearching", true); 
        model.addAttribute("customerId", customerId); // Add customerId to the model
        model.addAttribute("customerName", customerName); // Add customerName to the model
        
        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found matching your search criteria.");
        } else {
            model.addAttribute("movies", movies);
        }

        return "customer"; 
    }

    
    // Checkout Movie
    @PostMapping("/checkoutMovie/{movieId}")
    public String checkoutMovie(@PathVariable int movieId, @RequestParam int customerId, Model model) {
    	System.out.println("Movie ID: " + movieId);
        System.out.println("Customer ID: " + customerId);
        
        Movie movie = movieService.getMovieById(movieId);
        Customer customer = customerService.getCustomerById(customerId);

        if (movie != null && movie.getAvailable_copies() > 0) {
            movie.setAvailable_copies(movie.getAvailable_copies() - 1);
            movieService.saveMovie(movie);

            Checkout checkout = new Checkout();
            checkout.setMovie(movie);
            checkout.setCustomer(customer);
            checkout.setCheckout_date(LocalDate.now());
            checkoutService.saveCheckout(checkout);

            model.addAttribute("message", "Movie checked out successfully!");
        } else {
            model.addAttribute("message", "No available copies left!");
        }

        List<Checkout> checkoutHistory = checkoutService.getCheckoutHistoryByCustomerId(customerId);
        model.addAttribute("checkoutHistory", checkoutHistory);
       
        return "redirect:/customer/" + customerId;
    }

    
    // Return Movie
    @PostMapping("/returnMovie/{movieId}")
    public String returnMovie(@PathVariable int movieId, @RequestParam int checkoutId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        Checkout checkout = checkoutService.getCheckoutById(checkoutId);

        if (movie != null && checkout != null) {
            movie.setAvailable_copies(movie.getAvailable_copies() + 1);
            movieService.saveMovie(movie);

            checkout.setReturned_date(LocalDate.now());
            checkout.setFinished(true); // Mark checkout as finished
            checkoutService.saveCheckout(checkout);
        }
        int customerId = checkout.getCustomer().getId();
        List<Checkout> checkoutHistory = checkoutService.getCheckoutHistoryByCustomerId(customerId);
        model.addAttribute("checkoutHistory", checkoutHistory);
        return "redirect:/customer/" + customerId;
    }

    
    
    
}
