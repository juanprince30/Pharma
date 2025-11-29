<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
	
<div class="site-section">
    <div class="container">
      <div class="row">
        <div class="title-section text-center col-6">
          <h2 class="text-uppercase">Listes des medicaments</h2>
        </div>
        <div class="col-6 d-flex justify-content-end" style="margin-bottom: 15px">
            <a href="${pageContext.request.contextPath}/medicaments/add"><button class="btn btn-info">Ajouter un medicament</button></a>
        </div>
      </div>
      
      <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-6">
                <div class="input-group">
                    <input 
                    type="text" 
                    class="form-control" 
                    placeholder="Rechercher..." 
                    aria-label="Recherche"
                    >
                    <button class="btn btn-primary" type="button">
                    <i class="icon-search"></i> 
                    </button>
                </div>
                </div>
            </div>
        </div>
        <br><br><br>

      <div class="row">
      
      
      		<%
			    List<Drug> drugs = (List<Drug>) request.getAttribute("drugs");
      			java.time.LocalDate today = java.time.LocalDate.now();
			
			    if (drugs != null) {
			        for (Drug d : drugs) {
			      
			%>
        
            <div class="col-sm-6 col-lg-4 text-center item">
                
                <%
				    if (d.getDateExpiration().isBefore(today)) {
				%>
				        <span class="tag_finish">Éxpiré</span>
				<%
				    } else if (d.getQuantite() <= 0) {
				%>
				        <span class="tag_finish">Épuisé</span>
				<%
				    } else {
				%>
				        <span class="tag">En vente</span>
				<%
				    }
				%>
			    
                
                <div class="image-container">
                    <a href="${pageContext.request.contextPath}/medicaments/show/<%= d.getId() %>"> 
                        <img src="<%= request.getContextPath() + "/" + d.getImage() %>" alt="medicament" class="img-fluid w-100" style="height: 200px; object-fit: cover;">
                    </a>
                </div>
                <h3 class="text-dark">
                    <a href=""><%= d.getNom() %>  </a>
                </h3>
                    
                <div class="row">
				    <div class="col-sm-2"></div>
				    <div class="col-sm-2">
				        <p class="price"><%= d.getPrix() %> FCFA</p>
				    </div>
				    <div class="col-sm-2 text-center">
				        
				        <a
				            class="btn text-white py-1 btn-primary" 
				            href="${pageContext.request.contextPath}/medicaments/edit/<%= d.getId() %>"
				        >
				            <i class="icons-btn d-inline-block cart me-1">
				            <span class="icon-edit"></span>
				            </i>
				        </a>
				    </div>
				    <div class="col-sm-1"></div>
				    <div class="col-sm-2 text-center">
				    
				    	<form action="${pageContext.request.contextPath}/medicaments/delete/<%= d.getId() %>" method="POST">
	                         
	               
	                       <button
	                       		type="submit"
					            class="btn text-white py-1 btn-danger"
					            onclick="confirm('Etes vous sure de vouloir supprimer ce medicament?')"
					        >
					            <i class="icons-btn d-inline-block cart me-1">
					            <span class="icon-trash"></span>
					            </i>
					        </button>
	                   </form>
				        
				        
				    </div>
				</div>
                    

               
            </div>
            
            <%
			        }
			    }
			%>
                 
        
      </div>
  </div>
</div>

	
<%@ include file="../footer.jsp" %>
