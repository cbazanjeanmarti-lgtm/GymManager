package adapter;

public class PasarelaExternaAPI {
    public int executeRemoteTransaction(String accountToken, double totalAmount, String currencyIsoCode) {
        System.out.println("  [API Externa Banco] Conectando a pasarela bancaria segura...");
        System.out.println("  [API Externa Banco] Cuenta: " + accountToken + " | Débito: " + currencyIsoCode + " " + totalAmount);
        // Retorna 200 si la operación fue exitosa
        return 200;
    }
}
