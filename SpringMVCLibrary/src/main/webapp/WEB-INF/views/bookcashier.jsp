
<p><fmt:message key="Amount"/>
<strong><fmt:formatNumber value="${sessionScope.cart.total}" type="currency"/></strong>
</strong>

<p><fmt:message key="Purchase"/>
<c:url var="url" value="/bookreceipt" />

<form action="${url}" method="post">
<table summary="layout">
<tr>
<td><strong><fmt:message key="Name"/></strong></td>
<td><input type="text" name="cardname" value="Gwen Canigetit" size="19"></td>
</tr>
<tr>
<td><strong><fmt:message key="CCNumber"/></strong></td>
<td><input type="text" name="cardnum" value="xxxx xxxx xxxx xxxx" size="19"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="<fmt:message key="Submit"/>"></td>
</tr>
</table>
</form>
