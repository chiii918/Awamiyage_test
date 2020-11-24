<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="websys2.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
	//サーブレットのリクエストからProduct Beanのリストを取得する
	List<Product> product_list = new ArrayList();
	Object title = "";

	if (request != null) {
		product_list = (List<Product>) request.getAttribute("product_list");
		title = (request.getAttribute("title")).toString();
		System.out.println(title);
	}
%>

<%@ include file="header.jsp"%>

<h1><%= title %></h1>

<%
	if (request != null && product_list != null) {
	if (product_list.size()> 0) {
%>

<hr>
<table border="1">
	<tr>
		<th>ID</th>
		<th>商品名</th>
		<th>価格(円)</th>
		<th>カテゴリ</th>
	</tr>

	<%
		for (Product p : product_list) {
	%>
	<tr>
		<td width="30" align="right"><%=p.getId()%></td>
		<td width="200" align="left"><%=p.getName()%></td>
		<td width="100" align="right"><%=p.getPrice()%></td>
		<td width="200" align="right"><%=p.getCategory()%></td>
	</tr>
	<%
		}
	%>

</table>

<p>商品件数：<%=product_list.size()%></p>

<%
	}
}
%>


<%@ include file="footer.jsp"%>

