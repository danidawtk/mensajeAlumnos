/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author DAW2-PROFESOR
 */
public class Utilidades {
    public static ArrayList<Alumno> getAlumnos( String archivo ){
          String SEPARATOR=";";
          ArrayList<Alumno> miListaAlumnos = new ArrayList<Alumno> ();
        try {
              BufferedReader br =new BufferedReader(new FileReader(archivo));
              String line = br.readLine();
              while (null!=line) {
                 String [] fields = line.split(SEPARATOR);

                     Alumno miAlumno = new Alumno( Integer.parseInt( fields[0]) ,fields[1],fields[2],fields[3]);
                     miListaAlumnos.add(miAlumno);

                 line = br.readLine();
         }
        }
         catch ( Exception e ) {

                 }
        return miListaAlumnos;
     } //fin de getAlumnos
}
