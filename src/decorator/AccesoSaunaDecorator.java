package decorator;

public class AccesoSaunaDecorator extends MembresiaDecorator {
    public AccesoSaunaDecorator(Membresia membresiaBase) {
        super(membresiaBase);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 30.00;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Zona Sauna & Spa";
    }
}
