# ForoHub
Challenge del programa ALura Latam, creando la parte backend del ForoHub

# 📚 ForoHub API

Una API RESTful desarrollada en Java con Spring Boot que permite gestionar los tópicos de discusión en un foro. Incluye autenticación segura mediante JWT, persistencia en base de datos MySQL y pruebas con herramientas como Insomnia.

---

## 🚀 Funcionalidades

- 🔐 Autenticación y autorización con tokens JWT
- 🧾 CRUD de tópicos:
  - Crear tópico
  - Consultar listado de tópicos
  - Consultar tópico por ID
  - Actualizar tópico
  - Eliminar tópico
- 👤 Gestión de usuarios (autenticación)
- 📦 Conexión y persistencia en base de datos MySQL
- 📜 Validaciones y manejo de errores
- ☑️ Migraciones automáticas con Flyway

---

## 🛠️ Tecnologías Usadas

| Tecnología           | Versión    |
|----------------------|------------|
| Java                 | 21         |
| Spring Boot          | 3.5.3      |
| Spring Security      | 6.5.1      |
| Spring Data JPA      | 3.5.1      |
| MySQL                | 8.0        |
| Flyway               | 11.7.2     |
| JWT (Auth0 + jjwt)   | 0.11.5 / 4.4.0 |
| Maven                | ✅         |

---

## 📁 Estructura del Proyecto

src/

└── main/

└── java/

└── com/

└── ForoHub/

├── Controlador/ # Controladores REST

├── Configuracion/ # Seguridad y configuración

├── Seguridad/ # Filtro JWT y autenticación

├── Modelo/ # Entidades JPA

├── Repositorio/ # Interfaces JPA Repository

└── DTO/ # Clases para la transferencia de datos

---

## 🔐 Autenticación

Para acceder a los endpoints protegidos:

1. Enviar una solicitud POST a `/login` con el JSON:

```json
{
  "login": "usuario",
  "password": "123456"
}

--> Recibirás un token JWT como respuesta.

 --> En solicitudes posteriores, incluir en los headers: Authorization: Bearer {token}


## 📦 Requisitos Previos
Java 21+

Maven instalado

MySQL corriendo con la base de datos foro_hub_db



## 🧪 Pruebas
Se recomienda usar  Insomnia para probar los siguientes endpoints:

Método	Endpoint	Descripción
POST	/login	Autenticación de usuario
GET	/topicos	Listar tópicos
GET	/topicos/{id}	Ver detalle del tópico
POST	/topicos	Crear nuevo tópico
PUT	/topicos	Actualizar tópico
DELETE	/topicos/{id}	Eliminar tópico

## 🐘 Base de Datos
La base de datos se gestiona con migraciones Flyway. Al iniciar la aplicación, la tabla topicos se crea automáticamente. Las entidades incluyen:

Usuario: Login y contraseña

Topico: título, mensaje, fecha de creación, status, autor, curso

## ⚙️ Configuración
En application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

##🧠 Lecciones Aprendidas
Cómo proteger endpoints usando Spring Security y filtros JWT

Cómo estructurar un proyecto modular y profesional

Buenas prácticas en control de acceso y validación

Conexión de backend con bases de datos reales

Configuración de filtros personalizados

#👨‍💻 Autor
Desarrollado por Oscar como parte del reto técnico de la especialización Backend en Java.

##📄 Licencia
Este proyecto está bajo la licencia MIT. Puedes usarlo y modificarlo libremente con fines educativos y profesionales.
