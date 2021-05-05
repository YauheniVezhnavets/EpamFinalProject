<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<meta http-equiv="Cache-Control" content="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />



<html>
<head>
    <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
    <title> MovieRating </title>
    <link rel="stylesheet" href="static/css/style.css" />
</head>
    <body>
        <nav class="header">
             <jsp:include page="WEB-INF/view/fragments/login_header.jsp" />
        </nav>

         <main class= "main">
               <section class="intro__login">
                    <div class = "wrapper">
                        <h1 class="intro__title">
                            <fmt:message bundle="${local}" key="local.label.logIn" />
                        </h1>
                        <form action="${pageContext.request.contextPath}/controller" method="post">
                        <p class "submit-form__info">
                         <input type="hidden" name="command" value="login" />
                         <input type="text" class="input-form__field" name="username"
                          placeholder= "<fmt:message bundle="${local}" key="local.placeholder.login" />" />

                         <input type="password" class="input-form__field" name="password"
                          placeholder="<fmt:message bundle="${local}" key="local.placeholder.password" />" />

                          <input type="submit" class="submit" value= "<fmt:message bundle="${local}" key="local.button.submit" />"/>
                          </p>
                    </div>
               </section>
          </main>
    </body>
</html>
