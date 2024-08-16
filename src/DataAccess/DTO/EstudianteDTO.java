package DataAccess.DTO;

import java.io.Serializable;

public class EstudianteDTO implements Serializable {
    private String codigoUnico;
    private String nombres;
    private String apellidos;
    private String año;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacion;

    // Constructor por defecto
    public EstudianteDTO() {}

    // Constructor con parámetros
    public EstudianteDTO(String codigoUnico, String nombres, String apellidos, String año, String estado, String fechaCreacion, String fechaModificacion) {
        this.codigoUnico = codigoUnico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.año = año;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters y Setters
    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "codigoUnico='" + codigoUnico + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", año='" + año + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                '}';
    }
}
