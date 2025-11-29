    
<footer class="site-footer">
        <div class="container">
          <div class="row">
            <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
  
              <div class="block-7">
                <h3 class="footer-heading mb-4">About Us</h3>
                <p>KOUCHANOU Juan Prince C.D.</p>
                <p>Bara Sakinatou</p>
                <p>Projet JEE UVBF 2025</p>
                
              </div>
  
            </div>
            <div class="col-lg-3 mx-auto mb-5 mb-lg-0">
              <h3 class="footer-heading mb-4">Liens Rapides</h3>
              <ul class="list-unstyled">
              </ul>
            </div>
  
            <div class="col-md-6 col-lg-3">
              <div class="block-5 mb-5">
                <h3 class="footer-heading mb-4">Fiches de Contacts</h3>
                <ul class="list-unstyled">
                  <li class="address">Bonheur ville, Ouagadougou, Burkina Faso</li>
                  <li class="phone"><a href="tel://23923929210">+226 50505050</a></li>
                  <li class="email">mapharma@gmail.com</li>
                </ul>
              </div>
  
  
            </div>
          </div>
        </div>
      </footer>
    </div>
  
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/aos.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/select2.js"></script>
    <script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
  
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
  
    <script>
        // Attendre que le DOM soit chargé
        document.addEventListener('DOMContentLoaded', function () {
            const alertBox = document.getElementById('alert');
            if (alertBox) {
                // Masquer l'alerte après 5 secondes
                setTimeout(() => {
                    alertBox.style.transition = "opacity 0.5s ease";
                    alertBox.style.opacity = 0;
                    setTimeout(() => alertBox.remove(), 500); // Supprimer du DOM après fondu
                }, 5000);
            }
        });
    </script>
    <script>
		$(document).ready(function() {
		    $('#medoc').select2({
		        placeholder: "Rechercher un médicament",
		        allowClear: true
		    });
		});
	</script>
  </body>
  
  </html>

    