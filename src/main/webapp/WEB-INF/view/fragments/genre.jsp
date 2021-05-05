<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="local" />

<html>
     <body>


        <form action="${pageContext.request.contextPath}/controller?command=moviesByGenre" method="post">
         <select class = "select__item" name ="genre" onchange="this.form.submit();">
             <option class = "selected__genre__item" disabled selected>
                   <fmt:message bundle="${local}"  key="local.genre.chooseGenre" />
             </option>

             <option class = "selected__genre__item" value ="comedy">
                <fmt:message bundle="${local}"  key="local.genre.comedy" />
              </option>

              <option class = "selected__genre__item" value = "cartoons">
                   <fmt:message bundle="${local}"  key="local.genre.cartoons" /> </a>
              </option>

              <option class = "selected__genre__item" value = "thriller">
                    <fmt:message bundle="${local}"  key="local.genre.thriller" /> </a>
              </option>

              <option class = "selected__genre__item" value = "drama">
                    <fmt:message bundle="${local}"  key="local.genre.drama" /> </a>
              </option>

              <option class = "header__item" value = "detective">
                    <fmt:message bundle="${local}"  key="local.genre.detective" /> </a>
              </option>

            </select>
          </form>
     </body>
 </html>