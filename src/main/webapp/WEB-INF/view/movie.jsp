<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />


<fmt:message bundle="${local}" key="local.movie.name" var="name" />

<html>
    <head>
    <link rel="stylesheet" href="static/css/style.css" />
    </head>


    <body>
         <header class="header">
              <jsp:include page="fragments/header.jsp" />
              <jsp:include page="fragments/genre.jsp" />
          </header>


         <main class= "main">
            <section class="intro__main">
               <div class = "movies__container">
                  <div class = "image">
                       <img src="${movie.pathToImage}" alt="" />
                  </div>

              <p style="color: white; font-size:30px" >      ${movie.name}   </p>
              </br>
              <p class="movieRating__content">  ${movie.rating}   </p>
              </br>
              <p style="color: white">      ${movie.description}   </p>

              </br>
               <form action="${pageContext.request.contextPath}/controller?command=addMovieRating&id=${movie.id}"
                   method="post">
                      <select class = "select__movieRaring" name ="rating">
                         <option class = "selected__movieRating__item" disabled selected>
                            <fmt:message bundle="${local}"  key="local.movie.chooseMark" />
                         </option>
                         <option class = "selected__genre__item" value ="1">  1.0  </option>
                         <option class = "selected__genre__item" value ="2">  2.0  </option>
                         <option class = "selected__genre__item" value ="3">  3.0  </option>
                         <option class = "selected__genre__item" value ="4">  4.0  </option>
                         <option class = "selected__genre__item" value ="5">  5.0  </option>
                         <option class = "selected__genre__item" value ="6">  6.0  </option>
                         <option class = "selected__genre__item" value ="7">  7.0  </option>
                         <option class = "selected__genre__item" value ="8">  8.0  </option>
                         <option class = "selected__genre__item" value ="9">  9.0  </option>
                         <option class = "selected__genre__item" value ="10">  10.0  </option>
                         <input type="submit" class="submit__movie" value= "<fmt:message bundle="${local}"
                         key="local.button.rateMovie" />"/>
                      </select>
                      <c:if test="${requestScope.repeatMessage}">
                          <h2 style="color:red; font-size: 20px"> You already rate movie </h2>
                      </c:if>
               </form>


               </br>

               <form action="${pageContext.request.contextPath}/controller">
                        <input type="hidden" name="command" value="addReviewToMovie">
                        <input type="hidden" name="movieId" value="${movie.id}">
                        <input type="text"  name="review"
                          placeholder= "<fmt:message bundle="${local}" key="local.movie.enterReview" />" />
                        <button  type="submit" class= "submit__movie">
                            <fmt:message bundle="${local}"  key="local.movie.addReview" />
                        </button>
               </form>

               </br>

               <section class="movie__reviews">
                 <div class="movie__wrapper__wide">
                     <c:forEach items="${movie.movieReviews}" var="review">
                         <div class="user__review">
                             <b class="username" style="color: white">${user.name}</b>
                             <p class="review__content" style="color: white">
                                     ${review.review}
                             </p>
                         </div>
                     </c:forEach>
                 </div>
              </section>
          </main>
    </body>
</html>