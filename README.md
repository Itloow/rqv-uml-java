# Projet RQV – Gestion des Rapports Quotidiens de Vol

Projet réalisé dans le cadre de l’UE MI0C502T – Développement logiciel : Conception  
Licence 3 MIASHS – Parcours Informatique  
Université Toulouse – Jean Jaurès  
Année universitaire 2025–2026

## Membres du groupe
- Olti MJEKU  
- Karim SAÏD  
- Josue Hyacinth WABOE NAMSENA  

Enseignant : Sophie Ebersold

---

## Objectif du projet

Ce projet vise à concevoir et développer une application permettant la gestion des Rapports Quotidiens de Vol (RQV).  
L’application doit intégrer :

- la création, modification et suppression de déclarations de vol,
- l’identification des déclarations nouvelles, modifiées ou résolues,
- la gestion des objets trouvés,
- la notification automatique des victimes concernées,
- la génération des RQV par les agents de police.

---

## Arborescence du projet

```
Projet_RQV/
│
├── doc/                        Rapport final et documents livrables
│
├── ressources/                 Images, exemples, données annexes
│
├── src/                        Code source Java
│   ├── controller/             Contrôleurs liés aux cas d'utilisation
│   ├── model/                  Classes métier (Déclaration, RQV...)
│   ├── service/                Services et logique applicative
│   └── util/                   Classes utilitaires
│
├── tests/                      Tests unitaires Java (JUnit)
│
└── uml/                        Diagrammes UML
    ├── usecases/               Cas d'utilisation + scénarios textuels
    ├── sequences/              Diagrammes de séquence
    ├── classes/                Diagramme de classes
    ├── activites/              Diagrammes d'activité
    └── etats/                  Diagrammes d'états
```

---

## Technologies utilisées
- Java 17+  
- JUnit 5  
- plantUML

---

## Tests
Les tests se trouvent dans :  
```
tests/
```

---

## Rapport
Le rapport Word/PDF se trouve dans :  
```
doc/Rapport.docx
doc/Rapport.pdf
```


