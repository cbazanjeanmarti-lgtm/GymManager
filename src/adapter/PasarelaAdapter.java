package adapter;

public class PasarelaAdapter implements ServicioPago {
    private PasarelaExternaAPI pasarelaExterna;

    public PasarelaAdapter(PasarelaExternaAPI pasarelaExterna) {
        this.pasarelaExterna = pasarelaExterna;
    }

    @Override
    public boolean procesarPago(String clienteId, double monto, String moneda) {
        String tokenCuenta = "CLI-TOKEN-" + clienteId;
        int codigoRespuesta = pasarelaExterna.executeRemoteTransaction(tokenCuenta, monto, moneda);
        boolean exitoso = (codigoRespuesta == 200);
        if (exitoso) {
            System.out.println("  [Adapter] Pago procesado y conciliado satisfactoriamente.");
        } else {
            System.out.println("  [Adapter] Error al procesar el pago. Código: " + codigoRespuesta);
        }
        return exitoso;
    }
}
