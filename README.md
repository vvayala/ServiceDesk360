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

## Tecnologías de la semana 7  
-Se crea el CRUD Clientes implementando DAO.
- Confirmación de eliminación física con formulario POST independiente y validación en servidor.  
- Manejo controlado de integridad referencial en DAO mediante captura de `SQLException`.  
- Uso de Bootstrap en todas las vistas JSP para unificar diseño y mejorar experiencia de usuario. (Agregado)
- Pruebas de validación de entradas especiales (apóstrofes, duplicados) y control de errores de conexión.  
- Persistencia garantizada tras reinicios de Tomcat y control de flujo con PRG.  


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

## Detalles de la semana 7  
- **CRUD completo con DAO**: se implementaron operaciones de creación, lectura, actualización y eliminación sobre la entidad `Cliente`, utilizando clases DAO para encapsular la lógica de acceso a datos.  
- **Validaciones de negocio**: se reforzaron reglas como evitar correos duplicados, impedir inserciones incompletas y controlar ediciones sobre IDs inexistentes.  
- **Persistencia y robustez**: se verificó que los datos permanecen tras reinicios de Tomcat y que el patrón PRG evita duplicaciones en inserciones o actualizaciones.  
- **Gestión de recursos**: todos los DAOs utilizan `try-with-resources` para garantizar el cierre automático de conexiones y evitar fugas.  
- **Seguridad y buenas prácticas**: se procesaron entradas especiales (como apóstrofes) con `PreparedStatement` para prevenir SQL injection, y se confirmó que credenciales reales no se versionan en repositorios.  
- **Interfaz con Bootstrap**: las vistas JSP fueron adaptadas con componentes de Bootstrap (`alert`, `form-control`, `table`, `btn`) para mejorar la experiencia de usuario y mantener consistencia visual.  

## Equipo  
- Vilic Ayala  
