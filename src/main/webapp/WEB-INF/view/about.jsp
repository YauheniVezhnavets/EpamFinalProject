<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <div id="about__block">
                      <span id="firstSpan">
                      <fmt:message bundle="${local}" key="local.about.firstString" />
                       </span>
                        </br>
                         <span id="secondSpan">
                        <fmt:message bundle="${local}" key="local.about.secondString" />
                        <a href="mailto:y.vezhnavets@mail.ru"> y.vezhnavets@mail.ru  </a>
                        </span>
                        </br>
                        <span id="thirdSpan">
                        <fmt:message bundle="${local}" key="local.about.thirdString" />
                        </span>
                    </div>
                </div>
            </section>
        <main>
    </body>
</html>