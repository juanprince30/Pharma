<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.prince.Drug" %>

<%@ include file="../header.jsp" %>

<%
	//pour enpecher le retour aprea
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	

	if(session.getAttribute("email")==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>

<%
	Drug d= (Drug) request.getAttribute("drug");
%>

<div class="site-section">
    <div class="container">
      <div class="row">
        <div class="col-md-5 mr-auto">
          <div class="border text-center">
            <img src="<%= request.getContextPath() + "/" + d.getImage() %>" alt="Image" class="img-fluid p-5">
          </div>
        </div>
        <div class="col-md-6">
        	<br>
          <h2 class="text-black"> <%= d.getNom() %></h2>
          <p><%= d.getCategory() %></p>
          <p> Date d'expiration: <%= d.getDateExpiration() %></p>
          

          <p><strong><%= d.getPrix() %></strong></p>

          
          
          <div class="mb-5">
            <div class="input-group mb-3" style="max-width: 220px;">
              <input type="text" class="form-control text-center" value="<%= d.getQuantite() %>" placeholder=""
                aria-label="Example text with button addon" aria-describedby="button-addon1" readonly>
            </div>

                    <p>
                        <a href="${pageContext.request.contextPath}/medicaments/edit/<%= d.getId() %>" class="buy-now btn btn-sm height-auto px-4 py-3 btn-primary">
                            Modifier
                        </a>
                    </p>

          </div>
        </div>
      </div>
    </div>
  </div>


<%@ include file="../footer.jsp" %>