package DataAccess.DTO;
public class RALugarDTO {
    private int id;
    private String nombre;
    private String region;
    private String pais;

    // Constructor vacío
    public RALugarDTO() {}

    // Constructor con parámetros
    public RALugarDTO(int id, String nombre, String region, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
        this.pais = pais;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "RALugarDTO [id=" + id + ", nombre=" + nombre + ", region=" + region + ", pais=" + pais + "]";
    }
}
