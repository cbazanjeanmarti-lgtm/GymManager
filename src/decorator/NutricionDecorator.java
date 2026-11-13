package decorator;

public class NutricionDecorator extends MembresiaDecorator {
    public NutricionDecorator(Membresia membresiaBase) {
        super(membresiaBase);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 50.00;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Asesoría Nutricional Personalizada";
    }
}
