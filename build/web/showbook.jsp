<%@ page import="java.sql.*" %>      
<%@ page import="java.util.*" %>
<%@ page import="dal.*" %>
<%@ page import="entity.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">

   
</head>
<body>
   
    <h1>Book Details</h1>
    
    <table class="table-bordered">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Supplier</th>
            <th>Publisher</th>
            <th>Cover Form</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Author</th>
            <th>Year Publish</th>
            <th>Language</th>
            <th>Weight</th>
            <th>Packaging Size</th>
            <th>Number of Pages</th>
            <th>Description</th>
            <th>Image</th>
            <th>Category ID</th>
            <th>Genre</th>
           
        </tr>
        <% 
            List<book_detail> bookList = (List<book_detail>) request.getAttribute("bookdetail");
            for (book_detail book : bookList) {
        %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getName() %></td>
                <td><%= book.getSupplier() %></td>
                <td><%= book.getPublisher() %></td>
                <td><%= book.getCover_form() %></td>
                <td><%= book.getPrice() %></td>
                <td><%= book.getQuantity() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getYear_publish() %></td>
                <td><%= book.getLanguage() %></td>
                <td><%= book.getWeight() %></td>
                <td><%= book.getPackage_size() %></td>
                <td><%= book.getNum_page() %></td>
                <td><%= book.getDescription()%></td>
                <td><%= book.getImage() %></td>
                <td><%= book.getCategoryID() %></td>
                <td><%= book.getGerne_id() %></td>
                
            </tr>
        <% 
            }
        %>
    </table>
   
    <script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
