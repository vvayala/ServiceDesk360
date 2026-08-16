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

## Equipo  
- Vilic Ayala  
