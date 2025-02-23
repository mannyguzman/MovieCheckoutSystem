<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet">

<!-- Bootstrap JS -->
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="background-color:#f2f2f2;">
    <div class="container mt-5">
        <h1 class="text-center mb-4">Welcome</h1>
        
        <h3>Admin</h3>
        <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/movieList'">
            <div class="card-body text-center">
                <h5 class="card-title">Movie Inventory</h5>
            </div>
        </div>
        
        <h3>Users</h3>
        <div class="row row-cols-1 row-cols-md-3 g-4 mt-3">
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/1'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Manuel</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/2'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Erin</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/3'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Samuel</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/4'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Jim</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/5'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Sasha</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/6'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Erik</h5>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm" style="cursor: pointer;" onclick="window.location.href='/cps278_FinalProject/customer/7'">
                    <div class="card-body text-center">
                        <h5 class="card-title">Jing</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
