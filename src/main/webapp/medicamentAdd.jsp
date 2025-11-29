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


<form action="${pageContext.request.contextPath}/medicaments/add" method="post" enctype="multipart/form-data">

	<div class="row mt-5">
	    <div class="col-md-6 mb-5 mb-md-0">
	      <h2 class="h3 mb-3 text-black ps-5">Ajouter Médicament</h2>
	      <div class="p-3 p-lg-5 border rounded-3 shadow-sm">
	        <div class="form-group mb-3">
	          <label class="text-black">Nom Médicament <span class="text-danger">*</span></label>
	          <input type="text" class="form-control" name="nom" id="nom" required placeholder="Nom du médicament" />
	        </div>
	
	        <div class="form-group mb-3">
	          <label class="text-black">Catégorie <span class="text-danger">*</span></label>
	          <input type="text" class="form-control" name="category" id="category" required placeholder="Catégorie du médicament" />
	        </div>
	
	        <div class="form-group mb-3">
	          <label class="text-black">Image du Médicament <span class="text-danger">*</span></label>
	          <input type="file" class="form-control" name="image" id="image" accept="image/*" required />
	        </div>
	
	        <div class="text-center mb-3">
	          <img id="imgPreview" alt="Aperçu" class="img-fluid rounded shadow-sm" width="150" style="display:none" />
	        </div>
	
	        <div class="form-group mb-3">
	          <label class="text-black">Date d'expiration <span class="text-danger">*</span></label>
	          <input type="date" class="form-control" name="expirationDate" id="expirationDate" required />
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
	          <label class="text-black">Prix unitaire <span class="text-danger">*</span></label>
	          <input type="number" class="form-control" name="price" id="price" required min="1" placeholder="Prix unitaire"/>
	        </div>
	
	        <button type="submit" class="btn btn-primary btn-lg btn-block">
	          Enregistrer
	        </button>
	      </div>
	    </div>
	  </div>
	
</form>


<script>
    document.getElementById("image").addEventListener("change", function(event) {
        let file = event.target.files[0];
        if (file) {
            let imgPreview = document.getElementById("imgPreview");
            imgPreview.src = URL.createObjectURL(file);
            imgPreview.style.display = "block";
        }
    });
</script>

<%@ include file="../footer.jsp" %>