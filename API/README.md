# API de tri pour Carte d'embarquement
***
##Problème :   
\
On vous remet une pile de cartes d'embarquement pour différents transports qui vous mèneront d'un point A à un point B en passant par plusieurs arrêts
 en cours de route. Toutes les cartes d'embarquement sont en désordre et vous ne savez pas où commence et où finit votre voyage. Chaque carte d'embarquement
 contient des informations sur l'affectation des sièges et le moyen de transport (numéro de vol, numéro de bus, etc.).

Écrivez une API qui vous permette de trier ce type de liste et de renvoyer une description de la manière de terminer votre voyage.

Par exemple, l'API devrait être capable de prendre un ensemble non ordonné de cartes d'embarquement, fournies dans un format défini par vous, et de produire
cette liste :

"	Prenez le train 78A de Madrid à Barcelone. Asseyez-vous à la place 45B."  
"	Prenez le bus de l'aéroport de Barcelone à l'aéroport de Gérone. Pas d'attribution de siège."   
"	De l'aéroport de Gérone, prenez le vol SK455 à destination de Stockholm. Porte 45B, siège 3A. Dépose des bagages au guichet 344."   
"	De Stockholm, prenez le vol SK22 à destination de New York JFK. Porte 22, siège 7B. Les bagages seront automatiquement transférés de votre dernière étape."  
"	Vous êtes arrivé à votre destination finale."

La liste doit être définie dans un format compatible avec le format d'entrée.   

#Concepts
***
###Cette API dispose de :

- Une classe abstraite CarteEmbarquement implémentant l'interface ICarteEmbarquement qui possède tous les attributs communs aux deux types de cartes d'embarquement, ainsi que les accesseurs et mutateurs pour chacun d'entre eux.
- Une classe CarteEmbarquementAvion qui possède des attributs propres a une carte d'embarquement d'avion comme la porte d'embarquement ou le guichet de dépot des bagages, ainsi que les accesseurs et mutateurs pour chacun d'entre eux.
- Une classe CarteEmbarquementTrain ne possèdant pas d'attributs complémentaires à la classe CarteEmbarquement. Elle a été créé pour marquer la différence du moyen de transport.
- Une interface ICarteEmbarquement qui va permettre l'appel d'une seule et même fonction getInfos() afin de pouvoir récupérer les informations liés a la carte d'embarquement, et ce quelque soit son type.
- Une classe Voyage composée d'une liste non triée de carte d'embarquement, et une liste (vide à l'initialisation) de carte d'embarquement "triée" . Cette classe va trier les cartes d'embarquement afin de générer un parcours pour l'utilisateur qui sera enregistré dans la liste "listeTriee".
- Une classe TestCarteEmbarquementAvion pour tester la construction de cette carte d'embarquement.
- Une classe TestCarteEmbarquementTrain pour tester la construction de cette carte d'embarquement.
- Une classe TestVoyage pour tester la création d'une liste de cartes d'embarquement, la création d'un voyage ainsi que le tri des cartes d'embarquement associé à celui-ci.

#Environnement nécessaire
***
Afin de pouvoir utiliser cette API comme bon vous semble vous devez :
- Installer JAVA (ici, la version du SDK importe peu))
- Disposer d'un IDE avec un compilateur JAVA. Vous pouvez trouver ici un IDE gratuit qui possède les prérequis pour faire fonctionner cette API : https://www.eclipse.org/downloads/

Voici la marche a suivre afin d'utiliser cette API :
- Ouvez le dossier API comme un "Nouveau projet" dans votre IDE
- Si cela est nécessaire, configurez votre "Run" afin de pouvoir lancer l'API

#Fonctions et procédures 
***
(ici, les accesseurs et les mutateurs ne seront pas détaillés)\
Voyage :
- getTripDeparture():void -> parcours la liste non triée et, si elle existe, affecte la carte d'embarquement possédant une ville de départ différente de toutes les villes d'arrivés dans la listeTriée. C'est donc la première carte d'embarquement du voyage.
- setNextCard():void -> parcours la liste non triée et compare la ville d'arrivée de la derniere carte renseignée dans "listeTriee" avec la ville de départ de chaque carte d'embarquement contenu dans listeCarteNonTrie. Une fois trouvée, elle est enregistré dans la liste listeTrie et retirée de la listeCarteNonTrie.
- setTravel():void -> appelle la méthode getTripDeparture(), et tant que la listeCarteNonTrie n'est pas vide(donc tant qu'il reste des cartes à trier) va appeler la méthode setNextCard() afin de trouver la prochaine carte d'embarquement qui correspond.
- descriptionTravel():String -> Retourne une chaine de caractère contenant la concaténation des données du voyage, récupérés par la fonction getInfos() et ce pour chaque carte contenue dans la listeTriee.

CarteEmbarquementAvion :
- getInfos():String -> Retourne une chaine de caractère contenant la concaténation des différentes informations de la carte d'embarquement. Dans les cas où le guichetBagages et/ou le numeroSiege n'est pas renseigné, la chaine de caractère concaténé sera différente.

CarteEmbarquementTrain :
- getInfos():String -> Retourne une chaine de caractère contenant la concaténation des différentes informations de la carte d'embarquement. Dans le cas où le numeroSiege n'est pas renseigné, la chaine de caractère concaténé sera différente.

#Credits
***
L'API a été réalisé en intégralité par thxmr, dont voici le GitHub : https://github.com/thxmr