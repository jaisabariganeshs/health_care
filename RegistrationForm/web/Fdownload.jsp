<%-- 
    Document   : register
    Created on : 13-Jul-2023, 1:17:24 pm
    Author     : Nivedha.S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>User Login Page</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@400;700&family=Roboto:wght@400;700&display=swap" rel="stylesheet">  

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Navbar Start -->
        <div class="container-fluid sticky-top bg-white shadow-sm mb-5">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0">
                    <a href="index.html" class="navbar-brand">
                        <h1 class="m-0 text-uppercase text-primary">Internship</h1>
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <div class="navbar-nav ms-auto py-0">
                            <a href="UserHome.jsp" class="nav-item nav-link">User Home</a>
                            <a href="FileUpload.jsp" class="nav-item nav-link">File Upload</a>
                            <a href="MyFiles.jsp" class="nav-item nav-link">My Files</a>
                            <a href="logout.jsp" class="nav-item nav-link">Logout</a>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <%
            String fname = request.getParameter("fname");
            String fid = request.getParameter("fid");

        %>

        <!-- File Upload form Start -->
        <div class="container-fluid pt-5">
            <div class="container">
                <div class="text-center mx-auto mb-5" style="max-width: 500px;">

                </div>
                <div class="row justify-content-center position-relative" style="margin-top: -200px; z-index: 1;">
                    <div class="col-lg-8"><br><br><br><br><br>
                        <center><h1 class="display-4" style="color: #800a1c;">File Download</h1></center>
                        <br>
                        <div class="bg-white rounded p-5 m-5 mb-0">
                            <form action="Download" method="post">
                                <div class="row g-3">
                                    <div class="col-12">
                                        <label>File Name</label>
                                        <input type="text" class="form-control bg-light border-0" id="fname" value="<%=fname%>" readonly=""  name="fname"  style="height: 55px;">
                                    </div>
                                    <input type="hidden" value="<%=fid%>" name="fid"><!-- comment -->
                                    <div class="col-12">
                                        <label>Decryption Key</label>
                                        <input type="text" class="form-control bg-light border-0" id="dkey"  name="dkey" placeholder="Decryption Key" style="height: 55px;">
                                        <span id="passwordError" class="error"></span><br>
                                    </div>
                                    <!-- comment -->                     <div class="col-12">
                                        <button class="btn btn-primary w-100 py-3" type="submit">submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- File Upload form End -->

        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-light mt-5 py-5">
            <div class="container py-5">
                <div class="row g-5">
                    <div class="col-lg-3 col-md-6">
                        <h4 class="d-inline-block text-primary text-uppercase border-bottom border-5 border-secondary mb-4">Get In Touch</h4>
                        <p class="mb-4">No dolore ipsum accusam no lorem. Invidunt sed clita kasd clita et et dolor sed dolor</p>
                        <p class="mb-2"><i class="fa fa-map-marker-alt text-primary me-3"></i>123 Street, New York, USA</p>
                        <p class="mb-2"><i class="fa fa-envelope text-primary me-3"></i>info@example.com</p>
                        <p class="mb-0"><i class="fa fa-phone-alt text-primary me-3"></i>+012 345 67890</p>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="d-inline-block text-primary text-uppercase border-bottom border-5 border-secondary mb-4">Quick Links</h4>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Home</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>About Us</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Our Services</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Meet The Team</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Latest Blog</a>
                            <a class="text-light" href="#"><i class="fa fa-angle-right me-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="d-inline-block text-primary text-uppercase border-bottom border-5 border-secondary mb-4">Popular Links</h4>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Home</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>About Us</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Our Services</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Meet The Team</a>
                            <a class="text-light mb-2" href="#"><i class="fa fa-angle-right me-2"></i>Latest Blog</a>
                            <a class="text-light" href="#"><i class="fa fa-angle-right me-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="d-inline-block text-primary text-uppercase border-bottom border-5 border-secondary mb-4">Newsletter</h4>
                        <form action="">
                            <div class="input-group">
                                <input type="text" class="form-control p-3 border-0" placeholder="Your Email Address">
                                <button class="btn btn-primary">Sign Up</button>
                            </div>
                        </form>
                        <h6 class="text-primary text-uppercase mt-4 mb-3">Follow Us</h6>
                        <div class="d-flex">
                            <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded-circle" href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid bg-dark text-light border-top border-secondary py-4">
            <div class="container">
                <div class="row g-5">
                    <div class="col-md-6 text-center text-md-start">
                        <p class="mb-md-0">&copy; <a class="text-primary" href="#">Your Site Name</a>. All Rights Reserved.</p>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <p class="mb-0">Designed by <a class="text-primary" href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>