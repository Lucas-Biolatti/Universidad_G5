
package universidad.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
               
               ps.close();
               JOptionPane.showMessageDialog(null,"El alumno se guardo con exito");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se pudo registrar la Inscripcion");
                }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        String sql="SELECT * FROM inscripcion;";
        Inscripcion in;
        //Alumno al=null;
        //Materia ma=null;
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            //al=new Alumno(rs.getInt("idAlumno"));
            //ma=new Materia(rs.getInt("idMateria"));
            in=new Inscripcion();
            in.setAlumno(buscarAlumno(rs.getInt("idAlumno")));
            in.setMateria(buscarMateria(rs.getInt("idMateria")));
            in.setNota(rs.getDouble("nota"));
            in.setIdInscripcion(rs.getInt("idInscripcion"));
            inscripciones.add(in);
        }
        
        
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo ejecutar la busqueda");
        }
    return inscripciones;
    }
    
    public List<Inscripcion> obtenerInscripcionesXAlumno(int id){
         String sql="SELECT * FROM inscripcion WHERE idAlumno=?;";
        Inscripcion in=null;
        //Alumno al=null;
        //Materia ma=null;
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            //al=new Alumno(rs.getInt("idAlumno"));
            //ma=new Materia(rs.getInt("idMateria"));
            in=new Inscripcion();
            in.setAlumno(buscarAlumno(rs.getInt("idAlumno")));
            in.setMateria(buscarMateria(rs.getInt("idMateria")));
            in.setNota(rs.getDouble("nota"));
            in.setIdInscripcion(rs.getInt("idInscripcion"));
            inscripciones.add(in);
        }
        
        
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se encontro la Inscripcion");
        }
    return inscripciones;
    }
    
    public Inscripcion buscarInscripcion(int id){
    String sql="SELECT * FROM inscripcion WHERE idInscripcion=?";
    Inscripcion in = null;
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
        in=new Inscripcion();
        in.setIdInscripcion(rs.getInt("idInscripcion"));
        in.setAlumno(buscarAlumno(rs.getInt("idAlumno")));
        in.setMateria(buscarMateria(rs.getInt("idMateria")));
        in.setNota(rs.getDouble("nota"));
        } 
        ps.close();
    
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"No se encontro el id seleccionado");
            }
            return in;
    }
    
    public List<Inscripcion> obtenerInscripcionesXMateria(int id){
        String sql="SELECT * FROM inscripcion WHERE idMateria=?;";
        Inscripcion in;
        List<Inscripcion> inscripciones=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            in=new Inscripcion();
            in.setIdInscripcion(rs.getInt("idInscripcion"));
            in.setAlumno(buscarAlumno(rs.getInt("idAlumno")));
            in.setMateria(buscarMateria(rs.getInt("idMateria")));
            in.setNota(rs.getDouble("nota"));
            inscripciones.add(in);
            }
            ps.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"no se encontro el id de la materia");
            }
            return inscripciones;
    }
    
    public void actualizarNota(int idInscripcion,int idMateria,double nota){
    String sql="UPDATE inscripcion SET nota=? WHERE idInscripcion=? AND idMateria=?;";
    
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, nota);
        ps.setInt(2, idInscripcion);
        ps.setInt(3, idMateria);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"La nota se actualizo correctamente");
      ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo actualizar la Nota");
    }
    
    }
    
    public void eliminarInscripcion(int idAlum,int idMat){
    String sql="DELETE FROM inscripcion WHERE inscripcion.idAlumno=? and inscripcion.idMateria=?; ";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    
    ps.setInt(1, idAlum);
    ps.setInt(2, idMat);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"La inscripcion fue eliminada con exito");
    ps.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo eliminar la Inscripcion");
        }
    
    }
    ////////////////////////////METODOS AUXILIARES////////////////////
    public Alumno buscarAlumno(int id){
        Conexion c=new Conexion(); 
        AlumnoData ad=new AlumnoData(c);
        return ad.buscarAlumno(id);
     }
    public Materia buscarMateria(int id){
        Conexion c=new Conexion(); 
        MateriaData md=new MateriaData(c);
        return md.buscarMateria(id);
     }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        List<Materia> materias = new ArrayList<Materia>();
        Materia m;
        String sql="SELECT materia.idMateria,nombreMateria FROM inscripcion,materia WHERE inscripcion.idMateria=materia.idMateria and inscripcion.idAlumno=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m=new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombreMateria(rs.getString("nombreMateria"));
                materias.add(m);
                
                ps.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo obtener las materias");
        }
        return materias;
    }
    public List<Materia> obtenerMateriasNoCursadas(int id){
        List<Materia> materias = new ArrayList<Materia>();
        Materia m;
        String sql="SELECT * FROM `materia` WHERE idMateria NOT IN(SELECT idMateria from inscripcion WHERE inscripcion.idAlumno=?);";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m=new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombreMateria(rs.getString("nombreMateria"));
                materias.add(m);
                
                ps.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo obtener las materias");
        }
        return materias;
    }
}
