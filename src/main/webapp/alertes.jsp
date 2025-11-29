<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<div class="container mt-4">
  <h3 class="mb-3">Alertes</h3>
  <ul class="list-group">
    <li class="list-group-item d-flex justify-content-between align-items-center">
      Message d'alerte Test
      <span class="badge bg-warning text-white">
      Warning
      </span>
    </li>
    
    <li class="list-group-item d-flex justify-content-between align-items-center">
      Message d'alerte Test
      <span class="badge bg-danger text-white">
        Danger
      </span>
    </li>
    <li class="list-group-item text-center text-muted">
      Aucune alerte
    </li>
  </ul>
</div>
	
<%@ include file="../footer.jsp" %>