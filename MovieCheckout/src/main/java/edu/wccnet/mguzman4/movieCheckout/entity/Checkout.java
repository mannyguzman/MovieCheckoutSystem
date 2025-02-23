package edu.wccnet.mguzman4.movieCheckout.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="checkout")
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="checkout_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	
	@Column(name = "checkout_date")
	private LocalDate checkout_date;
	
	@Column(name = "returned_date")
	private LocalDate returned_date;
	
	
	@Column(name = "is_finished")
	private boolean isFinished = false; // Default is false, meaning checkout is ongoing.

	// Getter and Setter for isFinished
	public boolean isFinished() {
	        return isFinished;
	}

	public void setFinished(boolean isFinished) {
	        this.isFinished = isFinished;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(LocalDate checkout_date) {
		this.checkout_date = checkout_date;
	}

	public LocalDate getReturned_date() {
		return returned_date;
	}

	public void setReturned_date(LocalDate returned_date) {
		this.returned_date = returned_date;
	}



	@Override
	public String toString() {
		return "Checkout [id=" + id + ", checkout_date=" + checkout_date + ", returned_date=" + returned_date + "]";
	}

	public Checkout(int id, Movie movie, Customer customer, LocalDate checkout_date, LocalDate returned_date) {
		super();
		this.id = id;
		this.movie = movie;
		this.customer = customer;
		this.checkout_date = checkout_date;
		this.returned_date = returned_date;
	}
	public Checkout() {
		
	}

}
