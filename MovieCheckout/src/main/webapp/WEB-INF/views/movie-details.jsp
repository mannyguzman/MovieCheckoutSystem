<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<html>
<head>
<meta charset="ISO-8859-1">
<title>${movie.title}</title>
</head>
<body style="background-color:#f2f2f2;">
<table class="table table-bordered">
<div class="container mt-5">
    <h1>${movie.title}</h1>
    <div class="container mt-4" style="background-color:white;">
    <p><strong>Year of Release:</strong> ${movie.year_of_release}</p>
    <p><strong>Length:</strong> ${movie.length} minutes</p>
    <p><strong>Genre:</strong> ${movie.genre}</p>
    <p><strong>Release Date:</strong> ${movie.release_date}</p>
    <p><strong>Rating:</strong> ${movie.rating}</p>
    <p><strong>Synopsis:</strong> ${movie.synopsis}</p>
    <p><strong>Total Copies:</strong> ${movie.total_copies}</p>
    <p><strong>Available Copies:</strong> ${movie.available_copies}</p>
    <button onclick="window.history.back()">Go Back</button>
    <br><br>
    </div>
    </div>
    </table>
</body>
</html>