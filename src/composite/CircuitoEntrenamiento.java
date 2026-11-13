package composite;

import java.util.ArrayList;
import java.util.List;

public class CircuitoEntrenamiento implements ComponenteEntrenamiento {
    private String nombre;
    private List<ComponenteEntrenamiento> componentes = new ArrayList<>();

    public CircuitoEntrenamiento(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteEntrenamiento componente) {
        componentes.add(componente);
    }

    public void remover(ComponenteEntrenamiento componente) {
        componentes.remove(componente);
    }

    @Override
    public void ejecutar() {
        System.out.println("  [Circuito / Bloque] " + nombre + " (Total estimado: " + getDuracionMinutos() + " min):");
        for (ComponenteEntrenamiento item : componentes) {
            item.ejecutar();
        }
    }

    @Override
    public int getDuracionMinutos() {
        int total = 0;
        for (ComponenteEntrenamiento item : componentes) {
            total += item.getDuracionMinutos();
        }
        return total;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
