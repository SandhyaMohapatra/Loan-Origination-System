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

<h2 style="padding: 30px">Loan Detail</h2>
<%@include file="businessMessage.jsp" %>


<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Details</th>
    </tr>
  </thead>
  <tbody>
    <tr>    
      <td>First Name</td>
      <td>${loan.firstName}</td>
    </tr>
    
     <tr>    
      <td>Last Name</td>
      <td>${loan.lastName}</td>
    </tr>
    
     <tr>    
      <td>Address</td>
      <td>${loan.address}</td>
    </tr>
    
     <tr>    
      <td>PanCard</td>
      <td>${loan.pancard}</td>
    </tr>
    
     <tr>    
      <td>Adhar card</td>
      <td>${loan.adharcard}</td>
    </tr>
    
    
     <tr>    
      <td>BPL Card</td>
      <td>${loan.bplcard}</td>
    </tr>
    
    
     <tr>    
      <td>Parent Name</td>
      <td>${loan.parentName}</td>
    </tr>
    
     <tr>    
      <td>Parent Occupation</td>
      <td>${loan.parentOccupation}</td>
    </tr>
    
     <tr>    
      <td>Parent Income</td>
      <td>${loan.parentIncome}</td>
    </tr>
    
     <tr>    
      <td>Loan Amount</td>
      <td>${loan.loanAmount}</td>
    </tr>
    
     <tr>    
      <td>Loan Account Number</td>
      <td>${loan.loanAccNum}</td>
    </tr>
    
     <tr>    
      <td>College Name</td>
      <td>${loan.collegeName}</td>
    </tr>
    
     <tr>    
      <td>Branch Name</td>
      <td>${loan.branchName}</td>
    </tr>
     <tr>    
      <td>Graduation Percentage</td>
      <td>${loan.graduationPercentage}</td>
    </tr>
     <tr>    
      <td>CGPA</td>
      <td>${loan.cgpa}</td>
    </tr>
     <tr>    
      <td>Drop Years</td>
      <td>${loan.dropYears}</td>
    </tr>
     <tr>    
      <td>Account Number</td>
      <td>${loan.accountNumber}</td>
    </tr>
     <tr>    
      <td>IFSC Code</td>
      <td>${loan.ifscCode}</td>
    </tr>
     <tr>    
      <td>Status</td>
      <td>
      <p class="btn btn-outline-info">${loan.status} By Admin</p>
      </td>
    </tr>
    
    <tr>    
      <td>Status</td>
      <td>
      <p class="btn btn-outline-info">${loan.officerStatus} By Loan Officer</p>
      </td>
    </tr>
     <tr>    
      <td>10th Marksheet</td>
      <td><img alt="" src="${pageContext.request.contextPath}/getTenthMarksheetImage/${loan.id}" width="150px" height="100px" ></td>
    </tr>
    
     <tr>    
      <td>12th Marksheet</td>
      <td><img alt="" src="${pageContext.request.contextPath}/getTwelfthMarksheetImage/${loan.id}" width="150px" height="100px" ></td>
    </tr>
    
    
     <tr>    
      <td>Graducation Marksheet</td>
      <td><img alt="" src="${pageContext.request.contextPath}/getGraduationMarksheetImage/${loan.id}" width="150px" height="100px" ></td>
    </tr>
    
    <tr>    
      <td>ROI</td>
      <td>${loan.roi}%</td>
    </tr>
    <c:if test="${sessionScope.user.userRole == 'Admin'}"> 
    <tr>    
      <td>Action</td>
     <td>
      <a href="${pageContext.request.contextPath}/approveLoan?id=${loan.id}" class="btn btn-outline-success">Approve</a>
      <a href="${pageContext.request.contextPath}/rejectLoan?id=${loan.id}" class="btn btn-outline-danger">Reject</a>
     
     </td>
    </tr>
   </c:if>
  
   <c:if test="${sessionScope.user.userRole == 'Officer'}"> 
    <tr>    
      <td>Action</td>
     <td>
      <a href="${pageContext.request.contextPath}/approveLoanByOfficer?id=${loan.id}" class="btn btn-outline-success">Approve</a>
      <a href="${pageContext.request.contextPath}/rejectLoanByOfficer?id=${loan.id}" class="btn btn-outline-danger">Reject</a>
     
     </td>
    </tr>
   </c:if>


  </tbody>
</table>




</div>

</body>
</html>