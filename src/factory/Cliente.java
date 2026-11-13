package factory;

public class Cliente extends Usuario {
    private String objetivoFitness;

    public Cliente(String id, String nombre, String email, String objetivoFitness) {
        super(id, nombre, email);
        this.objetivoFitness = objetivoFitness;
    }

    public String getObjetivoFitness() {
        return objetivoFitness;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("[Cliente] ID: " + id + " | Nombre: " + nombre + " | Email: " + email + " | Objetivo: " + objetivoFitness);
    }
}
