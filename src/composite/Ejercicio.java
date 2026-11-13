package composite;

public class Ejercicio implements ComponenteEntrenamiento {
    private String nombre;
    private int duracionMinutos;
    private String grupoMuscular;

    public Ejercicio(String nombre, int duracionMinutos, String grupoMuscular) {
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public void ejecutar() {
        System.out.println("    [Ejercicio] " + nombre + " (" + duracionMinutos + " min) - Enfoque: " + grupoMuscular);
    }

    @Override
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
