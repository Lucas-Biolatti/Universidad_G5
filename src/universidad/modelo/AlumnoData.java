
package universidad.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
