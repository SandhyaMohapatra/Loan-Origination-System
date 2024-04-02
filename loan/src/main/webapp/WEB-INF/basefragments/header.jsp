<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/" style="color: white;">Loan Origination System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav" style="justify-content: space-between;">
			<div class="float-left">
				<ul class="navbar-nav">
					

					<c:if test="${sessionScope.user == null}">
					<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/" style="color: white;">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loginView" style="color: white;">Login</a></li>
							
					</c:if>

					<c:if test="${sessionScope.user.userRole == 'Admin'}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false" style="color: white;"> Users </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								 <a class="dropdown-item"
									href="${pageContext.request.contextPath}/userList">User
									List</a>
							</div></li>
							
							<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loanList" style="color: white;">Applied Loans</a></li>
                    	
					</c:if>
					
					<c:if test="${sessionScope.user.userRole == 'Officer'}">

							<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loanList" style="color: white;">Applied Loans</a></li>
                    	
					</c:if>

					<c:if test="${sessionScope.user.userRole == 'User'}">
					
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loan" style="color: white;">Apply Loans</a></li>
							
								<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loanList" style="color: white;">Applied Loans</a></li>
						
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/cibil" style="color: white;">Check Cibil</a></li>

					</c:if>



				</ul>
			</div>
			<div>
				<ul class="navbar-nav" style="margin-right: 83px;">
					<c:if test="${sessionScope.user != null}">
			               
								<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/logout" style="color: white;">Logout</a></li>
							
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</nav>