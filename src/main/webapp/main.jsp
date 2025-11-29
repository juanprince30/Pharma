

<div class="site-blocks-cover" style="background-image: url('${pageContext.request.contextPath}/images/hero_1.jpg');">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 mx-auto order-lg-2 align-self-center">
            <div class="site-block-cover-content text-center">
              <h2 class="sub-title">Gerer vos médicaments, en un clic, et sans stress.</h2>
              <h1>Bienvenue Chez MaPharma</h1>
              <p>
              		<%
					    if (session.getAttribute("email") != null) {
					%>
					    <a href="${pageContext.request.contextPath}/medicaments" class="btn btn-primary px-5 py-3">Ajouter un Medicament</a>
					    <a href="${pageContext.request.contextPath}/ventes/add" class="btn btn-primary px-5 py-3">Ajouter une Vente</a>
					<%
					    } else {
					%>
					    <a href="${pageContext.request.contextPath}/login" class="btn btn-primary px-5 py-3">Se connecter</a>
					<%
					    }
					%>
                   
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row align-items-stretch section-overlap">
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap bg-primary h-100">
              <a href="#" class="h-100">
                <h5>Gestion <br> Facile</h5>
                <p>
                  Facile a Gerer
                  <strong>Trouver, ajouter et modifier vos stock de medicaments en un clic.</strong>
                </p>
              </a>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap h-100">
              <a href="#" class="h-100">
                <h5>Meilleurs <br> Prix </h5>
                <p>
                  Trouver les meilleurs prix pour vos medicaments
                  <strong>Rechercher et comparer les prix pour vous faire des benefices.</strong>
                </p>
              </a>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap bg-warning h-100">
              <a href="#" class="h-100">
                <h5>Utilisation<br> Facile</h5>
                <p>
                  Facile a Utiliser
                  <strong>Notre experience utilisateur est facile et intuitif pour tous.</strong>
                </p>
              </a>
            </div>
          </div>

        </div>
      </div>
    </div>

    
    

    <div class="site-section bg-secondary bg-image" style="background-image: url('${pageContext.request.contextPath}/images/bg_2.jpg');">
      <div class="container">
        <div class="row align-items-stretch">
          <div class="col-lg-6 mb-5 mb-lg-0">
            <a href="#" class="banner-1 h-100 d-flex" style="background-image: url('${pageContext.request.contextPath}/images/bg_1.jpg');">
              <div class="banner-1-inner align-self-center">
                <h2>Produits de Pharmacie</h2>
                <p>Gerer tous vos produits en quelques clics
                </p>
              </div>
            </a>
          </div>
          <div class="col-lg-6 mb-5 mb-lg-0">
            <a href="#" class="banner-1 h-100 d-flex" style="background-image: url('${pageContext.request.contextPath}/images/bg_2.jpg');">
              <div class="banner-1-inner ml-auto  align-self-center">
                <h2>Reconnus par des Experts</h2>
                <p>Notre plateforme de produits medicaux est reconnu par des experts pharmaciens presents dans toutes les pharmacies affiliees 
                </p>
              </div>
            </a>
          </div>
        </div>
      </div>
    </div>