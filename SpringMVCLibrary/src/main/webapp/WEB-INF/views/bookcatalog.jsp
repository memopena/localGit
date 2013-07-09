
<jsp:useBean id="bookDB" class="com.javaagile.weblibrary.database.BookDB" scope="page" >
  <jsp:setProperty name="bookDB" property="database" value="${bookDBAO}" />
</jsp:useBean>


<c:if test="${!empty param.Add}">
  <c:set var="bid" value="${param.Add}"/>
  <jsp:setProperty name="bookDB" property="bookId" value="${bid}" />
  <c:set var="addedBook" value="${bookDB.bookDetails}" />
    <p><h3><font color="red" size="+2"> 
    <fmt:message key="CartAdded1"/> <em>${addedBook.title}</em> <fmt:message key="CartAdded2"/></font></h3>
</c:if>

<c:if test="${sessionScope.cart.numberOfItems > 0}">     
  <c:url var="url" value="/bookshowcart" >
    <c:param name="Clear" value="0" />
    <c:param name="Remove" value="0" />
  </c:url>
<p><strong><a href="${url}"><fmt:message key="CartCheck"/></a>&nbsp;&nbsp;&nbsp;
    <c:url var="url" value="/bookcashier" />
    <a href="${url}"><fmt:message key="Buy"/></a></p></strong>
</c:if>

<br>&nbsp;
<br>&nbsp;
<h3><fmt:message key="Choose"/></h3>
<center>
<table summary="layout">


<c:forEach var="book" begin="0" items="${bookDB.books}">
    <tr>
    <c:set var="bookId" value="${book.bookId}" />
    <td bgcolor="#ffffaa"> 
        <c:url var="url" value="/bookdetails" >
          <c:param name="bookId" value="${bookId}" />
        </c:url>
        <a href="${url}"><strong>${book.title}&nbsp;</strong></a></td> 
    <td bgcolor="#ffffaa" rowspan=2> 
    <fmt:formatNumber value="${book.price}" type="currency"/> 
    &nbsp;</td> 

    <td bgcolor="#ffffaa" rowspan=2> 
    <c:url var="url" value="/bookcatalog" >
      <c:param name="Add" value="${bookId}" />
    </c:url> 
    <p><strong><a href="${url}">&nbsp;<fmt:message key="CartAdd"/>&nbsp;</a></td></tr> 

    <tr> 
    <td bgcolor="#ffffff"> 
    &nbsp;&nbsp;<fmt:message key="By"/> <em>${book.firstName}&nbsp;${book.surname}</em></td></tr>
</c:forEach>

</table>
</center>

