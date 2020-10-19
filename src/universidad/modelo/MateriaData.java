
package universidad.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.entidades.Materia;

public class MateriaData {
    
    private Connection con;
    
    public MateriaData(Conexion c){
        this.con=c.getConnection();
    }
    
    public void agregarMateria(Materia m){
    
        String sql=("INSERT INTO materia(nombreMateria) VALUES (?);");
        try{
        PreparedStatement ps;
            ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,m.getNombreMateria());
        ps.executeUpdate();
        
        ResultSet rs= ps.getGeneratedKeys();
        
        if(rs.next()){
            m.setIdMateria(rs.getInt(1));
        }else{
            JOptionPane.showMessageDialog(null,"No se logro recuperar el id de la materia");
        }
        
        con.close();
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se logro insertar la materia");
            }
        }
    
    public Materia buscarMateria(int id){
    
    String sql="SELECT * FROM materia WHERE idMateria=?";
        Materia m=null;
    
        try{
          PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, id);
          ResultSet rs=ps.executeQuery();
          if(rs.next()){
              m=new Materia();
              m.setIdMateria(rs.getInt(1));
              m.setNombreMateria(rs.getString("nombreMateria"));
                        
          }
          ps.close();
        
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se encontro la materia");
            }
        
       return m;
    
    }
    
        public List<Materia> obtenerMaterias(){
        
        String sql="SELECT * FROM materia;";
        Materia m=null;
        List<Materia> materias=new ArrayList<>();
    
        try{
          PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          
          ResultSet rs=ps.executeQuery();
          while(rs.next()){
              m=new Materia();
              m.setNombreMateria(rs.getString("nombreMateria"));
              m.setIdMateria(rs.getInt("idMateria"));
              materias.add(m);
          }
          ps.close();
        
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se encontro la materia");
            }
        
       return materias;
     
        }
        
        public void actualizarMateria(Materia m){
        
            String sql="UPDATE materia SET nombreMateria=? WHERE idMateria=?;";
            try{
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,m.getNombreMateria());
                ps.setInt(2,m.getIdMateria());
                ps.executeUpdate();
                ps.close();
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se logro Actualizar la materia" );
            }
            
        }
        
        public void eliminarMateria(int id){
        String sql="DELETE FROM materia WHERE idMateria=?";
            try{
                
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();
                
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se pudo eliminar la materia con el ID seleccionado");
            }
        
        }
    
    
    
}
