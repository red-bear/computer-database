computer-database
=================
FAVOT Suzanne
YURCHUK Evgeny


___Pour Monsieur Loic ORTOLA:___

Les fonctions implémentés: 

Affichage des ordinateurs,
Recherche des ordinateurs,
Ajout,
Modification,
Suppréssion.

Vu que notre projet et un peu différent des autres, on a décidé d'essayer TOUT les méthodes
et technologies disponibles aujourd'hui en pratique (EJB inclus), en dépencant plus de temps.
Cela nous a permit par contre d'enrichir vraiment nos connaissances. 
A la fin on a donc une application complet et configuré. Certains fonctions n'étaient quand meme 
pas implémentés vu les difficultés qu'on a rencontré pendant la configuration de Maven.
Après avoir essayé les technos on a fait ces choix:

Choix Technologiques:
* MAVEN over .jar (Organisation du projet, simplicité de gérer des dépendences, facilité de compilation des gros projets)

* JPA 2.1 over Hibernate over JDBC (On a essayé Hibernate mais après avoir lu le livre
de Manning "Spring in Action" on a fait le choix vers le JPA 2.1 vu qu'il a devenu le de-facto standard aujourd'hui)

* Spring over EJB 3.1 (EJB 3.1 - a bcp évolué depuis 1.0/2.0 - mais besoin d'un vrai serveur d'application (Glassfish) 
et peu utilisé pour les petits applications

* Annotations over XML (Facilité de développement + lisibilité)

* @Namedqueries over dynamic queries (Performance + lisibilité + évolutivité)

* Transactions (Persistence)

Sources: "Spring in Action" par rédaction de Manning,
"Java EE 6 Platform with Glassfish 3" par Apress,
Codeforge et articles sur Internet.
