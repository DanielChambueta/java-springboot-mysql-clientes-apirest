# Proyecto de API REST en Java con Spring Boot y Maven

## Descripción

Este proyecto es una API REST desarrollada en Java utilizando Spring Boot y Maven. La API maneja una entidad llamada "Cliente" y está estructurada en tres capas principales: Controller, Model y Service. La entidad Cliente contiene los siguientes campos: Nombre, Apellido, Correo y Fecha de Registro.

## Requisitos

- Java 11 o superior
- Maven 3.6.3 o superior
- Spring Boot 2.5.4 o superior

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── danielchambueta/
│   │           └── cliente/
│   │               └── clientesapirest/
│   │                   ├── controller/
│   │                   │   └── ClienteController.java
│   │                   ├── model/
│   │                   │   └── dao
│   │                   │       └── ClienteDao.java
│   │                   │   └── dto
│   │                   │       └── ClienteDto.java
│   │                   │   └── entity
│   │                   │       └── Cliente.java
│   │                   │   └── payload
│   │                   │       └── MensajeResponse.java
│   │                   ├── service/
│   │                   │   └── implement
│   │                   │       └── ClienteImplementationService.java
│   │                   │   └── ClienteService.java
│   │                   └── ClientesApirestApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── danielchambueta/
                └── cliente/
                    └── clientesapirest/
                        └── ClientesApirestApplicationTests.java
```

## Instalación y Ejecución

1. Clona el repositorio en tu máquina local:

```bash
git clone https://github.com/tuusuario/tuproyecto.git
```

2. Navega al directorio del proyecto:

```bash
cd tuproyecto
```

3. Compila y ejecuta la aplicación usando Maven:

```bash
mvn spring-boot:run
```

## Endpoints de la API

La API expone los siguientes endpoints para la gestión de clientes:

- **GET /clientes**: Obtiene la lista de todos los clientes.
- **GET /clientes/{id}**: Obtiene un cliente por su ID.
- **POST /clientes**: Crea un nuevo cliente.
- **PUT /clientes/{id}**: Actualiza los datos de un cliente existente.
- **DELETE /clientes/{id}**: Elimina un cliente por su ID.

## Pruebas de Uso

Esta API usa Swagger para documentar y probar los endpoints. Puedes acceder a la documentación de la API en la siguiente URL:
http://localhost:8092/swagger-ui/index.html#/
