#BlueBank
BlueBank es un banco tradicional que se encarga de guardar el dinero de sus ahorradores, ofrece dos tipos de cuenta;
ahorros para personas naturales y corrientes para empresas.

##Etructura Proyecto
├── bluebank
├── backend
├── src // Carpeta proyecto springboot
├── .gitignore
├── mvnw
├── mvnw.cmd
.
└── pom.xml
├── frontend
├── src // Carpeta proyecto angular
├── frontend
.
└── README.md
├── resources
├── database //Script y modelo relacional    
.
└── README.md // Este archivo

## Backend

El backend está realizado con **Spring Boot** y **Maven** para el manejar los paquetes.

## Frontend

El frontend está realizado con **Angular**

## Instalación de paquetes/dependencias/librerías

Para instalar los recursos necesarios para la compilación del proyecto se deben seguir los siguientes pasos.

- Backend
    1. Instalar Maven descargando los binarios desde la página de [Maven](https://maven.apache.org/download.cgi)
    2. Agregar la carpeta donde extrajo maven al path del sistema.
    3. Ejecutar el comando `mvn clean install` en la carpeta **backend** del proyecto para instalar las dependencias
       necesarias de Maven.
    4. Para compilar proyecto, en la terminal en la carpeta **backend** correr el comando `mvn spring-boot:run`

- Frontend
    1. Descargar e instalar git desde su [página](https://git-scm.com/downloads)
    2. Descargar e instalar node y npm desde su [página](https://nodejs.org/es/) (Usar la versión LTS)
    3. Instalar angular ejecutanto el siguiente comando `npm i -g @angular/cli` desde el bash de git
    4. Ejecutar en cada carpeta de front `frontend/src/main/angular` de cada proyecto el comando `npm i` 