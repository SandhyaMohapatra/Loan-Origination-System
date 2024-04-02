<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan List</title>
</head>
<body >

<div class="container content" >

<h2 style="padding-top: 30px">Loan List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark" style="margin-top: 20px;">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Address</th>
       <th scope="col">Loan Account Number</th>
      <th scope="col">Action</th>
  
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.firstName}</td>
      <td>${li.lastName}</td>
      <td>${li.address}</td>
      <td>${li.loanAccNum}</td>
      <td>      
      <a href="${pageContext.request.contextPath}/loanDetails?id=${li.id}">View Details</a>
           
      </td>

    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>