package decorator;

public class CasilleroVipDecorator extends MembresiaDecorator {
    public CasilleroVipDecorator(Membresia membresiaBase) {
        super(membresiaBase);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 20.00;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Casillero VIP Exclusivo";
    }
}
