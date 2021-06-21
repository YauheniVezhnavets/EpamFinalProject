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
                   <fmt:message bundle="${local}" key="local.label.movieRating" />
               </div>
               <jsp:include page="local.jsp" />
            </div>
        </div>
     </body>
 </html>