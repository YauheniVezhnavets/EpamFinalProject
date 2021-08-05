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
      </header>


    <main>
     <section class="intro__main">
         <div class = "wrapper">
           <form action="${pageContext.request.contextPath}/controller?command=addMovie" method="post" >
            <h1 style="color:white">
            <fmt:message bundle="${local}" key="local.menu.addMovie" />
            </h1>
            <hr/>
            <input type="text" name="pathToImage"
             placeholder="<fmt:message bundle="${local}" key="local.movie.pathToImage" />" />

            <input type="text" name="name"
            placeholder="<fmt:message bundle="${local}" key="local.movie.name" />" />

            <input type="text" name="description"
            placeholder="<fmt:message bundle="${local}" key="local.movie.description" />" />

            <input type="text" name="genre"
             placeholder="<fmt:message bundle="${local}" key="local.movie.genre" />" />

            <input type="submit" value= "<fmt:message bundle="${local}"
                  key="local.button.addMovie" />"/>
           </form>
           <c:if test="${requestScope.incorrectGenre}">
               <h2 style="color:red; font-size: 20px">
                <fmt:message bundle="${local}" key="local.message.incorrectGenre" />
               </h2>
           </c:if>
         </div>
      </section>
    </main>
  </body>
</html>