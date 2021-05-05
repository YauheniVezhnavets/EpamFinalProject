<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />

<html>
     <body>
        <div class "wrapper">
            <div class= "header__wrapper">
               <div class = "header__logo">
                 <a href="${pageContext.request.contextPath}/controller?command=mainPage" class="header__link">
                 <fmt:message bundle="${local}" key="local.label.movieRating" /> </a>
               </div>
               <nav class= "header__nav">
                 <ul class="header__list">
                  <c:if test="${sessionScope.user.role == 'USER'}">
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=rating" class="header__link">
                      <fmt:message bundle="${local}" key="local.menu.userRating" /> </a>
                    </li>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=movies" class="header__link">
                       <fmt:message bundle="${local}" key="local.menu.movies" /> </a>
                    </li>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=about" class="header__link">
                       <fmt:message bundle="${local}" key="local.menu.aboutUs" /> </a>
                    </li>
                  </c:if>
                  <c:if test="${sessionScope.user.role == 'ADMIN'}">
                   <li class = "header__item">
                        <a href="${pageContext.request.contextPath}/controller?command=getUsers" class="header__link">
                        <fmt:message bundle="${local}" key="local.menu.users" /> </a>
                   </li>
                   <li class = "header__item">
                        <a href="${pageContext.request.contextPath}/controller?command=addMoviePage" class="header__link">
                        <fmt:message bundle="${local}" key="local.menu.addMovie" /> </a>
                   </li>
                   <li class = "header__item">
                        <a href="${pageContext.request.contextPath}/controller?command=getMoviesForPossibleDelete"
                        class="header__link">
                        <fmt:message bundle="${local}" key="local.menu.deleteMovie" /> </a>
                   </li>
                  </c:if>
                    <li class = "header__item">
                       <a href="${pageContext.request.contextPath}/controller?command=logout"  class="header__link">
                       <fmt:message bundle="${local}" key="local.menu.logout" /> </a>
                    </li>
                 </ul>
               </nav>
            </div>
        </div>
     </body>
 </html>