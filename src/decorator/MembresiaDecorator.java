package decorator;

public abstract class MembresiaDecorator implements Membresia {
    protected Membresia membresiaBase;

    public MembresiaDecorator(Membresia membresiaBase) {
        this.membresiaBase = membresiaBase;
    }

    @Override
    public double getCosto() {
        return membresiaBase.getCosto();
    }

    @Override
    public String getDescripcion() {
        return membresiaBase.getDescripcion();
    }
}
