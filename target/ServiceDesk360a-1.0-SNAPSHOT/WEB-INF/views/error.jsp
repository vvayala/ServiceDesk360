<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html> 
<head><title>Error controlado</title></head> 
<body> 
    <h1>No fue posible completar la operación</h1> 
    <p><c:out value="${mensajeError}" /></p> 
    <a href="${pageContext.request.contextPath}/panel">Volver al panel</a> 
</body> 
</html>