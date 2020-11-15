
package universidad;

import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;
import universidad.modelo.AlumnoData;
import universidad.modelo.Conexion;
import universidad.modelo.InscripcionData;
import universidad.modelo.MateriaData;

public class Universidad {

    public static void main(String[] args) {
       Conexion c=new Conexion();
       
       /////////////////NUEVOS ALUMNOS////////////////
      Alumno lucas=new Alumno("Lucas, Biolatti",LocalDate.of(1991, 6, 14),true);
      Alumno juan=new Alumno("Juan, Perez",LocalDate.of(1985,1,15),true);
      /////////////////NUEVO ALUMNODATA///////////////
       AlumnoData ad=new AlumnoData(c);
       
       
       ///////////////PRUEBA ALUMNODATA//////////////
       //ad.guardarAlumno(juan);//Funciona ok
       //System.out.println(ad.buscarAlumno(6));//funciona ok
       //ad.actualizarAlumno(new Alumno(6,"Juan, Perez",LocalDate.of(1990,5,7),false));//Funciona ok
       //ad.borrarAlumno(6);//Funciona ok
       //System.out.println(ad.buscarAlumno(4));//Funciona ok
       //ad.obtenerAlumnos();//funciona ok
       ////////////////NUEVA MATERIA////////////////
      Materia lab1=new Materia(1,"Laboratorio 1");
      ////////////////NUEVA MATERIADATA////////////
       MateriaData md=new MateriaData(c);
       //////////////PRUEBA DE MATERIADATA////////
       //md.eliminarMateria(4);//Funciona ok
       //md.agregarMateria(new Materia("Programacion WEB"));//funciona Ok
       //System.out.println(md.buscarMateria(6));//funciona ok
       //md.obtenerMaterias();//funciona ok
       //md.actualizarMateria(new Materia(6,"Prog Web"));//funciona ok
      
      
     
     
      
      /////////////////NUEVA INSCRIPCION/////////////////////////
        //Inscripcion in=new Inscripcion(ad.buscarAlumno(4),lab1,8);
   ////////////////////NUEVA INSCRIPCIONDATA////////////////////
       InscripcionData indat=new InscripcionData(c);
       //indat.guardarInscripcion(new Inscripcion(new Alumno(2),new Materia(3),7.5));//Funciona OK
        //Inscripcion i2=new Inscripcion(ad.buscarAlumno(5),md.buscarMateria(1),7);
        //indat.guardarInscripcion(i2);
        
        ///////////////////////PRUEBAS DE INSCRIPCIONDATA////////////////////////
       // System.out.println(indat.obtenerInscripcionesXAlumno(5)); //funciona ok
       //System.out.println(indat.obtenerInscripciones()); //funciona ok
       //System.out.println(indat.obtenerInscripcionesXMateria(2)); //funciona ok
       //System.out.println(indat.buscarInscripcion(10)); //funciona ok
       //indat.actualizarNota(5, 2, 7.5); //funciona ok
       //indat.eliminarInscripcion(1);//funciona ok
    }
    
}
