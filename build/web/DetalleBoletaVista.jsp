
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Boleta.css">
        <title>Detalle Boleta de Pago</title>
    </head>
    <body>

        <%Presentador pre = (Presentador) session.getAttribute("pre");%>
        <%String msg = pre.getMsg(); %>
        <%Object[] datosbol = pre.getFil();
            List listasis = pre.getLis();%>

             
            <html:form action="/BoletaControl" method="Post">
                <html:hidden property="dni" value="abc"/>
                <html:submit property="acc" value="Volver" styleClass="boton_volver"/>
            </html:form>
    
    <div class="boleta-pago">
        <div class="boleta-pago__content">
            <div class="logo"><img class="img-responsive" src="img/logo.png" data-rjs="3"></div>
            
    
            <div class="boleta-pago__header">
    
                <div class="title">BOLETA DE PAGO - N° <%=datosbol[0] %> </div>
                    
            </div>
          <div class="table-boleta">
                <table>
                  <tr>
                    <td width="120" style="text-transform: uppercase;font-weight: bold;"> Codigo</td>
                    <td width="120" style="text-transform: uppercase;font-weight: bold;"> Fecha</td>
                    <td width="60" style="text-transform: uppercase;font-weight: bold;"> Hora</td>
                    <td width="160" style="text-transform: uppercase;font-weight: bold;"> Observacion</td>
                    <td width="90" style="text-transform: uppercase;font-weight: bold;">DNI</td>
                  </tr>
                  
                  <%for (int i = 0; i < listasis.size(); i++) {
                          Object[] asistencia = (Object[]) listasis.get(i);
                  %>
                  
                  <tr class="b-botom">
                    <td><%=asistencia[0] %></td>
                    <td><%=asistencia[1] %></td>
                    <td><%=asistencia[2] %></td>
                    <td><%=asistencia[3] %></td>
                    <td><%=asistencia[4] %></td>
                  </tr>
                  
                 <%}%>
                <tr>
                    
                    <td>
                        <br>
                        <div class="box-date--pension"><strong>Faltas: </strong><span> <%=datosbol[7] %></span></div>
                    </td>
                </tr>
            </table>
            
            <div class="boleta-pago__content-row">
    
                <div class="boleta-pago__row" style="border-bottom: 2px solid #229cbb;
                padding: 0 0 19px;">
    
                    <table cellpadding="0" cellspacing="0" >
    
                        <tbody>
                            <tr>
                                <td height="5"></td>
                            </tr>
                            <tr>
                                <td width="313" valign="top">
                                    <div class="boleta-pago__col">
                                        <div class="title">DATOS DE LA
                                            <div class="sub">Boleta de pago</div>
                                            <div>
                                            <div class="line"></div>
                                        </div>
                                        <div class="box-date">
                                            <div>
                                                <div class="box-date--text">N° <span><%=datosbol[0] %></span></div>
                                                <div class="box-date--text">Sueldo Bruto <span>S/. <%=datosbol[1] %></span></div>
                                                <div class="box-date--text">Descuento por observacion <span>S/.<%=datosbol[2] %></span></div>
                                            </div>
                                            <div>
                                                <div class="box-date--text">Descuento AFP <span>S/.<%=datosbol[3] %></span></div>
                                                <div class="box-date--text">Bonificacion <span>S/.<%=datosbol[4] %></span></div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
    
                                
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="boleta-pago__content-row">
                <div class="boleta-pago__row" >
                    <table cellpadding="0" cellspacing="0" >
                        <tbody>
                            <tr>
                                <td height="5"></td>
                            </tr>
                            <tr>
                                <td width="130" valign="top">
                                    <div class="boleta-pago__col">
                                        <div class="title">
                                            <div class="sub">Sueldo Final:</div>
                                            <div class="line"></div>
                                        </div>
                                        <div class="box-date">
                                            <div class="box-date-col">
                                                <div class="mes" style="font-weight: bold;">Sueldo Neto:</div>
                                                <div class="mes" style="font-weight: bold;">S/ <span style="font-size: 18px;"> <%=datosbol[5] %> </span></div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
    
            <div class="boleta-pago__footer">
                <%Date fecha = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");%>
                <p> <%=sdf.format(fecha)%> </p>
            </div>
            <div class="boleta-pago__mensaje">
                <p> <%=msg%></p>
            </div>
    </div>
       
    </div>
        
        
    </body>
</html>
