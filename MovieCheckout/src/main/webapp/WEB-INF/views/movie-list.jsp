<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Movie List</title>
</head>
<body style="background-color:#f2f2f2;">

<div class="container mt-5">
<button onclick="window.location.href='/cps278_FinalProject/'" class="btn btn-secondary">Go Back</button>

    <h1>Movie List</h1>
    
    <!-- Check if movies are available -->
    <c:if test="${not empty movies}">
     
        <table class="table table-bordered">
        <div class="table-responsive card">
            <thead>
                <tr>
                    <th scope="col">Title</th>
                    <th cope="col">Year</th>
                    <th scope="col">Genre</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Description</th>
                    <th scope="col">Total Copies</th>
                    <th scope="col">Available Copies</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through each movie in the list -->
                <c:forEach var="movie" items="${movies}">
                    <tr>
                        <td scope="row">${movie.title}</td>
                        <td scope="row">${movie.year_of_release}</td>
                        <td scope="row">${movie.genre}</td>
                        <td scope="row">${movie.rating}</td>
                        <td scope="row">${movie.synopsis}</td>
                        <td scope="row">${movie.total_copies}</td>
                        <td scope="row">${movie.available_copies}</td>
                    </tr> 
                </c:forEach>
            </tbody>
          </div>
        </table>
     
    </c:if>

    <!-- Message if no movies found -->
    <c:if test="${empty movies}">
        <p>No movies available.</p>
    </c:if>
    
    <br>
    
    <button class="btn btn-primary" onclick="window.location.href='/cps278_FinalProject/addMovie'">Add New Movie To Inventory</button>
    </div>
    
</body>
</html>