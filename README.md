#Simulation d'un parc d'attraction
##Présentation
Projet java de LP SIL DA2I par **Karine Guiducci**, **Vincent Piot** et **François Waxin**.

Un **parc** se compose de trois grandes entités : les **structures**, les **visiteurs** et les **employés**.
Il a une *taille* (nombre de structures), une *capacité* de visiteur et des *horaires*.

Tout sera géré par des threads.

Au niveau des **structures** il y a deux catégories, les payantes (restaurants, boutiques ...) et les non payantes (les attractions).

Pour les attractions il y a : 
* plusieurs *catégories* (sensation forte, aquatique ...) ; 
* *probabilité* de panne et de problème technique ; 
* *restriction* d'âge ; 
* durée d'*attente* et de *passage* ; 
* nombre de *place*. 

Pour les boutiques : 
* *prix* ; 
* nombre de *place* ; 
* *temps* de prestation. 

Concernant les employés, il y en a trois types : 
* les *vendeurs/animateurs*, qui s’occupent d'une structure ; 
* les *agents d'entretien*, qui nettoie le parc et les structures ; 
* les *réparateurs*, qui réparent les attractions. 

Les vendeurs/animateurs sont lié à la structure, les agents d'entretien tourne dans le parc et nettoie et enfin les réparateurs doivent inspecter chaque attraction. Pendant qu'une attraction est inspecté, elle n'est pas utilisable et une inspection à un temps définie.

Enfin les visiteurs :
* tranche d'*âge* (enfant ou adulte) ; 
* *porte-monnaie* (sauf pour les enfants) ; 
* *duré de vie* (nombre d'interaction max généré aléatoirement).
