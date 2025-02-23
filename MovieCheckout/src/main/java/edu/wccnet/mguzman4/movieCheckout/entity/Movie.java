package edu.wccnet.mguzman4.movieCheckout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="year_of_release")
	private int year_of_release;
	
	@Column(name="length")
	private int length;
	
	@Column(name="genre")
	private String genre;
	@Column(name="release_date")
	private String release_date;
	@Column(name="rating")
	private String rating;
	@Column(name="synopsis")
	private String synopsis;
	@Column(name="total_copies")
	private int total_copies;
	@Column(name="available_copies")
	private int available_copies;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear_of_release() {
		return year_of_release;
	}
	public void setYear_of_release(int year_of_release) {
		this.year_of_release = year_of_release;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getTotal_copies() {
		return total_copies;
	}
	public void setTotal_copies(int total_copies) {
		this.total_copies = total_copies;
	}
	public int getAvailable_copies() {
		return available_copies;
	}
	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year_of_release=" + year_of_release + ", length=" + length
				+ ", genre=" + genre + ", release_date=" + release_date + ", rating=" + rating + ", synopsis="
				+ synopsis + ", total_copies=" + total_copies + ", available_copies=" + available_copies + "]";
	}
	public Movie(int id, String title, int year_of_release, int length, String genre, String release_date,
			String rating, String synopsis, int total_copies, int available_copies) {
		super();
		this.id = id;
		this.title = title;
		this.year_of_release = year_of_release;
		this.length = length;
		this.genre = genre;
		this.release_date = release_date;
		this.rating = rating;
		this.synopsis = synopsis;
		this.total_copies = total_copies;
		this.available_copies = available_copies;
	}
	
	public Movie(){
		
	}
}
