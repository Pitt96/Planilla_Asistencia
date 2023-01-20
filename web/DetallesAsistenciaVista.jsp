

<%@page import="vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Asistencia.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
        <title>Detalle Asistencia</title>
    </head>
    <body>
        <%Presentador pre = (Presentador) session.getAttribute("pre");%>
        <%String msg = pre.getMsg(); %>
        <%Object[] datosasis=(Object[])session.getAttribute("datosasistencia"); %>
        <%
           String clase="";
           int hora= Integer.parseInt(datosasis[2].toString().substring(0, 2));
           int minutos=Integer.parseInt(datosasis[2].toString().substring(3));
           if ((hora == 8 && minutos == 0) || hora < 8) {
                   clase="alerta1";
               } else if (hora == 8 && minutos != 0) {
                   clase="alerta2";
               } else if (hora > 8) {
                   clase="alerta3";
               }
        %>
        <div class="header">
            <a href="#" class="btn_volver">
                <svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 1024 1024"><path d="M874.690416 495.52477c0 11.2973-9.168824 20.466124-20.466124 20.466124l-604.773963 0 188.083679 188.083679c7.992021 7.992021 7.992021 20.947078 0 28.939099-4.001127 3.990894-9.240455 5.996574-14.46955 5.996574-5.239328 0-10.478655-1.995447-14.479783-5.996574l-223.00912-223.00912c-3.837398-3.837398-5.996574-9.046027-5.996574-14.46955 0-5.433756 2.159176-10.632151 5.996574-14.46955l223.019353-223.029586c7.992021-7.992021 20.957311-7.992021 28.949332 0 7.992021 8.002254 7.992021 20.957311 0 28.949332l-188.073446 188.073446 604.753497 0C865.521592 475.058646 874.690416 484.217237 874.690416 495.52477z"></path></svg>
                <span>Volver Asistencia</span>
            </a>
            
            <!--Content before waves-->
            <div class="inner-header flex " >
                <!--Just the logo.. Don't mind this-->
                <div class="e_glass">
                    <h1 class="animate__animated animate__backInUp">¡Detalles de su Asistencia!</h1>
                    <div class="container_detalle">
                        <div class="datos">
                            <p>Dni: <br><span><%=datosasis[4].toString()%></span></p>
                            <p>Nombre: <br><span><%=datosasis[5].toString()%></span></p>
                            <p>Fecha: <span><%=datosasis[1].toString()%></span> <br>Hora: <span><%=datosasis[2].toString()%></span></p>
                        </div>
                        <div class="obs">
                            <p>Obs. <span><%=datosasis[3].toString()%></span></p>
                            <p class="<%=clase%>"><%=msg%></p>
                        </div>
                    </div>
                </div>
                

            </div>
        
        <!--Waves Container-->
        <div>
            <svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
            <defs>
            <path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
            </defs>
            <g class="parallax">
            <use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7" />
            <use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)" />
            <use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)" />
            <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
            </g>
            </svg>
        </div>
        
        
        
        
        
        
        <html:form action="/AsistenciaControl" method="Post">
            <html:hidden property="dni" value="abc"/>
            <a class="btn_volver"><strong><html:submit property="acc" value="Volver Asistencia" 
                         style="background: #fff; border:none; font-family: 'Lato', sans-serif; font-weight:bolder;"/></strong></a>
        </html:form>
        <!--<a href="AsistenciaVista.jsp">Volver</a>-->
        
    </body>
</html>
