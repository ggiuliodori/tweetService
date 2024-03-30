# Tweet Service

El Servicio de Tweets es una aplicación basada en Spring Boot que proporciona funcionalidad para publicar y obtener tweets. Permite a los usuarios crear nuevos tweets y obtener los tweets más recientes de una lista de usuarios.

Funcionalidades

Publicar Tweet: Los usuarios pueden enviar solicitudes POST para crear nuevos tweets. Cada tweet está asociado a un usuario y contiene información como el contenido del tweet y la marca de tiempo.
Obtener Tweets más Recientes: Los usuarios pueden enviar solicitudes POST para obtener los tweets más recientes de una lista de usuarios especificada. El servicio devuelve una lista de tweets ordenados por marca de tiempo, comenzando con los más recientes.

## Requisitos Previos

Asegúrate de tener instalado Java 17 en tu sistema. Puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

## Configuración

Antes de ejecutar el servicio, asegúrate de configurar las propiedades necesarias en el archivo `application.properties`

spring.data.mongodb.host=mongo-host
spring.data.mongodb.port=mongo-port
spring.data.mongodb.username=user
spring.data.mongodb.password=pass
spring.data.mongodb.database=database-name
spring.data.mongodb.authentication-database=admin

## Crear imagen docker

```
docker build -t tweet_service:latest .
```

## Ejecución

```dtd
./gradlew bootRun
```
