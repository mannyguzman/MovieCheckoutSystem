package edu.wccnet.mguzman4.movieCheckout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.wccnet.mguzman4.movieCheckout.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	// List<Movie> findById(int id);
	List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findBySynopsisContainingIgnoreCase(String synopsis);

}
