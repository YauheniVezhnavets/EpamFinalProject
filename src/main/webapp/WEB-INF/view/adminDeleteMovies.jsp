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

    <main class= "main">
      <section class="intro__main">
        <div class = "wrapper">
          <table class="table" >
            <thead>
              <tr>
                <th>
                  <fmt:message bundle="${local}" key="local.menu.movies" />
                </th>
                <th>
                  <fmt:message bundle="${local}" key="local.menu.action" />
                </th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${sessionScope.movies}" var="movie">
                <form action="${pageContext.request.contextPath}/controller" method="post">
                  <input type="hidden" name="command" value="deleteMovie" />
                  <input type="hidden" name="id" value="${movie.id}" />
                     <tr>
                       <th>${movie.name}</th>
                       <th>
                          <input type="submit"  value= "<fmt:message bundle="${local}"
                           key="local.button.delete" />"/>
                       </th>
                    </tr>
                </form>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </section>
    </main>
    </body>
</html>