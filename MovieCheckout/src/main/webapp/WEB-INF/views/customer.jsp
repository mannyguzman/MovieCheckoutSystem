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
<title>Your Checkout List</title>
</head>


<body style="background-color:#f2f2f2;">

<div class="container mt-5">


<button onclick="history.back()" class="btn btn-secondary">Go Back</button>
<br><br>
 <!-- MOVIE SEARCH-->
    <h1>${customerName}'s Dashboard</h1>
    <form action="/cps278_FinalProject/searchMovie" method="get" class="mb-3">
    <input type="hidden" name="customerId" value="${customerId}">
    <div class="input-group">
        <input type="text" name="query" class="form-control" placeholder="Search movies..." >
        <div class="form-check form-check-inline ms-3">
            <input type="radio" id="searchTitle" name="searchType" value="title" class="form-check-input" checked>
            <label class="form-check-label" for="searchTitle">Title</label>
        </div>
        <div class="form-check form-check-inline">
            <input type="radio" id="searchSynopsis" name="searchType" value="synopsis" class="form-check-input">
            <label class="form-check-label" for="searchSynopsis">Synopsis</label>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>

<br>
    
    
    <div id="checkoutListDiv">
    <!-- Message if no checkouts found -->
    <c:if test="${empty checkoutHistory and not isSearching}">
            No checkout history found for this customer.
        </div>
    </c:if>

    <!-- Checkout history table -->
    <c:if test="${not empty checkoutHistory}">
    <h2>Checkout History</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Checkout ID</th>
                    <th cope="col">Movie Title</th>
                    <th scope="col">Checkout Date</th>
                    <th scope="col">Returned Date</th>
                    <th scope="col"> </th>                
                </tr>
            </thead>
            <tbody>
                <c:forEach var="checkout" items="${checkoutHistory}">
    <tr>
        <td scope="row">${checkout.id}</td>
        <td scope="row">
            <a href="/cps278_FinalProject/movieDetails/${checkout.movie.id}">
                ${checkout.movie.title}
            </a>
        </td>
        <td scope="row">${checkout.checkout_date}</td>
        <td scope="row">${checkout.returned_date}</td>
        <td>
            <!-- Only show the Return Movie button if the checkout process is not finished -->
            <c:if test="${!checkout.finished}">
                <form action="/cps278_FinalProject/returnMovie/${checkout.movie.id}" method="post">
                    <input type="hidden" name="customerId" value="${customerId}">
                    <input type="hidden" name="checkoutId" value="${checkout.id}">
                    <button type="submit" class="btn btn-warning">Return Movie</button>
                </form>
            </c:if>
        </td>
    </tr>
</c:forEach>

            </tbody>
        </table>
    </c:if>
</div>

    
    <br><br>
    <!-- MOVIE SEARCH DISPLAY -->
<c:if test="${not empty movies}">
    <h2>Search Results</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th scope="col">Movie ID</th>
                <th scope="col">Title</th>
                <th scope="col">Synopsis</th>
                <th scope="col">Year</th>
                <th scope="col">Available Copies</th>
                <th scope="col"> </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>
                        <a href="/cps278_FinalProject/movieDetails/${movie.id}">
                            ${movie.title}
                        </a>
                    </td>
                    <td>${movie.synopsis}</td>
                    <td>${movie.year_of_release}</td>
                    <td>
                        <!-- Check available copies -->
                        <c:choose>
                            <c:when test="${movie.available_copies == 0}">
                                <span class="text-danger">No copies available</span>
                            </c:when>
                            <c:otherwise>
                                ${movie.available_copies}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <!-- Checkout Movie Button -->
                        <form action="/cps278_FinalProject/checkoutMovie/${movie.id}" method="post">
                            <input type="hidden" name="customerId" value="${customerId}">
                            <button type="submit" class="btn btn-primary" <c:if test="${movie.available_copies == 0}">disabled</c:if>>Checkout Movie</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>


    
    
    
        
    <br>
    
    </div>
</body>
</html>