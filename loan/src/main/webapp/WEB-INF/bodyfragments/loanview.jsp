<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section class="vh-100 gradient-custom ">
	<div class="container py-5 h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-12 col-lg-9 col-xl-7">
				<div class="card shadow-2-strong card-registration"
					style="border-radius: 15px; margin-bottom: 30px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); background-color: black !important; color: white;">
					<div class="card-body p-8 p-md-9">
						<%@include file="businessMessage.jsp"%>

						<c:choose>
							<c:when test="${form.id>0}">
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Edit Loan</h3>
							</c:when>

							<c:otherwise>
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Apply Loan</h3>
							</c:otherwise>
						</c:choose>

						<sf:form method="post"
							action="${pageContext.request.contextPath}/applyLoan"
							modelAttribute="form" enctype="multipart/form-data">
							<sf:input type="hidden" id="id"
								class="form-control form-control-lg" path="id" name="id"
								value="${form.id}" />

							<div class="row">

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="firstName">
											<label class="form-label" for="firstName">FirstName</label>
											<sf:input type="text" id="firstName"
												class="form-control form-control-lg" path="firstName"
												name="firstName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="lastName">
											<label class="form-label" for="lastName">lastName</label>
											<sf:input type="text" id="lastName"
												class="form-control form-control-lg" path="lastName"
												name="lastName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="address">
											<label class="form-label" for="address">address</label>
											<sf:input type="text" id="address"
												class="form-control form-control-lg" path="address"
												name="address" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>


							</div>
							
							
								<div class="row">

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="pancard">
											<label class="form-label" for="pancard">Pan Card</label>
											<sf:input type="text" id="pancard"
												class="form-control form-control-lg" path="pancard"
												name="pancard" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="adharcard">
											<label class="form-label" for="adharcard">Adhar Card</label>
											<sf:input type="text" id="adharcard"
												class="form-control form-control-lg" path="adharcard"
												name="adharcard" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="bplcard">
											<label class="form-label" for="bplcard">bplcard</label>
											<sf:input type="text" id="bplcard"
												class="form-control form-control-lg" path="bplcard"
												name="bplcard" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
							</div>
							
							
							<h2>Parent Details</h2>
							<div class="row">

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="parentName">
											<label class="form-label" for="parentName">parentName</label>
											<sf:input type="text" id="parentName"
												class="form-control form-control-lg" path="parentName"
												name="parentName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="parentOccupation">
											<label class="form-label" for="parentOccupation">parentOccupation</label>
											<sf:input type="text" id="parentOccupation"
												class="form-control form-control-lg" path="parentOccupation"
												name="parentOccupation" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="parentIncome">
											<label class="form-label" for="parentIncome">parentIncome</label>
											<sf:input type="text" id="parentIncome"
												class="form-control form-control-lg" path="parentIncome"
												name="parentIncome" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>


							</div>
							
							
							
							<div class="row">

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="loanAmount">
											<label class="form-label" for="loanAmount">loanAmount</label>
											<sf:input type="text" id="loanAmount"
												class="form-control form-control-lg" path="loanAmount"
												name="loanAmount" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="collegeName">
											<label class="form-label" for="collegeName">collegeName</label>
											<sf:input type="text" id="collegeName"
												class="form-control form-control-lg" path="collegeName"
												name="collegeName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="branchName">
											<label class="form-label" for="branchName">branchName</label>
											<sf:input type="text" id="branchName"
												class="form-control form-control-lg" path="branchName"
												name="branchName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="graduationPercentage">
											<label class="form-label" for="graduationPercentage">graduationPercentage</label>
											<sf:input type="text" id="graduationPercentage"
												class="form-control form-control-lg" path="graduationPercentage"
												name="graduationPercentage" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
										<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="cgpa">
											<label class="form-label" for="cgpa">cgpa</label>
											<sf:input type="text" id="cgpa"
												class="form-control form-control-lg" path="cgpa"
												name="cgpa" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="dropYears">
											<label class="form-label" for="dropYears">dropYears</label>
											<sf:input type="text" id="dropYears"
												class="form-control form-control-lg" path="dropYears"
												name="dropYears" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
								


							</div>
							
							
							<h2>Bank Details</h2>
							<div class="row">

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="bankName">
											<label class="form-label" for="bankName">bankName</label>
											<sf:input type="text" id="bankName"
												class="form-control form-control-lg" path="bankName"
												name="bankName" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="accountNumber">
											<label class="form-label" for="accountNumber">accountNumber</label>
											<sf:input type="text" id="accountNumber"
												class="form-control form-control-lg" path="accountNumber"
												name="accountNumber" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<s:bind path="ifscCode">
											<label class="form-label" for="ifscCode">ifscCode</label>
											<sf:input type="text" id="ifscCode"
												class="form-control form-control-lg" path="ifscCode"
												name="ifscCode" />
											<font color="red" style="font-size: 15px"><sf:errors
													path="${status.expression}" /></font>
										</s:bind>

									</div>

								</div>


							</div>
							
		                     <h2>Upload documents</h2>
							<div class="row">
								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<label class="form-label" for="tenthMarksheetImage">10th Marksheet</label> <input
											type="file" class="form-control form-control-lg" name="tenthMarksheetImage"
											required="required" /> <font color="red"
											style="font-size: 15px"></font>
									</div>
								</div>
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<label class="form-label" for="twelfthMarksheetImage">12th Marksheet</label> <input
											type="file" class="form-control form-control-lg" name="twelfthMarksheetImage"
											required="required" /> <font color="red"
											style="font-size: 15px"></font>
									</div>
								</div>
								
								
									<div class="col-md-6 mb-4">
									<div class="form-outline">
										<label class="form-label" for="graduationMarksheetImage">Graduation Marksheet</label> <input
											type="file" class="form-control form-control-lg" name="graduationMarksheetImage"
											required="required" /> <font color="red"
											style="font-size: 15px"></font>
									</div>
								</div>

							</div>

							<c:choose>
								<c:when test="${form.id>0}">
									<div class="mt-4 pt-2">
										<input class="btn btn-primary btn-lg"
											style="border-color: white; color: black; background-color: white; font-weight: bold;"
											type="submit" value="Update" />
									</div>
								</c:when>

								<c:otherwise>
									<div class="mt-4 pt-2">
										<input class="btn btn-primary btn-lg"
											style="border-color: white; color: black; background-color: white; font-weight: bold;"
											type="submit" value="Add" />
									</div>
								</c:otherwise>
							</c:choose>

						</sf:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>