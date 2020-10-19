
package universidad.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;


public class InscripcionData {
    private Connection con;
    
    public InscripcionData(Conexion conexion){
        this.con=conexion.getConnection();
    }
    
    public void guardarInscripcion(Inscripcion i){
        String sql="INSERT INTO inscripcion(idAlumno,idMateria,nota) VALUES (?,?,?);";
        try{
            PreparedStatement ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,i.getAlumno().getIdAlumno());
            ps.setInt(2,i.getMateria().getIdMateria());
            ps.setDouble(3,i.getNota());
            ps.executeUpdate();
                    
              ResultSet rs = ps.getGeneratedKeys();
               if(rs.next()){
               i.setIdInscripcion(rs.getInt(1));
               }else {JOptionPane.showMessageDialog(null,"No se Pudo obtener el id");}
               
               con.close();
               JOptionPane.showMessageDialog(null,"El alumno se guardo con exito");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se pudo registrar la Inscripcion");
                }
    }
    
    public List<Inscripcion> obtenerInscripcion(){
        String sql="SELECT * FROM inscripcion;";
        Inscripcion in=null;
        Alumno al=null;
        Materia ma=null;
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            al=new Alumno(rs.getInt("idAlumno"));
            ma=new Materia(rs.getInt("idMateria"));
            in=new Inscripcion();
            in.setAlumno(al);
            in.setMateria(ma);
            in.setNota(rs.getDouble("nota"));
            in.setIdInscripcion(rs.getInt("idInscripcion"));
            inscripciones.add(in);
        }
        
        
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se encontro la Inscripcion");
        }
    return inscripciones;
    }
    
}
