# Projet Pharmacie - Gestion de Pharmacie MAPHARMA (JEE)

## Auteur
 - KOUCHANOU JUAN Prince
 - BARA SAKINATOU

## Technologies utilisées
- Java 21  
- Apache Tomcat 11.0.4  
- MySQL  
- Jakarta Persistence API 3.2.0
- EclipseLink 4.0

---

## Installation du projet

### Cloner le Repository
```bash
git clone https://github.com/ton-username/nom-du-projet.git
cd nom-du-projet
```

### Configurer la base de données MySQL
 - Creer une Base de donnee :

 ```
myjeedb
```
 - Modifier les accès à la DB dans :


```
 src/main/java/META-INF/persistence.xml
```

### Accéder à l’application
Lancer le server et Ouvrir dans le navigateur :
```
http://localhost:8080/pharma/
```

### Listes des Routes
Utilisateur connecter
 - /medicaments/
 - /medicaments/add
 - /medicaments/edit
 - /medicaments/show
 - /ventes/
 - /ventes/add
 - /alertes/

Utilisateur non connecter
 - /register/
 - /login/
 - /



## Architecture du Projet

```
mapharma
├─ .classpath
├─ .project
├─ .settings
│  ├─ .jsdtscope
│  ├─ org.eclipse.jdt.core.prefs
│  ├─ org.eclipse.wst.common.component
│  ├─ org.eclipse.wst.common.project.facet.core.xml
│  ├─ org.eclipse.wst.jsdt.ui.superType.container
│  └─ org.eclipse.wst.jsdt.ui.superType.name
├─ 3400930258699.jpg
├─ build
│  └─ classes
│     ├─ com
│     │  └─ prince
│     │     ├─ Alerte.class
│     │     ├─ AlerteServlet.class
│     │     ├─ Drug.class
│     │     ├─ DrugRepository.class
│     │     ├─ HomeServlet.class
│     │     ├─ JPAListerner.class
│     │     ├─ LoginServlet.class
│     │     ├─ LogoutServlet.class
│     │     ├─ MedicamentServlet.class
│     │     ├─ PasswordTool.class
│     │     ├─ RegisterServlet.class
│     │     ├─ User.class
│     │     ├─ UserRepository.class
│     │     ├─ Vente.class
│     │     ├─ VenteRepository.class
│     │     └─ VenteServlet.class
│     └─ META-INF
│        └─ persistence.xml
├─ doliprane-500mg-.jpg
├─ efferalgan-1000mg.jpg
├─ products_1.png
├─ product_01.png
├─ product_02.png
├─ product_03.png
├─ product_04.png
├─ product_05.png
├─ product_06.png
├─ product_07_large.png
├─ src
│  └─ main
│     ├─ java
│     │  ├─ com
│     │  │  └─ prince
│     │  │     ├─ Alerte.java
│     │  │     ├─ AlerteServlet.java
│     │  │     ├─ Drug.java
│     │  │     ├─ DrugRepository.java
│     │  │     ├─ HomeServlet.java
│     │  │     ├─ JPAListerner.java
│     │  │     ├─ LoginServlet.java
│     │  │     ├─ LogoutServlet.java
│     │  │     ├─ MedicamentServlet.java
│     │  │     ├─ PasswordTool.java
│     │  │     ├─ RegisterServlet.java
│     │  │     ├─ User.java
│     │  │     ├─ UserRepository.java
│     │  │     ├─ Vente.java
│     │  │     ├─ VenteRepository.java
│     │  │     └─ VenteServlet.java
│     │  └─ META-INF
│     │     └─ persistence.xml
│     └─ webapp
│        ├─ alertes.jsp
│        ├─ css
│        │  ├─ aos.css
│        │  ├─ bootstrap
│        │  │  ├─ bootstrap-grid.css
│        │  │  ├─ bootstrap-reboot.css
│        │  │  └─ bootstrap.css
│        │  ├─ bootstrap-select.min.css
│        │  ├─ bootstrap.min.css
│        │  ├─ bootstrap.min.css.map
│        │  ├─ jquery-ui.css
│        │  ├─ magnific-popup.css
│        │  ├─ owl.carousel.min.css
│        │  ├─ owl.theme.default.min.css
│        │  ├─ select2.css
│        │  ├─ select2.min.css
│        │  └─ style.css
│        ├─ fonts
│        │  └─ icomoon
│        │     ├─ demo-files
│        │     │  ├─ demo.css
│        │     │  └─ demo.js
│        │     ├─ demo.html
│        │     ├─ fonts
│        │     │  ├─ icomoon.eot
│        │     │  ├─ icomoon.svg
│        │     │  ├─ icomoon.ttf
│        │     │  └─ icomoon.woff
│        │     ├─ Read Me.txt
│        │     ├─ selection.json
│        │     └─ style.css
│        ├─ footer.jsp
│        ├─ header.jsp
│        ├─ images
│        │  ├─ .DS_Store
│        │  ├─ bg_1.jpg
│        │  ├─ bg_2.jpg
│        │  ├─ doctor.jpg
│        │  ├─ hero_1.jpg
│        │  ├─ logo_pur.png
│        │  ├─ person_1.jpg
│        │  ├─ person_2.jpg
│        │  ├─ person_3.jpg
│        │  ├─ person_4.jpg
│        │  ├─ person_5.jpg
│        │  ├─ products_1.png
│        │  ├─ product_01.png
│        │  ├─ product_02.png
│        │  ├─ product_03.png
│        │  ├─ product_04.png
│        │  ├─ product_05.png
│        │  ├─ product_06.png
│        │  ├─ product_07_large.png
│        │  ├─ shoe.png
│        │  ├─ wave.svg
│        │  └─ women.jpg
│        ├─ index.jsp
│        ├─ js
│        │  ├─ aos.js
│        │  ├─ bootstrap-select.min.js
│        │  ├─ bootstrap.min.js
│        │  ├─ jquery-3.3.1.min.js
│        │  ├─ jquery-ui.js
│        │  ├─ jquery.magnific-popup.min.js
│        │  ├─ main.js
│        │  ├─ owl.carousel.min.js
│        │  ├─ popper.min.js
│        │  ├─ select2.js
│        │  ├─ select2.min.js
│        │  └─ slick.min.js
│        ├─ login.jsp
│        ├─ main.jsp
│        ├─ medicamentAdd.jsp
│        ├─ medicamentEdit.jsp
│        ├─ medicaments.jsp
│        ├─ medicamentShow.jsp
│        ├─ META-INF
│        │  └─ MANIFEST.MF
│        ├─ register.jsp
│        ├─ venteAdd.jsp
│        ├─ ventes.jsp
│        ├─ WEB-INF
│        │  ├─ lib
│        │  │  ├─ eclipselink.jar
│        │  │  ├─ jakarta.persistence-api-3.2.0.jar
│        │  │  ├─ jbcrypt-0.4.jar
│        │  │  └─ mysql-connector-j-9.4.0.jar
│        │  └─ web.xml
│        └─ welcome.jsp
├─ thumb-spasfon-30-comprimes-enrobes-i15.jpg
└─ Trimbutine-100-mg-Mylan-conseil-boite-de-20-comprims-3.jpg

```
