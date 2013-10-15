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

Vu que notre projet est différent des autres, on a décidé d'essayer en pratique toutes les méthodes
et technologies disponibles aujourd'hui sur le marché (EJB inclus), en dépensant plus de temps.
Cela nous a permit, par contre, d'enrichir vraiment nos connaissances. 
A la fin on a donc une application complète et configuré. Certaines fonctions n'étaient quand meme 
pas implémentés vu des difficultés qu'on a rencontré pendant la configuration de Maven.
Après avoir essayé les technos on a fait ces choix:

Choix Technologiques:
* MAVEN over .jar (Organisation du projet, simplicité de gérer des dépendences, facilité de compilation des gros projets)
>>Bien, reflechissez aussi a pourquoi Maven et pas Ant ou Gradle.

* JPA 2.1 over Hibernate over JDBC (On a essayé Hibernate mais après avoir lu le livre
de Manning "Spring in Action" on a fait le choix vers le JPA 2.1 vu qu'il a devenu le de-facto standard aujourd'hui)
>>Attention: Vous utilisez EclipseLink, et non JPA! JPA c'est l'API que vous utilisez pour discuter avec EclipseLink, votre ORM. C'est votre choix, mais sachez que vous auriez tout a fait pu aussi utiliser JPA 2.1 avec Hibernate. On ne parle pas de standard, mais Eclipselink est l'implementation recommandee par Sun (maintenant Oracle) de l'API JPA.

* Spring over EJB 3.1 (EJB 3.1 - a bcp évolué depuis 1.0/2.0 - mais besoin d'un vrai serveur d'application (Glassfish) 
et peu utilisé pour les petits applications
>> Faux, les EJB sont beaucoup utilises, et surtout depuis la version 3. Avant, JEE etait un conteneur lourd, mais il s'est grandement allege et aujourd'hui ce n'est plus qu'une question de choix technos! Il n'y a pas que Glassfish, il y a aussi JBoss, WebSphere etc...

* Annotations over XML (Facilité de développement + lisibilité)

* @Namedqueries over dynamic queries (Performance + lisibilité + évolutivité)
>> Lisibilite OK. Pourquoi performance? Une namedquery sera tout aussi performante qu'une dynamic query. Par contre, une NamedQuery n'est PAS a choisir pour une bonne evolutivite! Pourquoi? Parce que vous allez declarer vos namedqueries dans la classe Domain, et non dans le DAO. Ainsi vous melangez les couches et c'est une mauvaise pratique. Les namedqueries ont ete implementees dans les toutes petites applications, mais sont tres rarement presentes dans des vraies applis. La dessus je ne suis donc pas d'accord avec votre choix

* Transactions (Persistence)
>> Vous avez donc utilise Spring pour gerer vos transactions?

Sources: "Spring in Action" par rédaction de Manning,
"Java EE 6 Platform with Glassfish 3" par Apress,
Codeforge et articles sur Internet.

-------------------------------------------------------


------------------------------------------------------------------
CORRECTION+CODE REVIEW:
------------------------------------------------------------------

-------------------------
Expérience utilisateur:
-------------------------
J'installe, je run, erreur 500: Access Denied.
Vous n'avez pas ajoute l'utilisateur comme je voulais (admin admin pour mysql), du coup je dois changer vos XML. Si je suis un client, je ne suis pas content, attention la prochaine fois.

Apres ca, la page s'affiche correctement. Bon ok, pas de pagination, dommage.



L'ordre de départ aurait pu être le Computer Name, dommage!

La recherche? Attention, je ne souhaite pas avoir de case sensitive, et quand j'ecris apple, j'aimerais qu'il me renvoit Apple Lisaq, Apple II, Apple III plus etc... Alors que la j'ai 0 resultats. D'un point de vue experience utilisateur c'est decevant (et pas du tout pratique, vous rendez le moteur de recherche useless).

Affichage des dates OK, bien vu pour le remettre au bon format.

Ajout:
Decu! Aucun controle effectue. Je ne sais pas si j'ai ajoute mon ordi ou pas, et seul le compteur va pouvoir m'aider!
Gros bug: J'ajoute un ordi sans dates, il s'ajoute. J'ajoute un ordi avec une date au mauvais format, il s'ajoute aussi, alors qu'il devrait me sortir une exception. Maintenant j'ai deux ordinateurs avec des dates vides, imaginons que je les ai appeles de la meme maniere (azerty).
J'ajoute un 3e ordinateur, avec des dates valides, il ne va pas me l'ajouter et il va changer les dates des ordinateurs precedents! AOUTCH!

Edit: Ok

Delete: Ok, mais j'aurais aime avoir une confirmation "etes vous sur de vouloir supprimer". Si c'est une erreur de manip, mon ordi est perdu a jamais.

-------------------------
Le code:
-------------------------
-Commentaires: Decu, aucun commentaire, je suis cense tout comprendre... Attention!

-Protection des jsp: bien

-Controllers: Les variables qui ne sont pas explicites ("type" dans votre model par exemple) meriteraient d'etre dans une enum! Si vous reprenez votre code dans 6 mois, vous ne comprendrez pas ce que c'est!! 
Alternative: des bons commentaires, mais pas tres maintenable!
Vos Mappings sont discutables: Vous pourriez utiliser /addComputer avec un RequestMethod.GET et un autre RequestMethod.POST, ca vous evite d'utiliser deux URL pour la meme action.

AddComputerPost: Aoutch! Vous avez voulu fusionner la notion d'update et de add. Ca ne me derange pas, mais vous vous etes trompes de condition d'unicite! Vous avez choisi l'unicite comme etant le nom, ce qui est totalement faux. il y a une colonne ID qui existe pour ca, et c'est la dessus que vous devriez effectuer vos tests!!!
Quand vous faites un update, vous aurez un id non null dans le resultat, et vous recupererez l'ancien ordinateur. Sinon, vous ajoutez un nouveau!
C'est l'origine de votre gros bug.

-Services: RAS si ce n'est votre erreur updateComputer qui contient un String...
Bonne pratique: vous utilisez updateComputer(Computer), et vous faites vos tests a l'interieur, en recuperant un oldComputer, effectuant vos modifs dessus, et en le sauvant.

-Dao: Voila, maintenant vous avez la moitie des methodes dans votre couche DAO, et l'autre moitie dans le modele directement... Pas vraiment "evolutif"
-Domain: Idem

-JSP: C'est bien. le code est clair. Meme commentaires qu'au dessus, pour votre variable "type" peu explicite. J'ai compris en regardant la JSP, mais avant je ne savais pas a quoi ca servait. Ici, on preferera un boolean isUpdate, plus explicite pour une variable a deux etats.
Votre jsp addComputerFail n'a jamais pu etre visualisee pendant mes tests. Une erreur d'implementation?	A mon avis, c'est votre BindingResult qui ne connait pas la strategie a adopter. Il faut lui dire ce qu'est une erreur pour qu'il comprenne qu'une insertion etait mauvaise.

-------------------------
Bilan: 
-------------------------
Je suis content de vos choix technos, et que vous vous soyiez mouilles un petit peu pour vous frotter a d'autres choses.
Vous avez vu que commencer un projet Maven n'est pas evident, et c'est sur que ca prend du temps a mettre en place, meme si ce n'est que du bonheur ensuite.
Cote experience utilisateur, je suis vraiment decu par contre. Quand on implemente quelque chose, on le fait jusqu'au bout et vous auriez du reflechir un peu plus a l'utilisateur final. Coder c'est une chose, mais n'oubliez pas que votre client ne voit pas comment c'est fait a l'interieur. Ce qu'il compte c'est qu'il soit satisfait en navigant dans votre interface!

C'est donc un bon projet, mais je reste sur ma faim. Cherchez a aller plus loin avec Spring MVC pour la pagination, le controle de formulaire etc... C'est la qu'on realise a quel point il est sympa a utiliser pour une webapp. Attention a vos choix et surtout leurs justifications: NamedQueries, JPA etc... Ne confondez pas les API (Ensemble d'interfaces, non implementees!) et une implementation. Ex: Hibernate, EclipseLink comme implementation de JPA 2.1
Bon courage pour la suite, et quand meme bravo pour votre implication dans ce projet.

