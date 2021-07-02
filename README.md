# Currency Exchange Rates

Projet pour le cours de master 2 webservices / micro services

Ce micro-service est utilisé par [Change Opération](https://github.com/ErnestBidouille/Change-operations) mais peut être lancé indépendamment.

Il necessite docker ainsi que docker-compose pour être utilisé dans les meilleures conditions.

## Installation

Cloner le repo : 

```bash
git clone https://github.com/ErnestBidouille/Currency-exchange-rates
```

Utilisez cette commande pour packager le micro-service : 

Windows :

```cmd
mvnw package -DskipTests
```

Linux :

```bash
./mvnw package -DskipTests
```

## Lancement

```bash
docker-compose up -d
```

Si erreur au lancement : relancer la commande, l'initialisation de mysql est parfois trop longue pour que les micro-services puissent se connecter dessus directement.

