package adapter;

public interface ServicioPago {
    boolean procesarPago(String clienteId, double monto, String moneda);
}
