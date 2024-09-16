## Descripción

El backend del proyecto `app-name`, es responsable de manejar todas las operaciones del lado del servidor. Esta sección da un resumen de la arquitectura, tecnologias usadas y configuraciones iniciales pertinentes para inicializar el proyecto

## Diagrama de clases

## Prerrequisitos

- Java 21 o superior
- Maven
- IDE (recomendado IntelliJ)
- Postgrest

## Tecnologias usadas

- **Spring Boot 3**: Poderoso framework para construir aplicaciones basadas en java 
- **Spring Data JPA**: Simplifica el acceso a los datos y su persistencia mediante la Java Persistence API
- **Spring Validation**: Permite la validacion de objetos basada en anotaciones
- **Spring mail**: Simplifica el envío de correos electrónicos
- **Lombok**: Reduce la cantidad de código repetitivo
- **Mapstruct**: Permite transformar objetos de una clase a otra
- **OpenApi y Swagger UI**: Genera la documentación de los endpoints de la API

## Instalación y Configuración

1. Clona el repositorio
   
```bash
   git clone https://github.com/No-Country-simulation/s17-08-m-java-react.git
```

2. Abre la carpeta **server** con tu editor preferido

3. Configura las variables de entorno del perfil dev en el archivo **src/main/resources/application-dev.properties**
   
- **DB_URL_DEV**: Url de la base de datos local
- **DB_USER_DEV**: Usuario de la base de datos local
- **DB_PASSWORD_DEV**: Contraseña de la base de datos local
  
4. Ejecuta la aplicación
  
5. Accede a la documentacion de la API usando Swagger UI:
   
- Abre el navegador y ve a `http://localhost:9090/api/v1/swagger-ui/index.html`
