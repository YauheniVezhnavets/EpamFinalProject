<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />

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
                    <div class= "movies__container">
                      <c:forEach items="${sessionScope.movies}" var="movie" >
                         <div class = "image" >
                           <a href="${pageContext.request.contextPath}/controller?command=movie&id=${movie.id}" >
                           ${movie.name}
                                <img src="${movie.pathToImage}" alt="" />
                            </a>
                          </div>
                       </c:forEach>
                    </div>
                 </section>
                 <div class= "pagination__container">
                   <jsp:include page="fragments/pagination.jsp" />
                 </div>
           </main>
    </body>
</html>