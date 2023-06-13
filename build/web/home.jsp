<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="dal.*" %>
<%@ page import="entity.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
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
                                    <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
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
                                <form action="product" method="get" id="searchForm" onsubmit="return false;">
                                    <input type="text" name="searchInput" placeholder="Search" onkeydown="if (event.keyCode === 13) {
                  document.getElementById('searchForm').submit();
                  return false;
              }">
                                    <a href="#" onclick="document.getElementById('searchForm').submit();" style="display: none;">Search</a>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->

        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                <li data-target="#slider-carousel" data-slide-to="1"></li>
                                <li data-target="#slider-carousel" data-slide-to="2"></li>
                            </ol>

                            <div class="carousel-inner">
                                <div class="item active">
                                    <div class="col-sm-6">
                                        <h1><span>E</span>-Booker</h1>
                                        <h2>Best book of MAY</h2>
                                        <button type="button" class="btn btn-default get">Get it now</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <img src="https://pressgazette.co.uk/wp-content/uploads/sites/7/2022/04/lrb-scaled.jpg" class="girl img-responsive" alt="" />
                                        <img src="images/home/pricing.png"  class="pricing" alt="" />
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="col-sm-6">
                                        <h1><span>E</span>-Booker</h1>
                                        <h2>Best book of 2023</h2>
                                        <button type="button" class="btn btn-default get">Get it now</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <img src="https://assets.vogue.com/photos/63239a0292d08ee271ef754c/master/w_2560%2Cc_limit/_new_BOOK_COLLAGE_PROMO.jpg" class="girl img-responsive" alt="" />
                                        <img src="images/home/pricing.png"  class="pricing" alt="" />
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="col-sm-6">
                                        <h1><span>E</span>-Booker</h1>
                                        <h2>Best book in top Category</h2>
                                        <button type="button" class="btn btn-default get">Get it now</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <img src="https://mgross.com/wp-content/uploads/2021/02/E2215509-180F-4226-BD76-A8AD4E6B0728-scaled-1.jpg" class="girl img-responsive" alt="" />
                                        <img src="images/home/pricing.png" class="pricing" alt="" />
                                    </div>
                                </div>

                            </div>

                            <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </section><!--/slider-->

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Category</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                <div class="panel panel-default">    
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <li><a href="product">ALL Category</a></li> 
                                        </h4>
                                    </div>
                                </div>
                                <c:forEach var="o" items="${requestScope.lst}" varStatus="loop">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordian" href="#collapse${loop.index}">
                                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                                    <li><a href="product?merchid=${o.id_mer}">${o.name_mer}</a></li>
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapse${loop.index}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul>
                                                    <c:forEach var="item" items="${lst1}" >
                                                        <c:if test="${item.idMerch eq (loop.index+1)}">
                                                            <li><a href="product?cateID=${item.idCate}">${item.catName}</a></li>
                                                            </c:if>
                                                        </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <div class="brands_products">
                                <!--brands_products-->
                                <h2>GENRES</h2>
                                <div class="brands-name">
                                    <ul class="nav nav-pills nav-stacked" id="genreList">
                                        <c:forEach items="${genreList}" var="genre" varStatus="status">
                                            <li class="genre-item ${status.index >= 7 ? 'hidden' : ''}">
                                                <a href="product?gerneID=${genre.id}"><span class="pull-right"></span>${genre.name}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <div  class="show-button-container">
                                        <button class="show-more-button" onclick="showMoreGenres()">Show More</button>
                                        <button class="show-less-button hidden" onclick="showLessGenres()">Show Less</button>
                                    </div>
                                </div>
                            </div>
                            <!--/brands_products-->
                            <div class="shipping text-center"><!--shipping-->
                                <img src="images/home/shipping.jpg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Features Items</h2>
                            <c:forEach var="item" items="${itemList}" varStatus="status">
                                <c:if test="${status.index < 6}">
                                    <div class="col-sm-4">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <img src="${item.image}" alt="" />
                                                    <h2>${item.price}$</h2>
                                                    <p class="item-name">${item.name}</p>

                                                </div>
                                                <div class="product-overlay">
                                                    <div class="overlay-content">
                                                        <h2>${item.price}$</h2>
                                                        <p class="item-name">${item.name}</p>
                                                        <a href="productdetail?productid=${item.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>In Detail</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </c:if>
                            </c:forEach>
                            <a href="product" class="btn btn-go-to-product">See more</a>
                        </div><!--features_items-->

                        <div class="category-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#" data-category-id="1">Tiểu Thuyết Mới</a></li>
                                    <li><a href="#" data-category-id="3">Truyện tranh nhật bản</a></li>
                                    <li><a href="#" data-category-id="4">Sách đề tài trinh thám</a></li>
                                    <li><a href="#" data-category-id="5">Sách kinh doanh</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <!-- Content will be dynamically loaded here -->
                            </div>
                        </div><!--/category-tab-->


                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">recommended items</h2>

                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">

                                    <c:forEach var="item" items="${itemList}" varStatus="status">
                                        <c:if test="${status.index % 3 == 0}">
                                            <div class="item ${status.index == 0 ? 'active' : ''}">
                                                <div class="row">
                                                    <c:forEach begin="${status.index}" end="${status.index + 2}" varStatus="innerStatus">
                                                        <c:if test="${innerStatus.index < itemList.size()}">
                                                            <div class="col-sm-4">
                                                                <div class="product-image-wrapper">
                                                                    <div class="single-products">
                                                                        <div class="productinfo text-center">
                                                                            <img src="${itemList[innerStatus.index].image}" alt="" />
                                                                            <h2>${itemList[innerStatus.index].price}$</h2>
                                                                            <p class="item-name" >${itemList[innerStatus.index].name}</p>
                                                                            <a href="productdetail?productid=${itemList[innerStatus.index].id}" class="btn btn-default add-to-cart">
                                                                                <i class="fa fa-shopping-cart"></i>In Detail
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>
                                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </div><!--/recommended_items-->



                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>