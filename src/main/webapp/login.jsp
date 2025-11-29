<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
	
<%
	//pour enpecher le retour aprea
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	

	if(session.getAttribute("email")!=null){
		request.getRequestDispatcher("medicaments.jsp").forward(request, response);
	}
%>

<div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black"><b>Connexion</b></h2>
          </div>
          <div class="col-md-6">
    
            <form action="${pageContext.request.contextPath}/login" method="post">

               <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Entrer votre Mail" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Mot de passe <span class="text-danger">*</span></label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Entrer votre mot de passe" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Se Connecter">
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="col-md-6">
            <img src="${pageContext.request.contextPath}/images/doctor.jpg" alt="image doctor" class="img-fluid w-100">
          </div>
          <div class="col-md-12">Pas de compte??  <a class="text-primary" href="${pageContext.request.contextPath}/register"> S'inscrire</a></div>
        </div>
      </div>
    </div>
      
</div>

	
<%@ include file="../footer.jsp" %>