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
		   <%
			    List<Drug> drugs = (List<Drug>) request.getAttribute("drugs");
      			
			      
			%>


<form action="${pageContext.request.contextPath}/ventes/add" method="post">

	<div class="row mt-5">
	    <div class="col-md-6 mb-5 mb-md-0">
	      <h2 class="h3 mb-3 text-black ps-5">Ajouter une Vente</h2>
	      <div class="p-3 p-lg-5 border rounded-3 shadow-sm">
	        <div class="form-group mb-3">
	          <label class="text-black">Médicament <span class="text-danger">*</span></label>
	          <select class="form-control small-select" name="medoc" id="medoc" required>
	          	  <option value="">-- Selectionner un Medicament --</option>
				  <% for (Drug d : drugs) { %>
				        <option value="<%= d.getId() %>" data-price="<%= d.getPrix() %>"><%= d.getNom() %> (Stock: <%= d.getQuantite() %>)</option>
				  <% } %>
	          </select>
	        </div>
	
	        <div class="form-group mb-3">
	          
	        </div>
	
	        <div class="form-group mb-3">
	          
	        </div>
	
	        <div class="form-group mb-3">
	          
	        </div>
	
	        <div class="form-group mb-3">
	          
	        </div>
	      </div>
	    </div>
	    
	    
	
	    <div class="col-md-6">
	    <h2 class="h3 mb-3 text-black ps-5">Stock</h2>
	      <div class="p-3 p-lg-5 border rounded-3 shadow-sm">
	       
	
	        <div class="form-group mb-3">
	          <label class="text-black">Quantité <span class="text-danger">*</span></label>
	          <input type="number" class="form-control" name="quantity" id="quantity" required min="0" placeholder="Quantité"/>
	        </div>
	
	        <div class="form-group mb-4">
	          
	        </div>
	
	        <div class="form-group mb-4">
	          
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  <br><br>
	  <div class="row">
	  	  <div class="col-md-3"></div>
	      <div class="col-md-6">
	        <h4 class="text-uppercase border-bottom pb-2">Total Vente</h4>
	        <div class="d-flex justify-content-between mb-4">
	          <span>Total</span>
	          <strong><span id="prix"></span> FCFA</strong>
	        </div>
	    </div>
	    <div class="col-md-3"></div>
	    <div class="col-md-3"></div>
	    <div class="col-md-6">
	    	<button type="submit" class="btn btn-primary btn-lg btn-block">
	          Enregistrer
	        </button>
	    </div>
	    <div class="col-md-3"></div>
</form>

<script>
	document.addEventListener('DOMContentLoaded', function () {
	
	    const selectMedoc = document.getElementById("medoc");
	    const inputQty = document.getElementById("quantity");
	    const spanPrix = document.getElementById("prix");
	
	    function updatePrice() {
	        const selectedOption = selectMedoc.options[selectMedoc.selectedIndex];
	        const price = parseFloat(selectedOption.getAttribute("data-price")) || 0;
	        const quantity = parseInt(inputQty.value) || 0;
	
	        if (!price || !quantity) {
	            spanPrix.textContent = "0";
	            return;
	        }
	
	        const total = price * quantity;
	        spanPrix.textContent = total.toLocaleString();
	    }
	
	    selectMedoc.addEventListener("change", function() {
	        updatePrice();
	    });
	
	    inputQty.addEventListener("input", function() {
	        updatePrice();
	    });
	
	});
</script>


	
<%@ include file="../footer.jsp" %>