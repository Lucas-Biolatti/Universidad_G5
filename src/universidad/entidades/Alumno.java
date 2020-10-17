/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.entidades;

import java.time.LocalDate;

/**
 *
 * @author lbiolatti
 */
public class Alumno {
    private int idAlumno;
    private String nombre;
    private LocalDate fecNac;
    private boolean activo;

    public Alumno(String nombre, LocalDate fecNac, boolean activo) {
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombre, LocalDate fecNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
