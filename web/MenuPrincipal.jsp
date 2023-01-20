

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Planilla-Asistencia</title>
    <link rel="stylesheet" href="EstilosMenuPrincipal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    <header class="bg_animate">
        <div class="header_nav">
             
            <div class="contenedor">
                <img src="./img/logo.png" alt="" class="imagen">
                <html:form action="/AsistenciaControl" method="Post" styleClass="formulario">
                    <html:hidden property="dni" value="abc" />
                    <html:submit property="acc" value="Login" style="background:none; color:white; border: none; cursor:pointer; font-size:20px; font-family: 'Roboto', 'Sans serif'; padding:10px; z-index:90;"/>
                </html:form>
            </div>
        </div>

        <section class="banner contenedor">
            <html:form action="/AsistenciaControl" method="Post" styleClass="banner_title" > 
                <h2>Si quieres enseñar a tus niños puntualidad, <br> comienza a ser puntual tú mismo.</h2>

                <html:hidden property="dni" value="abc"/>
                <html:submit property="acc" value="Marcar Asistencia" styleClass="btn_asistencia animate__animated animate__bounce" style="font-family: 'Roboto', 'Sans serif'; border:none;"/>
                
            </html:form>
            <div class="banner_img ">
                <img src="./img/reloj.png" alt="">
            </div>
        </section>    

        <div class="burbujas">
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
            <div class="burbuja"></div>
        </div>
    </header>


</body>
</html>
