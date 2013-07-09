
<h3><fmt:message key="OrderError"/></h3><br>

<c:remove var="cart" scope="session" />
<c:url var="url" value="/bookstore" />
<strong><a href="${url}"><fmt:message key="ContinueShopping"/></a>&nbsp;&nbsp;&nbsp;</strong>  
