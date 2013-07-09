
<jsp:useBean id="bookDB" class="com.javaagile.weblibrary.database.BookDB" scope="page" >
  <jsp:setProperty name="bookDB" property="database" value="${bookDBAO}" />
</jsp:useBean>

<c:if test="${!empty param.bookId}">
  <c:set var="bid" value="${param.bookId}"/>
  <jsp:setProperty name="bookDB" property="bookId" value="${bid}" />
  <c:set var="book" value="${bookDB.bookDetails}" />
      <h2>${book.title}</h2>
      &nbsp;<fmt:message key="By"/> <em>${book.firstName}&nbsp;${book.surname}</em>&nbsp;&nbsp;
      (${book.year})<br> &nbsp; <br>
      <h4><fmt:message key="Critics"/></h4>
      <blockquote>${book.description}</blockquote>
      <h4><fmt:message key="ItemPrice"/>: <fmt:formatNumber value="${book.price}" type="currency"/></h4>
    <c:url var="url" value="/bookcatalog" >
      <c:param name="Add" value="${bid}" />
    </c:url> 
    <p><strong><a href="${url}"><fmt:message key="CartAdd"/></a>&nbsp; &nbsp; &nbsp;
</c:if>


<c:url var="url" value="/bookcatalog" >
  <c:param name="Add" value="" />
</c:url>
<a href="${url}"><fmt:message key="ContinueShopping"/></a></p></strong>





