
package universidad.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidad.entidades.Materia;

public class MateriaData {
    
    private Connection con;
    
    public MateriaData(Conexion c){
        this.con=c.getConnection();
    }
    
    public void agregarMateria(Materia m){
    
        String sql=("INSERT INTO materia(nombreMateria) VALUE (?);");
        try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,m.getNombreMateria());
        ps.executeUpdate();
        
        ResultSet rs= ps.getGeneratedKeys();
        
        if(rs.next()){
            m.setIdMateria(rs.getInt(1));
        }else{
            JOptionPane.showMessageDialog(null,"No se logro recuperar el id de la materia");
        }
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se logro insertar la materia");
            }
        }
    
    
}
