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

