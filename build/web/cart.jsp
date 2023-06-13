<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>      
<%@ page import="java.util.*" %>
<%@ page import="dal.*" %>
<%@ page import="entity.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"> <!--hello-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cart | E-Shopper</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href=""><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                    <li><a href=""><i class="fa fa-envelope"></i> info@domain.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href=""><i class="fa fa-facebook"></i></a></li>
                                    <li><a href=""><i class="fa fa-twitter"></i></a></li>
                                    <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="home"><img src="images/home/logo.png" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <%       Account x = (Account) request.getSession().getAttribute("curr");
                                           if (x != null) {
                                           out.println("<li><a href=\"#\"><i class=\"fa fa-user\"></i> " + x.getName() + "</a></li>");
                                           }

                                    %>
                                    <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                   <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i>Cart(${sessionScope.size})</a></li>
                                        <% 
if (x != null) {
out.println("<li><a href=\"logout\"><i class=\"fa fa-user\"></i> Sign out</a></li>");
}

if (x == null) {
out.println("<li><a href=\"login.jsp\"><i class=\"fa fa-lock\"></i> Login</a></li>");
}
                                        %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="home" class="active">Home</a></li>
                                    <li class="dropdown"><a href="product">Shop<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <li><a href="product">Products</a></li>
                                            <li><a href="checkout.html">Checkout</a></li> 
                                            <li><a href="cart.html">Cart</a></li> 
                                            <li><a href="login.html">Login</a></li> 
                                        </ul>
                                    </li> 
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="search_box pull-right">
                                <form action="product" method="get" id="searchForm">
                                    <input type="text" name="searchInput" placeholder="Search"/>
                                    <button style="display: none;" type="submit">Search</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->        </header><!--/header-->

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a></li>
                        <li class="active">Shopping Cart</li>
                    </ol>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>


                        <tbody>
                            <c:forEach items="${sessionScope.cart.item}" var="i">     
                                <tr>                                    
                                    <td  class="cart_product">
                                        <div class="col-sm-12">
                                            <div class="product_image">
                                                <a href=""><img style="width: 110px; height: 110px;" src="${i.product.image}" alt=""></a>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart_description">
                                        <div class="col-sm-12">
                                            <h4><a href="">${i.product.name}</a></h4>
                                        </div>
                                    </td>
                                    <td class="cart_price">
                                        <p>$${i.product.price}</p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            <a class="cart_quantity_up" href="process?num=1&id=${i.product.id}"> + </a>
                                            <input id="quantityInput" class="cart_quantity_input" type="text" name="quantity" value="${i.quantity}" autocomplete="off" size="2">
                                            <a class="cart_quantity_down" href="process?num=-1&id=${i.product.id}"> - </a>
                                        </div>
                                    </td>

                                    <td class="cart_total">
                                        <p class="cart_total_price">$<fmt:formatNumber value="${i.product.price * i.quantity}" pattern="0.00" /></p>
                                    </td>
                                    <td class="cart_delete"> 
                                        <form action="process" method="post">
                                            <input type="hidden" name="id" value="${i.product.id}" />
                                            <button type="submit" class="cart_quantity_delete">
                                                <i class="fa fa-times"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>




                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <c:choose>
                    <c:when test="${not empty sessionScope.cart.item}">
                        <div class="col-sm-6">
                            <div class="total_area">
                                <ul>
                                    <li>Cart Sub Total <span>$<fmt:formatNumber value="${sessionScope.cart.getTotalMoney()}" pattern="0.00" /></span></li>
                                    <li>Eco Tax <span>$0</span></li>
                                    <li>Shipping Cost <span>Free</span></li>
                                    <li>Total <span>$<fmt:formatNumber value="${sessionScope.cart.getTotalMoney()}" pattern="0.00" /></span></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <form action="checkout" method="post">                             
                                <button type="submit" class="btn btn-default check_out">
                                    <i>CheckOut</i>
                                </button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-sm-12">
                            <p>Your cart is empty. Please <a href="product">continue shopping</a>.</p>
                        </div>
                    </c:otherwise>
                </c:choose>   
            </div>
        </section><!--/#do_action-->





        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>