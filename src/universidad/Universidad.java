
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
      Alumno lucas=new Alumno("Lucas, Biolatti",LocalDate.of(1991, 6, 14),true);
      Alumno agus=new Alumno(2,"Agustin, Segovia",LocalDate.of(1993,2,1),true);
       AlumnoData ad=new AlumnoData(c);
       //ad.guardarAlumno(lucas);
       //ad.guardarAlumno(agus);
   // Alumno l=new Alumno(2);
        //System.out.println(ad.buscarAlumno(1));
       // ad.guardarAlumno(lucas);
        
       
      Materia lab1=new Materia(1,"Laboratorio 1");
       MateriaData md=new MateriaData(c);
      // md.agregarMateria(lab1);
        //System.out.println(md.buscarMateria(1));
       // Materia m=new Materia(1);
      //JOptionPane.showMessageDialog(null,ad.obtenerAlumnos());
      //System.out.println(lucas.getIdAlumno()); 
      //Inscripcion in=new Inscripcion(ad.buscarAlumno(4),lab1,8);
        //System.out.println(in.getAlumno().getIdAlumno());
       // System.out.println(in.getMateria().getIdMateria());
      InscripcionData indat=new InscripcionData(c);
     // indat.guardarInscripcion(in);
     //Inscripcion i2=new Inscripcion(ad.buscarAlumno(5),md.buscarMateria(1),7);
     //indat.guardarInscripcion(i2);
     
       System.out.println(indat.obtenerInscripcionXAlumno(5));
    
    }
    
}
