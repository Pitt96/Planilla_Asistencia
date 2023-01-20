

<%@page import="vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="BuscarBoleta.css">
        <title>Boleta de Pago</title>
    </head>
    <body>
        <%Presentador pre = (Presentador) session.getAttribute("pre");%>
        
        <div class="navbar">
            <img src="img/logo.png" class="logo">
            <nav>
                <ul>
                    <li><a href="MenuAdministrador.jsp">Volver</a></li>
                </ul>
            </nav>
            <img src="img/menu.png" class="menu-icon">
        </div>

        <div class="container-sm"> 
            <div  class="row">
                <div >
                    <h2 align="center">Consultar boleta</h2>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            
            <html:form action="/BoletaControl" method="Post">                  
                <div class="col-8">    
                    <label for="formGroupExampleInput" class="form-label">Ingrese DNI</label>
                    <html:text property="dni" value="" styleClass="form-control" styleId="formGroupExampleInput"/>
                    <br>
                    <label for="inputState" class="form-label">Elija un mes</label>
                    <html:select property="mes" styleClass="form-select" styleId="inputState">
                        <html:option value="ENERO" />
                        <html:option value="FEBRERO" />
                        <html:option value="MARZO" />
                        <html:option value="ABRIL" />
                        <html:option value="MAYO" />
                        <html:option value="JUNIO" />
                        <html:option value="JULIO" />
                        <html:option value="AGOSTO" />
                        <html:option value="SETIEMBRE" />
                        <html:option value="OCTUBRE" />
                        <html:option value="NOVIEMBRE" />
                        <html:option value="DICIEMBRE" />
                    </html:select>                  
                    <br>                   
                    <html:submit property="acc" value="Mostrar Boleta" styleClass="btn btn-success"/>  
                    <br>
                </div>                 
                </html:form>
           
            <br>
            <center><p style="color: white;"><%=pre.getMsg()%></p></center>
        <br><br>
        </div> 
      
    </body>
</html>
