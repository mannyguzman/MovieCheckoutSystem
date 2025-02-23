<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Add Movie</title>
</head>
<body style="background-color:#f2f2f2;">

<div class="container mt-5">
<button onclick="window.location.href='/cps278_FinalProject/movieList'" class="btn btn-secondary">Go Back</button>

    
    <h1 class="text-center mb-4">Add New Movie</h1>
    <form:form action="saveMovie" method="post" modelAttribute="movie" class="p-4 border rounded">
  
    <div class="container mt-5">
        
        <div class="mb-3">
        <label for="title">Title:</label><br>
        <input class="form-control" type="text" id="title" name="title" required>
		</div>
		
		<div class="mb-3">
        <label for="year_of_release">Year of Release:</label><br>
        <input class="form-control" type="number" id="year_of_release" name="year_of_release" required>
		</div>
		
		<div class="mb-3">
        <label for="length">Length (minutes):</label><br>
        <input class="form-control" type="number" id="length" name="length" required>
		</div>
		
		<div class="mb-3">
        <label for="genre">Genre:</label><br>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Action">
        <label for="genre">Action</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Sci-Fi">
        <label for="genre">Sci-Fi</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Family">
        <label for="genre">Family</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Drama">
        <label for="genre">Drama</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Fantasy">
        <label for="genre">Fantasy</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Comedy">
        <label for="genre">Comedy</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Documentary">
        <label for="genre">Documentary</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Romance">
        <label for="genre">Romance</label>
        <input class="form-check-input" type="checkbox" id="genre" name="genre" value="Thriller">
        <label for="genre">Thriller</label>
        </div>
        <br>
		
		<div class="mb-3">
        <label for="release_date">Release Date (yyyy-mm-dd):</label><br>
        <input class="form-control" type=date id="release_date" name="release_date" required><br>
		</div>
		
		<div class="mb-3">
        <label for="rating">Age Rating:</label><br>
        <select class="form-control" id="rating" name="rating" required>
        <option value="G">G</option>
        <option value="PG">PG</option>
        <option value="PG-13">PG-13</option>
        <option value="PG">R</option>
        <option value="NC-17">NC-17</option>
        </select><br>
		</div>
		
		<div class="mb-3">
        <label for="synopsis">Synopsis:</label><br>
        <textarea class="form-control" id="synopsis" name="synopsis" required></textarea><br><br>
		</div>
		
		<div class="mb-3">
        <label for="total_copies">Total Copies:</label><br>
        <input class="form-control" type="number" id="total_copies" name="total_copies" required><br>
		</div>
		
		<div class="mb-3">
        <label for="available_copies">Available Copies:</label><br>
        <input class="form-control" type="number" id="available_copies" name="available_copies" required><br>
		</div>
		
        <button type="submit" class="btn btn-primary">Add Movie</button>
        </div>
    </form:form>
    
   <br> 
</div><br>
</body>
</html>
