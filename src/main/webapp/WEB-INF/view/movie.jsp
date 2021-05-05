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
              <br/>
              <p style="color: white">      ${movie.description}   </p>

                  </div>
                 </section>
              </main>
    </body>
</html>