<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<link rel="stylesheet" href="./resources/style.css" type="text/css"></link>
</head>
<body>
    <header>
        <a href="http://localhost:8080/myweb/" style ="text-decoration: none;"><h2>영화 리뷰사이트</h2></a>
    </header>

    <main id="main">
        <div class="movie">
            <img src="img/movie1.jpg" alt="Image">

            <div class="movie-info">
                <h3>Movie title</h3>
                <span class="green">9.8</span>
            </div>

            <div class="overview">

                <h3>overview</h3>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum qui eligendi est quos, minima ipsa dignissimos sint quidem ut sequi similique earum? Asperiores minus porro mollitia consectetur doloribus ratione cum.
            </div>
        </div>

        <div class="movie">
            <img src="img/movie1.jpg" alt="Image">

            <div class="movie-info">
                <h3>Movie title</h3>
                <span class="green">9.8</span>
            </div>

            <div class="overview">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum qui eligendi est quos, minima ipsa dignissimos sint quidem ut sequi similique earum? Asperiores minus porro mollitia consectetur doloribus ratione cum.
            </div>
        </div>

        <div class="movie">
            <img src="img/movie1.jpg" alt="Image">

            <div class="movie-info">
                <h3>Movie title</h3>
                <span class="green">9.8</span>
            </div>

            <div class="overview">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum qui eligendi est quos, minima ipsa dignissimos sint quidem ut sequi similique earum? Asperiores minus porro mollitia consectetur doloribus ratione cum.
            </div>
        </div>
    </main>
    <script src="./resources/js/script.js"></script>
</body>
</html>