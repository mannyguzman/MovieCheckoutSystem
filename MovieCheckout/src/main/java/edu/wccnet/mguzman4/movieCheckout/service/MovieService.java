package edu.wccnet.mguzman4.movieCheckout.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wccnet.mguzman4.movieCheckout.entity.Checkout;
import edu.wccnet.mguzman4.movieCheckout.entity.Movie;
import edu.wccnet.mguzman4.movieCheckout.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Method to get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
    
    public Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId).orElse(null); 
    }
    
    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> searchMoviesBySynopsis(String synopsis) {
        return movieRepository.findBySynopsisContainingIgnoreCase(synopsis);
    }

}
