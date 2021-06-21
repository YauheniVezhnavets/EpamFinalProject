<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />

<html>
     <body>
        <nav class= "header__nav">
             <ul class="header__list">
                <div class="english">
                   <form action="${pageContext.request.contextPath}/controller?command=changeLanguage" method="post" >
                      <button name="language" value="english" type="submit">
                         EN
                      </button>
                   </form>
                </div>

                <div class="belarus">
                   <form action="${pageContext.request.contextPath}/controller?command=changeLanguage" method="post" >
                      <button  name="language" value="belarus" type="submit">
                         BY
                      </button>
                   </form>
                </div>

                <div class="russian">
                   <form action="${pageContext.request.contextPath}/controller?command=changeLanguage" method="post" >
                      <button name="language" value="russian" type="submit">
                         RU
                      </button>
                   </form>
                </div>
             </ul>
        </nav>
     </body>
</html>