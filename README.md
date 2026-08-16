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

## Equipo  
- Vilic Ayala  
