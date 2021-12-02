# API de tri pour Carte d'embarquement
***
##Cette API a été crée par Thomas Roy dans le but de répondre à un problème que voici ci-dessous :   
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

Dans cette API, il y a une classe qui forme la Carte d'embarquement, et une classe qui forme le voyage en lui même.

###CarteEmbarquement

#ENGLISH :
##This API has been created by Thomas Roy in order to answer a problem that is listed below :
\
You will be given a stack of boarding passes for different transports that will take you from point A to point B through several stops
along the way. All the boarding passes are in disarray and you don't know where your journey begins and ends. Each boarding pass
contains seat assignment and transportation information (flight number, bus number, etc.).

Write an API that allows you to sort this type of list and return a description of how to end your trip.

For example, the API should be able to take an unordered set of boarding passes, provided in a format defined by you, and produce
this list:

"Take train 78A from Madrid to Barcelona. Sit in seat 45B."\
"Take the bus from Barcelona airport to Girona airport. No seat assignments."\
"From Girona Airport, take flight SK455 to Stockholm. Gate 45B, seat 3A. Drop off your luggage at counter 344."\
"From Stockholm, take flight SK22 to New York JFK. Gate 22, seat 7B. Luggage will be automatically transferred from your last stop."\
"You have arrived at your final destination."

The list must be defined in a format compatible with the input format.