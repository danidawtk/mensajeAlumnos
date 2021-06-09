<%-- 
    Document   : envia
    Created on : 09-jun-2021, 17:24:12
    Author     : DAW-A
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <% String grupoSeleccionado = ( String ) request.getAttribute("grupoSeleccionado");
           ArrayList<Alumno> listaAlumnos =(ArrayList) request.getAttribute("AlumnosSelecionados");
 
        %>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
      tinymce.init({
        selector: '#mytextarea'
      });
    </script>
        <h1>Mensajes a Alumnos</h1>
        <h2>Mensajes a alumnos del grupo: <%=grupoSeleccionado%></h2>
        <table>
                    <%
                        for(Alumno a:listaAlumnos ){
                            out.print("<tr>"
                                        + "<td>"+ a.getId()+"</td>"
                                        + "<td>"+a.getNombre()+"</td>"
                                        + "<td>"+a.getApellidos()+"</td>"
                                        + "<td>"+a.getEmail()+"</td>"
                                    + "</tr>");
                        }
                    %>
                </table>
                <textarea id="mytextarea">Hello, World!</textarea>
    </body>
</html>
