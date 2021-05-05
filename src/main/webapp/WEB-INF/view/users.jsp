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
                <th>Name</th>
                <th>Current Rating</th>
                <th>Choose Rating</th>
                <th>Change Rating</th>
            </tr>
             </br>
             </br>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.users}" var="user">
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="changeUserRating" />
                    <input type="hidden" name="id" value="${user.id}" />
                   <tr>
                    <th>${user.name}</th>
                    <th>${user.userRating}</th>
                    <th>
                      <select name="userRating">
                        <option value = "PREMIUM">
                          <fmt:message bundle="${local}" key="local.profile.userRating.premium" />
                        </option>
                        <option value="MIDDLE">
                          <fmt:message bundle="${local}" key="local.profile.userRating.middle" />
                         </option>
                        <option value="JUNIOR">
                          <fmt:message bundle="${local}" key="local.profile.userRating.junior" />
                         </option>
                        <option value="BANNED">
                          <fmt:message bundle="${local}" key="local.profile.userRating.banned" />
                          </option>
                      </select>
                    </th>
                      <th>
                           <input type="submit" value="Change">
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