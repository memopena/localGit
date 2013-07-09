
<%-- Display localized string of "What" --%>
<p><b><fmt:message key="What"/></b></p>

<%-- Create bookDB attribute in a page scope --%>
<jsp:useBean id="bookDB" class="com.javaagile.weblibrary.database.BookDB" scope="page" >
    <jsp:setProperty name="bookDB" property="database" value="${bookDBAO}" />
</jsp:useBean>

<%-- Set the bookId property of the bookDB bean with value of "203" --%>
<jsp:setProperty name="bookDB" property="bookId" value="203" />

<p>
<%-- Retrieve the result of /bookdetails --%>
<c:url var="url" value="/bookdetails" />
<blockquote><p><em><a href="${url}?bookId=203">${bookDB.bookDetails.title}</a></em>,
    <c:url var="url" value="/bookcatalog" />
<fmt:message key="Talk"/></blockquote>
<p><b><a href="${url}?Add="><fmt:message key="Start"/></a></b>


