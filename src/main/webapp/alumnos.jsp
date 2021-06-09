<%-- 
    Document   : alumnos
    Created on : 02-jun-2021, 16:34:29
    Author     : DAW2-PROFESOR
--%>

<%@page import="modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #form1 { border: 2px solid red}
            #form2 { border: 2px solid blue}
            #table,td{border: 1px solid grey;border-collapse: collapse}
        </style>
    </head>
    <body>
        <h1>Mensajes a Alumnos</h1>
        <%
            ArrayList<String> listaGrupos = ( ArrayList<String> ) request.getAttribute("listaGrupos");
            String grupoSeleccionado = ( String ) request.getAttribute("grupoSeleccionado");
            ArrayList<Alumno> listaAlumnos =(ArrayList) request.getAttribute("listaAlumnos");
         %>
        <form id="form1" action="ServletMensajes">
            Grupo: <select name="grupo">
                <% for ( String g: listaGrupos ) {
                    String cadenaSelected = "";
                    if ( g.equals(grupoSeleccionado) ) {
                        cadenaSelected = " selected ";
                    }
                    out.println("<option value=" + g + cadenaSelected + " >" + g + "</option>" );
                }
                %>
            </select>
            <p>
                  <input type="submit" value="Seleccionar">
            </p>
            
        </form>
            <form id="form2" action="ServletMensajes" method="post">
                <input type="text" value="<%=grupoSeleccionado%>" name="grupo_seleccionado">
                <table>
                    <%
                        for(Alumno a:listaAlumnos ){
                            out.print("<tr><td>"+ a.getId()+"</td>"
                                    + "<td>"+a.getNombre()+"</td>"
                                    + "<td>"+a.getApellidos()+"</td>"
                                    + "<td>"+a.getEmail()+"</td>"
                                    + "<td>"+"<input type='checkbox' name='"+a.getId()+"'>"+"</td></tr>");
                        }
                    %>
                    
                </table>
                    <input type="submit" value="Enviar">
            </form>
    </body>
</html>
