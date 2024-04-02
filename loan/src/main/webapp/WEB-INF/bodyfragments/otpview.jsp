<%@page import="java.text.DateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="home-content-wrapper">
  <div class="overlay-box">
   <div class="container">
    <div class="welcome-text">WELCOME TO <br/>Loan Origination System </div> 
    <%@include file="businessMessage.jsp" %>
    <sf:form method="post" action="${pageContext.request.contextPath}/otp" modelAttribute="form">
            <sf:input type="hidden" id="id" class="form-control form-control-lg" path="id" name="id" value="${form.id}"/>
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">   
                  <s:bind path="otp">
                  <label class="form-label" for="otp">Enter OTP</label>
                  <sf:input type="text" id="otp" class="form-control form-control-lg" path="otp" name="otp"/>
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                  </s:bind>      
                  
                  
                  </div>
				 
                </div>
               </div>

               <div >
                <input class="btn btn-primary btn-lg" type="submit" value="Verify" />
              </div>
  

           </sf:form>
          
    
   </div>
  </div> 
 </div>

<div class="jumbotron text-center" style="position: relative; min-height: 10vh">
	<h1>Supermarket Billing Management System</h1>
<h6 class="text-center">Manage Sales and products</h6>
</div>

<div class="container-fluid text-center ">

</div>