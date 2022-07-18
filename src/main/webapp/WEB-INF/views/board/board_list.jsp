<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page session="false" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../resources/style.css" type="text/css"></link>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Insert title here</title>
  <style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;400;700&display=swap');
  main{
    display: flex;
    flex-wrap: wrap;
    margin-left: 50px;
    margin-right: 50px;
}
	h4{
    color: #fff;
    font-family: inherit;
    margin-left: 50px;
}
    body{
    background-color: #000000;
    font-family: 'Poppins', sans-serif;
    margin: 0;
    }
    
    header{
    padding: 2rem;
    display: flex;
    /* justify-content: flex-start; */
    background-color:#373b6900;
    }

    #movieTitle{
    color: #fff;
    font-family: inherit;
    margin-left: 50px;
    }
    #overview{
    color: #fff;
    font-family: inherit;
    margin-left: 100px;
    margin-bottom: 30px;
    margin-right: 100px;
    float:left;
    }
    #poster{
    margin-left: 100px;
    margin-right:3px;
    border-radius: 3px;
    box-shadow: 0.2px 4px 5px rgba(0,0,0,0.1);
    position: relative;
    overflow: hidden;
    float:left;
    }
    .container{
    width: 800px;
    margin-left: 10px;
    margin-right:3px;
    }
	</style>
</head>
<body>
    <header>
        <a href="http://localhost:8080/myweb/" style ="text-decoration: none;"><h4>영화 리뷰사이트</h4></a>
    </header>
    <main id="main">
    <h2><div id="movieTitle"></div></h2><br>
     <div id="overview"></div><br>
    <div id="poster"></div>
    
    <div class="container">
    <div id="rvbtn">
     <a class="btn btn-outline-warning" id ="rvbtn2" href="http://localhost:8080/myweb/board/register/movie<c:out value="${movieId}"/>">리뷰하기</a>
      &nbsp
     <c:choose>
		<c:when test="${'NaN' == totalScore}"><span style="color: #ffff00;">총 평점 : 0.0점</span></c:when>
		<c:otherwise><span style="color: #ffff00;">총 평점 : <c:out value="${totalScore}" />점</span></c:otherwise>
	</c:choose>
     </div>
			<c:forEach var="board" items="${boards}">
			  <c:if test="${movieId eq board.movieId}">         <!-- movieId번 영화와 관련한 게시글만 출력 -->
				<div class="card bg-light mt-3">
					<!-- 배경 흰색, 위쪽으로 3만큼 여백주기 -->
					<div class="card-header bg-light">
						<div class="row">
							<div class="col-8 text-left">
								<c:choose>
									<c:when test="${'2' == board.score}">⭐</c:when>
									<c:when test="${'4' == board.score}">⭐⭐</c:when>
									<c:when test="${'6' == board.score}">⭐⭐⭐</c:when>
									<c:when test="${'8' == board.score}">⭐⭐⭐⭐</c:when>
									<c:when test="${'10' == board.score}">⭐⭐⭐⭐⭐</c:when>
								</c:choose>
								<c:out value="${board.score}" />
								점
							</div>
							<div class="col-4 text-right">
								<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.regdate}"/>
							</div>
						</div>
					</div>
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${board.title}" />
						</h5>
						<p class="card-text">
							<c:out value="${board.content}" />
						</p>

						<div class="text-right">
							<a
								href="http://localhost:8080/myweb/board/modify/movie<c:out value="${movieId}"/>?bno=<c:out value="${board.bno}"/>"
								class="btn btn-outline-info">수정</a> 
								<a
							    href="http://localhost:8080/myweb/board/delete/movie<c:out value="${movieId}"/>?bno=<c:out value="${board.bno}"/>"
								class="btn btn-outline-danger">삭제</a>
						</div>
					</div>
				 </div>
				</c:if>
			</c:forEach>
		<br>
              <br>
   </div>
   <script>
	//TMDB
	const API_KEY = 'api_key=c05a21bfe10d350302868e8098137963';
	const BASE_URL ='https://api.themoviedb.org/3';
	const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&'+API_KEY;
	const IMG_URL= 'https://image.tmdb.org/t/p/w500';

	const main = document.getElementById('main');

	getMovies(API_URL);

	function getMovies(url){

	    fetch(url).then(res => res.json()).then(data => {
	        showMovies(data.results);
	    })
	}

	function showMovies(movies){          //movies = 영화 목록들
		var movieId ="${movieId}"         //url request로 들어온 movieId 저장.
		console.log(movieId)
		
		for (const movie of movies){
			console.log(movie)
			console.log(movie.id)
			if(movie.id == movieId){               //url request의 movieId와 일치하는 영화 정보(제목,줄거리,이미지)출력.                        
				console.log("아이디 일치")
				var title = movie.title;
			    var overview = movie.overview;
			    var imge = "<img src="+IMG_URL+movie.poster_path+">";
			    console.log(title);
			    document.getElementById("movieTitle").innerHTML=title;
			    document.getElementById("overview").innerHTML=overview;
			    document.getElementById("poster").innerHTML=imge;
			}
		}
	}
	</script>
	</main>
</body>
</html>