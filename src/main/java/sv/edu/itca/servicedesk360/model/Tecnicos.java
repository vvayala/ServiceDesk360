package sv.edu.itca.servicedesk360.model;

public class Tecnicos {

    private int idTecnico;
    private String nombre;
    private String correo;
    private String especialidad;
    private boolean activo;

    public Tecnicos() {
    }

    public Tecnicos(int idTecnico, String nombre, String correo,
                   String especialidad, boolean activo) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}