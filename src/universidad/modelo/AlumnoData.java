
package universidad.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.entidades.Alumno;

public class AlumnoData {
    
    private Connection con;
    
    public AlumnoData(Conexion conexion){
    con=conexion.getConnection();
    }
    
    public void guardarAlumno(Alumno a){
    
    String sql="INSERT INTO alumno(nombreAlumno,fecNac,activo) VALUE(?,?,?);";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setString(1,a.getNombre());
    ps.setDate(2,Date.valueOf(a.getFecNac()));
    ps.setBoolean(3,a.isActivo());
    ps.executeUpdate();
    
    ResultSet rs= ps.getGeneratedKeys();
    
    if(rs.next()){
      a.setIdAlumno(rs.getInt(1));
     }else {
        JOptionPane.showMessageDialog(null,"No se pudo obtener el id");
    }
    con.close();
    
    }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"No se pudo guardar Alumno");
        }
 }
    public Alumno buscarAlumno(int id){
        String sql="Select * from alumno Where idAlumno=?;";
        Alumno al=null;
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
        
            if(rs.next()){
             al=new Alumno();
             al.setIdAlumno(rs.getInt("idAlumno"));
             al.setNombre(rs.getString("nombreAlumno"));
             al.setFecNac(rs.getDate("fecNac").toLocalDate());
             al.setActivo(rs.getBoolean("activo"));
             }
     
         con.close();
         
        }
     catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se encontro un alumno con ese ID");
        }
        return al;
    }
    
    public List<Alumno> obtenerAlumnos(){
        String sql="Select * from alumno;";
        Alumno al=null;
        List<Alumno> alumnos=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
      
            ResultSet rs= ps.executeQuery();
        
            while(rs.next()){
             al=new Alumno();
             al.setIdAlumno(rs.getInt("idAlumno"));
             al.setNombre(rs.getString("nombreAlumno"));
             al.setFecNac(rs.getDate("fecNac").toLocalDate());
             al.setActivo(rs.getBoolean("activo"));
             alumnos.add(al);
                System.out.println(al.getNombre());
             }
     
         con.close();
         
        }
     catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se encontraron los alumno con ese ID");
        }
        return alumnos;
    }
    
     public void actualizarAlumno(Alumno a){
    
    String sql="UPDATE alumno Set nombreAlumno=?,fecNac=?,activo=? WHERE idAlumno=?;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setString(1,a.getNombre());
    ps.setDate(2,Date.valueOf(a.getFecNac()));
    ps.setBoolean(3,a.isActivo());
    ps.setInt(4, a.getIdAlumno());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"La modificacion ha sido exitosa");
    
    con.close();
    
    }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"No se pudo Actualizar Alumno");
        }
 }
     
     public void borrarAlumno(int id){
         String sql="DELETE FROM `alumno` WHERE idAlumno=? ";
     
            try{
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null,"El alumno fue eliminado con exito");
            }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo borrar el alumno indicado");            }
     
     }
}
