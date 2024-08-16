package DataAccess.IDAO;

import java.time.LocalDateTime;

public class RALugarDTO {
    private int idLugar;
    private String nombre;
    private String region;
    private String pais;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModifica;

    // Constructor vacío
    public RALugarDTO() {}

    // Constructor con parámetros
    public RALugarDTO(int idLugar, String nombre, String region, String pais, String estado, LocalDateTime fechaCreacion, LocalDateTime fechaModifica) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.region = region;
        this.pais = pais;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    // Getters y Setters
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(LocalDateTime fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "RALugarDTO [idLugar=" + idLugar + ", nombre=" + nombre + ", region=" + region + ", pais=" + pais
                + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaModifica=" + fechaModifica + "]";
    }
}

