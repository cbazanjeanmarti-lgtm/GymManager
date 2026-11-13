package decorator;

public class MembresiaBasica implements Membresia {
    @Override
    public double getCosto() {
        return 80.00;
    }

    @Override
    public String getDescripcion() {
        return "Membresía Básica (Acceso a sala de máquinas y cardio)";
    }
}
