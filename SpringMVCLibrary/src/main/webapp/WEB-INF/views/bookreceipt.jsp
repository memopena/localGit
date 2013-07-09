
<h3><fmt:message key="ThankYou"/> ${param.cardname}.</h3><br>  
<jsp:useBean id="now" class="java.util.Date" />
<jsp:setProperty name="now" property="time" value="${now.time + 432000000}" />
<fmt:message key="ShipDate"/> <fmt:formatDate value="${now}" type="date" dateStyle="full"/>.<br><br>

<c:remove var="cart" scope="session" />
<c:url var="url" value="/bookstore" />
<strong><a href="${url}"><fmt:message key="ContinueShopping"/></a>&nbsp;&nbsp;&nbsp;</strong>  



