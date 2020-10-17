
package universidad;

import java.sql.Connection;
import java.time.LocalDate;
import universidad.entidades.Alumno;
import universidad.entidades.Materia;
import universidad.modelo.AlumnoData;
import universidad.modelo.Conexion;
import universidad.modelo.MateriaData;

public class Universidad {

    public static void main(String[] args) {
       Conexion c=new Conexion();
       //Alumno lucas=new Alumno("Lucas, Biolatti",LocalDate.of(1991, 6, 14),true);
       //AlumnoData ad=new AlumnoData(c);
       //ad.guardarAlumno(lucas);
       Materia lab1=new Materia("Laboratorio 1");
       MateriaData md=new MateriaData(c);
       md.agregarMateria(lab1);
    }
    
}
