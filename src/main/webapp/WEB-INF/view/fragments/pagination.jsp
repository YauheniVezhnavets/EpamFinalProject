<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
    <head>
    <link rel="stylesheet" href="static/css/style.css" />
    </head>


    <body>
        <div class ="pagination">
            <c:forEach items="${sessionScope.paginationList}" var="page">
                 <span>
                      <a href="${pageContext.request.contextPath}/controller?command=pageAction&page=${page}">
                            ${page}
                      </a>
                 </span>
            </c:forEach>
        </div>
    </body>
</html>