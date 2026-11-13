package factory;

public class Entrenador extends Usuario {
    private String especialidad;

    public Entrenador(String id, String nombre, String email, String especialidad) {
        super(id, nombre, email);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("[Entrenador] ID: " + id + " | Nombre: " + nombre + " | Email: " + email + " | Especialidad: " + especialidad);
    }
}
