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
            <h1>Add Movie</h1>
            <hr/>
            <input type="text" name="pathToImage"  placeholder="pathToImage" />

            <input type="text" name="name" placeholder="name" />
            <input type="text" name="description" placeholder="description" />
            <input type="text" name="genreId"  placeholder="genreId" >

            <input type="submit" value="Submit">
           </form>
         </div>
      </section>
    </main>
  </body>
</html>