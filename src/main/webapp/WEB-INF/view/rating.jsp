<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />

<fmt:message bundle="${local}" key="local.profile.name" var="name" />
<fmt:message bundle="${local}" key="local.profile.userRating" var="userRating" />
<fmt:message bundle="${local}" key="local.profile.id" var="id" />


<html>
    <head>
    <link rel="stylesheet" href="static/css/style.css" />
    </head>


    <body>
         <header class="header">
              <jsp:include page="fragments/header.jsp" />
          </header>

            <main class= "main">
                 <section class="intro__main">
                 <div class = "wrapper__rating">
                          <p style= "font-size:50px" > Name  : ${sessionScope.user.name} </p>
                           <br/>
                          <p style= "font-size:30px" >  Status: ${sessionScope.user.userRating} </p>
                 </div>
                </section>
          </main>
    </body>
</html>