
<!DOCTYPE html>
<html>
<head>
	  <meta charset="utf-8">
	  <title>Ma Pharma</title>
	  <base href="/">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/icomoon/style.css">
	  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo_pur.png">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
	
	
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aos.css">
	
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.min.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css">
	  
	  <style type="text/css">
	  	.small-select + .select2-container {
		    width: 500px !important;
		}
	  	
	  </style>
	  

</head>
<body>

<div class="site-wrap">


    <div class="site-navbar py-2">

      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>
        </div>
      </div>

      <div class="container">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
                <a href="${pageContext.request.contextPath}" class="js-logo-clone">
                    <img src="${pageContext.request.contextPath}/images/logo_pur.png" alt="Logo MaPharma" style="height: 70px; margin-right: 8px;">
                    MaPharma
                </a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li><a href="${pageContext.request.contextPath}">Home</a></li>
                
                
                <li><a href="${pageContext.request.contextPath}/medicaments">Medicaments</a></li>
                <li><a href="${pageContext.request.contextPath}/ventes">Ventes</a></li>
                <li><a href="${pageContext.request.contextPath}/alertes">Alertes</a></li>
                
                
                
                <%
				    if (session.getAttribute("email") != null) {
				%>
				    <li>
	                   <form action="${pageContext.request.contextPath}/logout" method="POST">
	                         
	                       <button type="submit" class="btn btn-danger" onclick="confirm('Etes vous sure de vouloir vous deconnecter?')">
	                                Déconnecter
	                       </button>
	                   </form>
	               </li>
				<%
				    } else {
				%>
				    <li><a href="${pageContext.request.contextPath}/login"><button class="btn btn-primary">Connexion</button></a></li>
				<%
				    }
				%>
                
              </ul>
            </nav>
          </div>
          <div class="icons">
            
            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
                class="icon-menu"></span></a>
          </div>
        </div>
      </div>
    </div>

    <%
	    String successMessage = (String) request.getAttribute("successMessage");
	    String errorMessage = (String) request.getAttribute("errorMessage");
	    
	    if (successMessage != null) {
	%>
	    <div id="alert" class="alert alert-success"><%= successMessage %></div>
	<%
	    }
	
	    if (errorMessage != null) {
	%>
	    <div id="alert" class="alert alert-danger"><%= errorMessage %></div>
	<%
	    }
	%>
    
