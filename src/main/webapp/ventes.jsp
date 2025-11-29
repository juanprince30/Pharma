<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.prince.Vente" %>

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
          <h2 class="text-uppercase">Listes des Ventes</h2>
        </div>
        <div class="col-6 d-flex justify-content-end" style="margin-bottom: 15px">
            <a href="${pageContext.request.contextPath}/ventes/add"><button class="btn btn-info">Ajouter une vente</button></a>
        </div>
      </div>
    <div class="row mb-5">
      <div class="col-md-12">
        <div class="site-blocks-table">
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>Image</th>
                <th>Produit</th>
                <th>Prix</th>
                <th>Quantité Vendue</th>
                <th>Date de la vente</th>
                <th>Total</th>
              </tr>
            </thead>
            <tbody>
            
            	<%
				    List<Vente> ventes = (List<Vente>) request.getAttribute("ventes");
	      			
            		double total=0;
            		
				
				    if (ventes != null) {
				    	for(Vente d : ventes){
				    		total=total+d.getTotal();
				    	}
				    	
				        for (Vente d : ventes) {
				      
				%>
				
				<tr >
	                <td>
	                  <img src="<%= request.getContextPath() + "/" + d.getDrug().getImage() %>" alt="Image" class="img-fluid" style="height: 200px; object-fit: cover;" />
	                </td>
	                <td><%= d.getDrug().getNom() %></td>
	                <td><%= d.getDrug().getPrix() %> FCFA</td>
	                <td><%= d.getQuantitySold() %></td>
	                <td> <%= d.getDate() %></td>
	                <td><%= d.getTotal() %> FCFA</td>
	             </tr>
				
				<%
				        }
				    }
				%>
              
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <div class="row justify-content-end">
      <div class="col-md-12">
        <h4 class="text-uppercase border-bottom pb-2">Total des Ventes</h4>
        <div class="d-flex justify-content-between mb-4">
          <span>Total</span>
          <strong><%= total %> FCFA</strong>
        </div>
      </div>
    </div>
  </div>
</div>

	
<%@ include file="../footer.jsp" %>