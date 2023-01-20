

<%@page import="vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <link rel="stylesheet" href="Login.css">
        <title>Login</title>
    </head>
    
    <body class="align">
        <%Presentador pre = (Presentador) session.getAttribute("pre");%>

        <div class="container">
            
            <div class="navbar">
                <img src="img/logo.png" class="logo">
                <nav>
                    <ul>
                        <li><a href="MenuPrincipal.jsp">Volver</a></li>
                    </ul>
                </nav>
                <img src="img/menu.png" class="menu-icon">
            </div>

            <div class="login-box">
                
                    <h2>Iniciar Sesion</h2>
                    <html:form action="/AsistenciaControl" method="Post">
                        <label style="color:white;">Usuario</label>  
                        <div class="user-box">                                         
                            <html:text property="dni" value="" styleClass="texto"/>
                        </div>
                        <label style="color:white;">Contraseña</label>
                        <div class="user-box">                           
                            <html:text property="contra" value=""/>
                        </div>
                        <a>
                            <span></span>
                            <span></span>
                            <span></span>
                            <span></span>
                            <html:submit property="acc" value="Validar" style="background:none; 
                                         border:none; color: white; font-size: 16px; text-transform: uppercase; letter-spacing: 4px;"/>
                        </a>
                    </html:form>
                 
                 </div>            
              </div>
              <center><p class="mensaje"><%=pre.getMsg() %></p></center>
            
       
        
    </body>
</html>
