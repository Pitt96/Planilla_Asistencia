

<%@page import="vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="EstiloMenuAdmin.css">
        <title>Inicio|Administrador</title>
    </head>
    <body>
        <%Presentador pre = (Presentador) session.getAttribute("pre");%>
        <%Object[] datosadmin=pre.getFil(); %>
       
        <div class="container">
            <div class="navbar">
                <img src="img/logo.png" class="logo">
                <nav>
                    <ul>
                        <li><a href="MenuPrincipal.jsp">Salir</a></li>
                    </ul>
                </nav>
                <img src="img/menu.png" class="menu-icon">
            </div>

            <div class="row">
                <div class="col-1">
                    <h2>HOLA ADMINISTRADOR</h2>
                    <h3>¡Bienvenido(a)! En este apartado se presentara<br>la boleta de pago</h3>
                    
                        <html:form action="/BoletaControl" method="Post">
                            <html:hidden property="dni" value="abc"/>
                            <html:submit property="acc" value="Boleta de Pago" styleClass="boton"/>                          
                        </html:form>
                    
                </div>
                <div class="col-2">
                    <img src="img/boleta.png" class="boleta">
                </div>
            </div>
        </div>
  
  

    </body>
</html>
