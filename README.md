[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/bFlAvWr6)


# 2024S - Advanced Webtechnologies Projekt

## Gruppenmitglieder

| **Name**           | **Personenkennzeichen** | **E-Mail Adresse**         |
|--------------------|-------------------------|----------------------------|
| Julian Altenberger | se23m031                | se23m031@technikum-wien.at |
| Stefan Bittgen     | se23m003                | se23m003@technikum-wien.at |
| Thomas Brenninger  | se23m053                | se23m053@technikum-wien.at |  
| Maximilian Wödl    | se23m029                | se23m029@technikum-wien.at |

## Eingesetzte Technologien

| **Modul** | **Technologien**                                                                                                  |
|-----------|-------------------------------------------------------------------------------------------------------------------|
| Frontend  | [Vue.js with Ionic](https://ionicframework.com/)                                                                  |
| Backend   | [Java Spring Boot](https://spring.io/)                                                                            |
| Datenbank | [MySQL](https://www.mysql.com/)                                                                                   |

## Development Setup

Das Frontend unterstützt Hot-Module-Reload (HMR).
Um mit der Entwicklung zu starten, müssen wir zuerst ein lauffähiges *.jar File erzeugen. Dazu wechsle bitte in das backend Verzeichnis und führe folgenden Befehl aus:

```
mvn install
```

Danach starte die Docker Container mit:

```shell
docker compose watch or docker-compose up
```

Die Module sind danach am `localhost` unter folgenden Adressen erreichbar:

| **Modul** | **Adresse**            |
|-----------|------------------------|
| Frontend  | http://localhost:8100  |
| Backend   | http://localhost:8080  |
| Datenbank | mysql://localhost:3306 |
