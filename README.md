# ForoHub

ForoHub es una API REST desarrollada en **Java** utilizando el framework **Spring Boot**. Este proyecto tiene como objetivo gestionar un foro donde los usuarios pueden publicar preguntas relacionadas con diferentes temas y cursos, y participar en discusiones.

## Características

ForoHub permite realizar las operaciones CRUD básicas sobre los tópicos (temas de discusión):

- **Crear un nuevo tópico**: Los usuarios pueden registrar preguntas relacionadas con un curso.
- **Listar todos los tópicos**: Obtener todas las preguntas registradas en el foro.
- **Mostrar un tópico específico**: Consultar detalles de un tópico específico usando su ID.
- **Actualizar un tópico**: Modificar la información de un tópico existente.
- **Eliminar un tópico**: Eliminar un tópico de forma permanente.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje principal de desarrollo.
- **Spring Boot 3.x**: Framework para la construcción de la API.
- **MySQL**: Base de datos relacional para almacenar la información.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **Flyway**: Para la gestión de migraciones de la base de datos.
- **Bean Validation**: Para validar datos en las solicitudes HTTP.

## Estructura del Proyecto

El proyecto está dividido en las siguientes capas:

1. **Controller**: Maneja las solicitudes HTTP.
2. **Service**: Contiene la lógica de negocio.
3. **Repository**: Interactúa con la base de datos mediante JPA.
4. **Model**: Define las entidades y sus relaciones.
5. **DTOs**: Transfiere datos entre la capa de presentación y la lógica de negocio.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de contar con lo siguiente:

- **JDK 17 o superior** instalado.
- **MySQL 8.x** instalado y configurado.
- **Maven** para gestionar dependencias.

## Instalación y Configuración

Sigue los pasos a continuación para configurar y ejecutar el proyecto en tu entorno local:

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/SFranHolmes/ForoHub.git
   cd forohub
