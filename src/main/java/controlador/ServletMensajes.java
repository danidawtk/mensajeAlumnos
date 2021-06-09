/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Utilidades;

/**
 *
 * @author DAW2-PROFESOR
 */
public class ServletMensajes extends HttpServlet {
ArrayList<String> listaGrupos = new ArrayList<String> () ;
String rutaArchivos;

public void init( ServletConfig config ) throws ServletException {
    
    listaGrupos.add("2daw_a");
    listaGrupos.add("2daw_b");
   rutaArchivos = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
    
}


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMensajes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMensajes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grupoSeleccionado;
        if(request.getParameter("grupo")==null){
            grupoSeleccionado= "2daw_a";
        }else{
            grupoSeleccionado=request.getParameter("grupo");
        }
        String nombreFichero = grupoSeleccionado +".txt";
        String nombreCompletoFichero = rutaArchivos.concat(File.separator).concat(nombreFichero);
        ArrayList<Alumno> listaAlumnos = Utilidades.getAlumnos(nombreCompletoFichero);
        request.setAttribute("listaAlumnos", listaAlumnos);
        request.setAttribute("listaGrupos", listaGrupos);
        request.setAttribute("grupoSeleccionado", grupoSeleccionado);
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grupoSeleccionado = request.getParameter("grupo_seleccionado");
        String nombreFichero = grupoSeleccionado +".txt";
        String nombreCompletoFichero = rutaArchivos.concat(File.separator).concat(nombreFichero);
        ArrayList<Alumno> listaAlumnos = Utilidades.getAlumnos(nombreCompletoFichero);        
        ArrayList<Alumno> AlumnosSelecionados = new ArrayList<Alumno>();
        
        for(int n=1;n<=30;n++){
            if(request.getParameter(String.valueOf(n))!=null){
                for( Alumno a:listaAlumnos){
                    if(a.getId()==n){
                        Alumno nuevoAlumno = new Alumno(a.getId(),a.getNombre(),a.getApellidos(),a.getEmail());
                        
                        AlumnosSelecionados.add(nuevoAlumno);
                    }
                }
            }
        }
        request.setAttribute("AlumnosSelecionados", AlumnosSelecionados);
        request.setAttribute("grupoSeleccionado", grupoSeleccionado);
        request.getRequestDispatcher("envia.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
