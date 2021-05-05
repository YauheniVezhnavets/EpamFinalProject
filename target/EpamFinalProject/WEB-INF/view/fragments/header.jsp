<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
     <body>
        <div class "wrapper">
            <div class= "header__wrapper">
               <div class = "header__logo">
                 <a href="${pageContext.request.contextPath}/controller?command=mainPage" class="header__link">MoviesRating </a>
               </div>
               <nav class= "header__nav">
                 <ul class="header__list">
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=rating" class="header__link">Rating </a>
                    </li>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=movies" class="header__link">Movies </a>
                    </li>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=about" class="header__link">About us</a>
                    </li>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=logout"  class="header__link">Logout</a>
                    </li>
                 </ul>
               </nav>
            </div>
        </div>
     </body>
 </html>