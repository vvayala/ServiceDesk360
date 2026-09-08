# ServiceDesk 360 
 
## Descripción 
Caso modelo de una aplicación web para gestionar solicitudes de soporte técnico. 
 
## Tecnologías de la semana 1  
- Java 11 o superior  
- JSP y Servlets  
- Apache Tomcat 9  
- Apache NetBeans  
- Maven  

## Tecnologías de la semana 2  
- Formularios JSP con validaciones  
- Manejo de sesiones con `HttpSession`  
- Control de flujo en login/logout  
- Cookies para recordar usuario (`ultimoUsuario`)  
- Pruebas de autenticación y persistencia de sesión  

## Tecnologías de la semana 3  
- Refactorización de servlets con servicios (`ServicioRegistro`, `Autenticador`)  
- Modelo POO con clases de dominio (`Usuario`, `Solicitante`, `Tecnico`, `TicketSoporte`)  
- Principios SOLID aplicados en diseño e implementación  
- Prueba de dominio (`PruebaModelo.java`)  
- Diagramas UML (clases, entidades y responsabilidades)  

## Tecnologías de la semana 4  
- Controladores adicionales para tickets (`TicketListadoServlet`, `TicketNuevoServlet`)  
- Integración de servicios en `ServletContextListener` (`ServicioTickets`)  
- JSP con JSTL (`<c:forEach>`, `<c:if>`, `<c:out>`) para listado y formularios  
- Validaciones de negocio en `ServicioTickets` (título, descripción, prioridad)  
- Patrón PRG (Post/Redirect/Get) aplicado en creación de tickets

- 
- ## Tecnologías de la semana 6  
- MySQL Server 8.0 o superior  
- MySQL Workbench para modelado y pruebas  
- JDBC con MySQL Connector/J administrado por Maven  
- Clase de conexión reutilizable (`ConexionBD`) con configuración externa (`db.properties`)  
- Consultas parametrizadas con `PreparedStatement`  
- Recuperación de claves AUTO_INCREMENT con `Statement.RETURN_GENERATED_KEYS`  
- Implementación de transacciones con `commit` y `rollback`  

## Requisitos 
1. JDK configurado.  
2. Tomcat 9 registrado en el IDE.  
3. Puerto del servidor disponible.  
 
## Ejecución 
1. Abrir el proyecto en NetBeans.  
2. Limpiar y construir.  
3. Ejecutar sobre Tomcat.  
4. Abrir `/servicedesk360` en el navegador.  

## Detalles de la semana 2  
- **Registro de usuarios** con validaciones: campos vacíos, correo inválido, contraseña insegura, confirmación distinta.  
- **Acceso y autenticación**: credenciales correctas → panel; credenciales incorrectas → rechazo.  
- **Sesiones y cookies**:  
  - `JSESSIONID` administrado por el contenedor.  
  - Cookie `ultimoUsuario` creada al activar “Recordar correo”.  
  - Eliminación de cookie al desactivar “Recordar correo”.  
  - Logout invalida sesión y bloquea acceso al panel.  
  - Reinicio de Tomcat elimina usuarios temporales.  

## Detalles de la semana 3  
- **Refactorización**: separación de lógica en servicios (`ServicioRegistro`, `Autenticador`).  
- **Modelo POO**: creación de clases `Usuario`, `Solicitante`, `Tecnico`, `TicketSoporte`.  
- **Prueba de dominio**: ejecución de `PruebaModelo.java` para validar relaciones.  
- **Documentación**: matriz de entidades y responsabilidades, tabla de principios SOLID.  
- **Diagramas UML**: representación de herencia, composición y multiplicidades.  

## Detalles de la semana 4  
- **Controladores de tickets**: `TicketListadoServlet` para listar y `TicketNuevoServlet` para crear.  
- **Inicialización de servicios**: `ServicioTickets` registrado en el `ServletContext`.  
- **Validaciones**: título mínimo 5 caracteres, descripción mínima 10, prioridad obligatoria.  
- **Patrón PRG**: creación de ticket → redirect a `/tickets?estado=creado`.

## Detalles de la semana 6  
- **Esquema relacional**: creación de tablas `clientes`, `equipos`, `tecnicos`, `categorias`, `tickets`, `seguimientos` con claves primarias, foráneas y restricciones (`NOT NULL`, `UNIQUE`, `CHECK`).  
- **Usuario de aplicación**: cuenta `servicedesk_app` con privilegios limitados para evitar uso de root.  
- **Clase de conexión**: `ConexionBD` carga credenciales desde archivo externo, evitando contraseñas en el repositorio.  
- **Prueba de conexión**: validación de metadatos (`DatabaseMetaData`) y estado de conexión (`isValid`).  
- **Consultas parametrizadas**: búsqueda de clientes por correo con `PreparedStatement`, evitando SQL injection.  
- **Inserción con clave generada**: recuperación de `id_cliente` mediante `getGeneratedKeys`.  
- **Transacción controlada**: registro de ticket y seguimiento inicial como unidad atómica; rollback si alguna operación falla.  
- **Matriz de pruebas**: validación de integridad referencial, inserciones correctas, errores esperados y confirmación de rollback.  


## Equipo  
- Vilic Ayala  
